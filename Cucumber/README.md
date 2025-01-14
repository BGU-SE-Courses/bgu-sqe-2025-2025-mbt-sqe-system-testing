# Testing Moodle Forum Module using Cucumber


## Running the tests
Run ```mvn test``` to run all the tests.

## Feature files
The behaviors that we tested are in the feature files that inside the [resources/hellocucumber](resources/hellocucumber) directory. See the files for a detailed description of the tests.

Each feature file is designed to be:
- Informative and self-explanatory.
- Easy to read and understand.
- Well-structured, including descriptive "Feature: ...", "Scenario: ...", and "Given/When/Then ..." lines.

Refer to the `moodle_forum_testing.feature` file for an example of a well-written feature file.

## Step files
The step files in the [src/test/java/hellocucumber](src/test/java/hellocucumber) directory contain the code that defines how each sentence in the feature files is translated to Selenium actions. See the files for a detailed description of the implementation.
Best practices followed in the step definitions:
- Clear and meaningful variable names.
- Proper use of WebDriver's explicit waits to ensure reliable test execution.
- Avoidance of magic numbers, making the code maintainable.
- See the [StepDefinitions.java](src/test/java/hellocucumber/StepDefinitions.java) file for an example of a well-documented and well-implemented step file.

## Important note
- if this the first time that you run the test it may fail because all of the pop up tutorials (i mentioned it in the bug section).
- make sure before running the Cucumber tests they is exactly one comment in the fourm with the name "hey1".
- after the deletion of the comment i wrote a script that will add a new comment with the same name so i dont have to add it manually every time (this is for this part only not provengo).