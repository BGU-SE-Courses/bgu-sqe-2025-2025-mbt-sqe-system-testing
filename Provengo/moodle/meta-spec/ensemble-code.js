/**
* GOALS - Defines which events must occur in the system, regardless of the order in which they occur.
* The final score of the tests is determined by how many of the events defined here actually occurred.
* For example, if 2 out of 3 events occurred, the score would be 66%.
*/
const SPECIFIC_GOALS = [
    any("Student_Submission_Complete"),
    any("Teacher_Reduction_Complete"),
    any("End_Specific_Criteria")
];

const TWO_WAY_GOALS = [
// Scenario 1: Teacher limited before second file upload
    any("STUDENT_UPLOAD_COMPLETED_1"),
    any("Teacher_Reduction_Complete"),
    any("Cant_Upload_Second_File_Due_To_Max_Files_Was_Reduced"),
    
    // Scenario 2: Teacher limited after second file upload but before submission
    any("STUDENT_UPLOAD_COMPLETED_1"),
    any("STUDENT_UPLOAD_COMPLETED_2"),
    any("Teacher_Reduction_Complete"),
    any("Submission_Was_Failed_Due_To_Max_Files_Was_Reduced"),
    any("End_Two_Way_Criteria"),
    // Scenario 3: Teacher limited after everything
    any("STUDENT_UPLOAD_COMPLETED_1"),
    any("STUDENT_UPLOAD_COMPLETED_2"),
    any("Student_Submission_Complete"),
    any("Teacher_Reduction_Complete"),

    //  All scenarios have a general completion at the end
    any("End_Two_Way_Criteria"),

];

/**
* makeGoals - Defines the specific order in which the events should occur.
* The success/failure of the tests is determined by the ability to reproduce the exact order defined here.
* For example, if [A,B] was defined and [B,A] occurred, the test will fail even though all events occurred.
*/
const makeGoals = function(){
    if (TEST_TYPE === TEST_TYPES.DOMAIN_SPECIFIC) {
        return [ 
            
            // Test 1: Complete student flow
            {
                name: "Student Full Flow",
                sequence: [any("Student_Logged_In"), any("Student_In_Course_QA"), any("Student_In_Assignment1"), any("Student_Files_Uploaded"), any("Student_Submission_Complete")]
            },
            
            // Test 2: Complete teacher flow
            {
                name: "Teacher Full Flow",
                sequence: [any("Teacher_Logged_In"), any("Teacher_In_Course_QA"), any("Teacher_In_Assignment1"), any("Reduce_Max_Files"), any("Teacher_Reduction_Complete")]
            },
            
            // Test 3: Verify student-teacher order
            {
                name: "Student-Teacher Order",
                sequence: [any("Student_Submission_Complete"), any("Teacher_Reduction_Complete")]
            },
            
            // Test 4: Process completion
            {
                name: "Process Completion",
                sequence: [any("Teacher_Reduction_Complete"), any("End_Specific_Criteria")]
            }
        ];
    }  else if (TEST_TYPE === TEST_TYPES.TWO_WAY) {
        return [ 
            // Test 1: Teacher limited before second file
            {
                name: "Teacher Limited Before Second File",
                sequence: [ any("Student_Submission_Completed_1"), any("Teacher_Reduction_Complete"), any("Cant_Upload_Second_File_Due_To_Max_Files_Was_Reduced"), any("End_Two_Way_Criteria")]
            },
            // Test 2: Teacher limited after upload before submission
            {
                name: "Teacher Limited After Upload Before Submit",
                sequence: [ any("Student_Submission_Completed_1"), any("Student_Submission_Completed_2"), any("Teacher_Reduction_Complete"), any("Submission_Was_Failed_Due_To_Max_Files_Was_Reduced"), any("End_Two_Way_Criteria")]
            },
            // Test 3: Teacher limited after everything
            {
                name: "Teacher Limited After Everything",
                sequence: [ any("Student_Submission_Completed_1"), any("Student_Submission_Completed_2"), any("Student_Submission_Complete"), any("Teacher_Reduction_Complete"), any("End_Two_Way_Criteria")]
            },
            
            {
                name: "Student-Teacher Order",
                sequence: [any("Student_Submission_Complete"), any("Teacher_Reduction_Complete")]
            },
    ];
    }

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
function rankByMetGoals(ensemble) {
    const unreachedGoals = [];
    let relevantGoals;

    if (TEST_TYPE === TEST_TYPES.DOMAIN_SPECIFIC) {
        relevantGoals = SPECIFIC_GOALS;
    } else if (TEST_TYPE === TEST_TYPES.TWO_WAY) {
        relevantGoals = TWO_WAY_GOALS;
    }
    else {
        relevantGoals = SPECIFIC_GOALS; // default to domain-specific
    }
    for (let goal of relevantGoals) {
        unreachedGoals.push(goal);
    }

    for (let testIdx = 0; testIdx < ensemble.length; testIdx++) {
        let test = ensemble[testIdx];
        for (let eventIdx = 0; eventIdx < test.length; eventIdx++) {
            let event = test[eventIdx];
            for (let ugIdx = unreachedGoals.length - 1; ugIdx >= 0; ugIdx--) {
                let unreachedGoal = unreachedGoals[ugIdx];
                if (unreachedGoal.contains(event)) {
                    unreachedGoals.splice(ugIdx, 1);
                }
            }
        }
    }

    return relevantGoals.length - unreachedGoals.length;
}

/**
 * Ranks potential test suites based on the percentage of goals they cover.
 * Goal events are defined in the GOALS array above. An ensemble with rank
 * 100 covers all the goal events.
 *
 * Multiple ranking functions are supported - to change ranking function,
 * use the ensemble.ranking-function configuration key, or the 
 * --ranking-function <functionName> command-line parameter.
 *
 * @param {Event[][]} ensemble the test suite/ensemble to be ranked
 * @returns the percentage of goals covered by ensemble.
 */
function rankingFunction(ensemble) {
    let relevantGoals;
    
    if (TEST_TYPE === TEST_TYPES.DOMAIN_SPECIFIC) {
        relevantGoals = SPECIFIC_GOALS;
    } else if (TEST_TYPE === TEST_TYPES.TWO_WAY) {
        relevantGoals = TWO_WAY_GOALS;
    }
    // How many goals did ensemble hit?
    const metGoalsCount = rankByMetGoals(ensemble);
    // What percentage of the goals did ensemble cover?
    const metGoalsPercent = metGoalsCount/relevantGoals.length;

    return metGoalsPercent * 100; // convert to human-readable percentage
}