package hellocucumber;

import io.cucumber.java.en.*;

import java.util.HashMap;
import java.util.Map;

public class StepDefinitions {
    private final Map<String,Moodle> actorToMoodle = new HashMap<>();

    @Given("{string} is on home page")
    public void userIsOnHomePage(String actor) {
        Moodle moodle = new Moodle();
        moodle.initSession();
        actorToMoodle.put(actor,moodle);
    }

    @When("{string} is logged in with {string} and {string}")
    public void userIsLoggedIn(String actor, String userName, String password) {
        Moodle moodle = actorToMoodle.get(actor);
        moodle.goToLogIn();
        moodle.enterLoginInfo(userName,password);
    }

    @And("the {string} navigates to the {string} course page")
    public void navigateToTheCoursePage(String actor, String courseName) {
        Moodle moodle = actorToMoodle.get(actor);
        moodle.goToCoursePage(courseName);
    }

    @And("the {string} clicks on the choice test titled {string}")
    public void clickOnTheChoiceTestTitled(String actor, String choiceTestName) {
        Moodle moodle = actorToMoodle.get(actor);
        moodle.goToChoice(choiceTestName);
    }

    @And("the {string} clicks on the choice option titled {string}")
    public void clickOnTheChoiceOptionTitled(String actor, String choiceOption) {
        Moodle moodle = actorToMoodle.get(actor);
        moodle.chooseOption(choiceOption);
    }

    @Then("the {string} should be able to change his choice to {string}")
    public void changeChoiceTo(String actor, String choiceOption) {
        Moodle moodle = actorToMoodle.get(actor);
        moodle.chooseOption(choiceOption);
    }

    @And("the {string} should be able to save the choice")
    public void saveTheChoice(String actor) {
        Moodle moodle = actorToMoodle.get(actor);
        moodle.saveChoice();
    }

    @Given("the {string} disables updates for the choice test")
    public void disableUpdatesForTheChoiceTest(String actor) {
        Moodle moodle = actorToMoodle.get(actor);
        moodle.disableUpdatesForChoiceTest();
    }
}
