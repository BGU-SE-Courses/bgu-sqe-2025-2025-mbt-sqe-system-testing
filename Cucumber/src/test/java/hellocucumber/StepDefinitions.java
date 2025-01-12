package hellocucumber;

import io.cucumber.java.en.*;

import java.util.ArrayList;
import java.util.List;

public class StepDefinitions {
    private Moodle moodle;

    public void OpenMoodleInit(){
        moodle = new Moodle();
        moodle.initSession();
    }

    @Given("User is on Home page")
    public void user_is_on_home_page() {
        OpenMoodleInit();
    }

    @When("Student is logged in with {string} and {string}")
    public void userIsLoggedIn(String userName, String password) {
        moodle.goToLogIn();
        moodle.enterLoginInfo(userName,password);
    }

    @And("the student navigates to the {string} course page")
    public void theStudentNavigatesToTheCoursePage(String courseName) {
        moodle.goToCoursePage(courseName);
    }

    @And("the student clicks on the choice titled {string}")
    public void theStudentClicksOnTheChoiceTitled(String choiceName) {
        moodle.goToChoice(choiceName);
    }

    @And("the student clicks on the choice option titled {string}")
    public void theStudentClicksOnTheChoiceOptionTitled(String choiceOption) {
        moodle.chooseOption(choiceOption);
    }

    @Then("the student should be able to change his choice to {string}")
    public void theStudentShouldBeAbleToChangeHisChoiceTo(String choiceOption) {
        moodle.chooseOption(choiceOption);
    }

    @And("the student should be able to save the choice")
    public void theStudentShouldBeAbleToSaveTheChoice() {
        moodle.saveChoice();
    }

    // // $$*TODO* explain what this step does$$
    // @Given("an example scenario")
    // public void anExampleScenario() {
    // }

    // // $$*TODO* explain what this step does$$
    // @When("all step definitions are implemented")
    // public void allStepDefinitionsAreImplemented() {
    // }

    // // $$*TODO* explain what this step does$$
    // @Then("the scenario passes")
    // public void theScenarioPasses() {
    // }

}
