// // @provengo summon ctrl

// /**
//  * List of events "of interest" that we want test suites to cover.
//  */
// const GOALS = [
//     any(/Howdy/),
//     any(/Mars/),
//     Ctrl.markEvent("Classic!")
// ];

// const makeGoals = function(){
//     return [ [ any(/Howdy/), any(/Venus/) ],
//              [ any(/Mars/) ],
//              [ Ctrl.markEvent("Classic!") ] ];
// }

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

//     return GOALS.length-unreachedGoals.length;
// }

// /**
//  * Ranks potential test suites based on the percentage of goals they cover.
//  * Goal events are defined in the GOALS array above. An ensemble with rank
//  * 100 covers all the goal events.
//  *
//  * Multiple ranking functions are supported - to change ranking function,
//  * use the `ensemble.ranking-function` configuration key, or the 
//  * --ranking-function <functionName> command-line parameter.
//  *
//  * @param {Event[][]} ensemble the test suite/ensemble to be ranked
//  * @returns the percentage of goals covered by `ensemble`.
//  */
//  function rankingFunction(ensemble) {
    
//     // How many goals did `ensemble` hit?
//     const metGoalsCount = rankByMetGoals(ensemble);
//     // What percentage of the goals did `ensemble` cover?
//     const metGoalsPercent = metGoalsCount/GOALS.length;

//     return metGoalsPercent * 100; // convert to human-readable percentage
// }


/**
 * List of events "of interest" that we want test suites to cover for two-way
 */
const GOALS = [
    Event('Start(deleteForum)'),
    Event('Start(enterForumAndPostComment)')
];

/**
 * Ranks test suites by how many events from the GOALS array were met.
 * The more goals are met, the higher the score.
 *
 * It make no difference if a goal was met more then once.
 *
 * @param {Event[][]} ensemble The test suite to be ranked.
 * @returns Number of events from GOALS that have been met.
 */
function rankByMetGoals( ensemble ) {
    const unreachedGoals = [];
    // tuples of all combinations in which the events can be executed
    for ( let idx0=0; idx0<GOALS.length; idx0++ ) {
        for (let idx1 = 0; idx1 < GOALS.length; idx1++) {
            if (idx1 !== idx0) {
                unreachedGoals.push([GOALS[idx0], GOALS[idx1]]);
            }
        }
    }
    let unreachedGoalsInitialLength=unreachedGoals.length
    for (let testIdx = 0; testIdx < ensemble.length; testIdx++) {
        let test = ensemble[testIdx];
        for (let ugIdx = unreachedGoals.length - 1; ugIdx >= 0; ugIdx--) {
            let flag = 0;
            let unreachedGoal = unreachedGoals[ugIdx];
            for (let eventIdx = 0; eventIdx < test.length; eventIdx++) {
                let event = test[eventIdx];
                if (unreachedGoal[0].contains(event))
                    flag = 1
                else if (unreachedGoal[1].contains(event) && flag === 1)
                    unreachedGoals.splice(ugIdx, 1);
            }

        }
    }
    return unreachedGoalsInitialLength-unreachedGoals.length;
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
 */
function rankingFunction(ensemble) {
    // How many goals did `ensemble` hit?
    const metGoalsCount = rankByMetGoals(ensemble);
    // What percentage of the goals did `ensemble` cover?
    let goalsCombinationsLength=(GOALS.length)*(GOALS.length-1)
    const metGoalsPercent = metGoalsCount/goalsCombinationsLength;

    return metGoalsPercent * 100; // convert to human-readable percentage
}