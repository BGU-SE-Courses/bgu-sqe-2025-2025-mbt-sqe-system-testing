// @provengo summon ctrl

/**
 * List of events "of interest" that we want test suites to cover.
 */

//first assignment
// in summary, we have 8 {0,1...7} big events.
// we will test the position of the just before writing and just before deletion in the story (i,j)
// i -first element is the position of the write comment in the story - can be in places 2,4,5...6
// j -first element is the position of the delete product in the story - can be in places 2,4,5...6
// there is only 1 event after and 2 before deletion in the manager
// there is only 1 event after and 2 before writing in the user so
// 7>=j>=i>=11 and i!=j
// if i<j the comment dosen't write so its other

//let count_length = 0;
function myRankingFunction(ensemble){
    let count =
        {"2,5": 0 ,"2,6":0 ,"3,5":0,"3,6":0,"4,5":0,"4,6":0,"5,6":0,
                        "other" :0 }
    let count_length= Object.keys(count).length
    let iter = 0;
    let max = 0;
    for (let testIdx = 0; testIdx < ensemble.length; testIdx++) {
        let test = ensemble[testIdx];

        let comPos = commentPos(test);
        if (comPos === -1){
            count["other"]++
        }
        else {
            let delPos = deletePos(test);
            if (delPos!== -1) {
                let pos = `${comPos},${delPos}`
                if (pos in count) {
                    max = Math.max(max, count[pos]++)
                }
                else {
                    count["other"]++
                }
            }
        }
        iter++
    }

    max = Math.max(max-(iter/count_length) , (count["other"]-(iter/2))*2)

    return max * (ensemble.length-(ensemble.length/count_length))/100
}


/**
 * Ranks potential test suites based on the percentage of goals they cover.
 * Goal events are defined in the GOALS array above. An ensemble with rank
 * 100 covers all the goal events.
 *
 * Multiple ranking functions are supported - to change ranking function,
 * use the `ensemble.ranking-function` configuration key, or the
 * --ranking-function <functionName> command-line parameter.
 *
 * @param {Event[][]} ensemble the test suite/ensemble to be ranked
 * @returns the percentage of goals covered by `ensemble`.
 * **/

// function rankingFunction(ensemble) {
//
//     // How many goals did `ensemble` hit?
//     const max_oc = myRankingFunction(ensemble);
//     // What percentage of the goals did `ensemble` cover?
//     //const bestVal = ensemble.length/count_length
//     // const relative_oc  = max_oc - bestVal
//     const max_ocPercent =  100-max_oc ;
//
//     return max_ocPercent ; // convert to human-readable percentage
// }


// const endOfEvent = EventSet("", e.)
function deletePos(test) {
    const filtered = test.filter(e => e.name.startsWith("end of"));
    for (let idx = 0; idx < filtered.length; idx++) {
        if (filtered[idx].name === "end of delete product") {
            return idx
        }
    }
    return -1
}
function commentPos(test){
    const filtered = test.filter(e=> e.name.startsWith("end of"));
    for (let idx = 0; idx < filtered.length; idx++) {
        if (filtered[idx].name === "end of user write comment") {
            return idx
        }
    }
    return -1;
}


const GOALS = [
    "end of user login",
    "end of select the product",
    "end of user write comment",
    "end of go to comment",
    "end of admin login",
    "end of go to all products",
    "end of delete product",
    "end of go to product"
];


function generateGoals(range1, range2) {
    let actions = [];
    for (let i = range1[0]; i <= range1[1]; i++) {
        for (let j = range2[0]; j <= range2[1]; j++) {
            actions.push([GOALS[i], GOALS[j]]);// Each inner array contains one pair
            actions.push([GOALS[j], GOALS[i]]);
        }
    }
    return actions; // Directly return the 2D array
}

function findPos(test, goal) {
    return test.findIndex(e => e.name === goal);
}

// Function to generate pairs only between (0-3, 4-7) and (4-7, 0-3)
function generateRestrictedPairs() {
    let pairs = [];
    for (let i = 0; i <= 3; i++) {
        for (let j = 4; j <= 7; j++) {
            pairs.push([i, j]); // (0-3, 4-7)
            //pairs.push([j, i]); // (4-7, 0-3)
        }
    }
    return pairs;
}

/** Function to rank based on order of occurrences (good - bad)
// good oc = goals (0-3) * (4-7) + (4-5)* (0-3) + (6-7) * (0)  = 4*4 + 2*4 + 2*2 = 26 good pairs
// bad pc = goals (6-7) * (1-3) = 6 bad pairs **/
function twoWayRankingFunction(ensemble) {
    let goodOc = 26;
    let badOc = 6;
    // let both_happened= 0;
    let goodPairTracker = new Set();
    let badPairTracker = new Set();

    let pairs = generateRestrictedPairs(); // Generate valid pairs

    for (let testIdx = 0; testIdx < ensemble.length; testIdx++) {
        let test = ensemble[testIdx];

        for (let [i, j] of pairs) {
            let pos1 = findPos(test, GOALS[i]);
            let pos2 = findPos(test, GOALS[j]);

            if (pos1 !== -1 && pos2 !== -1) { // Both exist in test
                if (pos1 < pos2) { // i before j
                    if (
                        (GOALS[i] === "end of go to product" || GOALS[i] === "end of delete product") &&
                        j >= 1 && j <= 3
                    ) {
                        badPairTracker.add(`${GOALS[i]},${GOALS[j]}`)
                    } else {
                        goodPairTracker.add(`${GOALS[i]},${GOALS[j]}`)

                    }
                }
                else{
                    if (
                        (GOALS[j] === "end of go to product" || GOALS[j] === "end of delete product") &&
                        i >= 1 && i <= 3
                    ) {
                        badPairTracker.add(`${GOALS[j]},${GOALS[i]}`)
                    } else {
                        // Otherwise, it's good
                        goodPairTracker.add(`${GOALS[j]},${GOALS[i]}`)
                    }
                }
            }
        }
    }

    return Math.max(goodPairTracker.size/goodOc - badPairTracker.size/badOc, 0); // Return difference
}

// let makeGoals = generateActions([0, 3], [4, 7]);



function rankingFunction(ensemble) {

    // How many goals did `ensemble` hit?
    const occ = twoWayRankingFunction(ensemble);
    // What percentage of the goals did `ensemble` cover?
    //const bestVal = ensemble.length/count_length
    // const relative_oc  = max_oc - bestVal
    const ocPercent = 100 - (1-occ)*100;

    return ocPercent; // convert to human-readable percentage

}



// /**
//  * Ranks test suites by how many events from the GOALS array were met.
//  * The more goals are met, the higher the score.
//  *
//  * It make no difference if a goal was met more then once.
//  *
//  * @param {Event[][]} ensemble The test suite to be ranked.
//  * @returns Number of events from GOALS that have been met.
//  */
// function rankByMetGoals( ensemble ) {
//     const unreachedGoals = [];
//     for ( let idx=0; idx<GOALS.length; idx++ ) {
//         unreachedGoals.push(GOALS[idx]);
//     }
//
//     for (let testIdx = 0; testIdx < ensemble.length; testIdx++) {
//         let test = ensemble[testIdx];
//         for (let eventIdx = 0; eventIdx < test.length; eventIdx++) {
//             let event = test[eventIdx];
//             for (let ugIdx=unreachedGoals.length-1; ugIdx >=0; ugIdx--) {
//                 let unreachedGoal = unreachedGoals[ugIdx];
//                 if ( unreachedGoal.contains(event) ) {
//                     unreachedGoals.splice(ugIdx,1);
//                 }
//             }
//         }
//     }
//
//     return GOALS.length-unreachedGoals.length;
// }




