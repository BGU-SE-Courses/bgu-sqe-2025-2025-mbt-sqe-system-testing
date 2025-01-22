// @provengo summon ctrl

/**
 * List of events "of interest" that we want test suites to cover.
 */

const GOALS = [
    any(/end of go to comment/),
    any(/end of delete product/),
    Ctrl.markEvent("confirmation")
];

// const GOALS = [
//     any(/"end of delete product"/),
//     any(/"start delete product"/),
//     any(/end of go to all products/),
//     any(/"start go to all products"/),
//     any(/"end of admin login"/),
//     any(/"start admin login"/),
//     any(/"end of go to comment"/),
//     any(/"start go to comment"/),
//     any(/"end of user write comment"/),
//     any(/"start user write comment"/),
//     any(/"end of select the product"/),
//     any(/"start select the product"/),
//     any(/"end user login"/),
//     any(/"start user login"/),
//     // Ctrl.markEvent("Classic!")
//
// ];


const makeGoals = function(){
    return [
        [ any(/end of delete product/) ],  // Goal for adding a comment
        [ any(/end of go to comment/) ]  // Goal for deleting a product
    ];
}

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
    for ( let idx=0; idx<GOALS.length; idx++ ) {
        unreachedGoals.push(GOALS[idx]);
    }

    for (let testIdx = 0; testIdx < ensemble.length; testIdx++) {
        let test = ensemble[testIdx];
        for (let eventIdx = 0; eventIdx < test.length; eventIdx++) {
            let event = test[eventIdx];
            for (let ugIdx=unreachedGoals.length-1; ugIdx >=0; ugIdx--) {
                let unreachedGoal = unreachedGoals[ugIdx];
                if ( unreachedGoal.contains(event) ) {
                    unreachedGoals.splice(ugIdx,1);
                }
            }
        }
    }

    return GOALS.length-unreachedGoals.length;
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
    const metGoalsPercent = metGoalsCount/GOALS.length;

    return metGoalsPercent * 100; // convert to human-readable percentage
}

