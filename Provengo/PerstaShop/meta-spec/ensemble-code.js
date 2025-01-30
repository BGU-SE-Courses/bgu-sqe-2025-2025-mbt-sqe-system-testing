// @provengo summon ctrl

/**
 * List of events "of interest" that we want test suites to cover.
 */
const GOALS = [
    any("Begin(UserLogin)"),
    any("Begin(addProductToCartTwice)"),
    any("Begin(VerifyQuantity)"),
    any("End(addProductToCartTwice)"),
    any("End(adminChangeQuantity)"),
    any("End(adminVerifyQuantity)"),
 
];
//commit push
const GOALS_two_way = [
    any("Begin(UserLogin)"),
    any("Begin(adminVerifyQuantity)"),
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
 * Ranks test suites by how many times it hits events from the GOALS array.
 * The more hits, the higher the score.
 * @param {Event[][]} ensemble The test suite to be ranked.
 * @returns Number of times an event from GOALS has been met.
 */

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
    // const metGoalsCount = rankByMetGoals(ensemble);
    // const metGoalsPercent = metGoalsCount/GOALS.length;
    // return metGoalsPercent * 100; // convert to human-readable percentage
    return ranking_function_two_way(ensemble);
}

/**
 * Alternative ranking method to count unique event pairs.
 * Helps measure transition coverage in tests.
 */
function ranking_function_two_way(ensemble) {
    let set = new Set(); // Set to store unique event transitions
    // Iterate over each test case in the ensemble
    ensemble.forEach(test => {
        // Iterate through the events in the test case (excluding the last one)
        test.slice(0, -1).forEach((event, index) => {
            // Add the transition (current event -> next event) to the set
            set.add(`${event},${test[index + 1]}`);
        });
    });

    return set.size; // Return the number of unique transitions
}