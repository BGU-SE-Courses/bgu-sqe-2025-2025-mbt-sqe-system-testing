// @provengo summon ctrl

/**
 * List of events "of interest" that we want test suites to cover.
 */
const GOALS = [
  Event("ENDchooseOption2"),
  Event("ENDChangeNotUpdateAbleActivity"),
];

const makeGoals = function(){
    return [
      [Ctrl.markEvent("ENDchooseOption2")],
      [Ctrl.markEvent("ENDChangeNotUpdateAbleActivity")],
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
    for (let idx = 0; idx < TWO_WAY_GOALS.length; idx++) {
      unreachedGoals.push(TWO_WAY_GOALS[idx]);
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

    return TWO_WAY_GOALS.length - unreachedGoals.length;
}

// Two-Way Interaction Goals
const TWO_WAY_GOALS = [
  Event("loginStudent"),
  Event("navigateToCourse"),
  Event("enterActivity"),
  Event("chooseOption2"),
  Event("logoutStudent"),
  Event("loginTeacher"),
  Event("teacherNavigateToCourse"),
  Event("ChangeNotUpdateAbleActivity"),
  Event("logoutTeacher"),
];

const makeTwoWayGoals = function () {
    return [
      [Ctrl.markEvent("loginStudent")],
      [Ctrl.markEvent("navigateToCourse")],
      [Ctrl.markEvent("enterActivity")],
      [Ctrl.markEvent("chooseOption2")],
      [Ctrl.markEvent("logoutStudent")],
      [Ctrl.markEvent("loginTeacher")],
      [Ctrl.markEvent("teacherNavigateToCourse")],
      [Ctrl.markEvent("ChangeNotUpdateAbleActivity")],
      [Ctrl.markEvent("logoutTeacher")]
    ];
};

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

