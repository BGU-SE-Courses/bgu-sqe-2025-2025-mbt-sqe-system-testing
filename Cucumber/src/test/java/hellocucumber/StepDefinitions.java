package hellocucumber;

import io.cucumber.java.en.*;

import org.junit.jupiter.api.Assertions.*;

public class StepDefinitions {
    private QuizAttemptActurator acturator;
    private String webDriver = "webdriver.chrome.driver";
    private String path = "/Users/amitlewinz/WorkSpace/2025-mbt-aq/Selenium/chromedriver.exe";

    public void openMoodleInitStudent(){
        System.out.println("Open Moodle at WebPage");
        acturator = new QuizAttemptActurator();
        acturator.initSessionAsUser(webDriver, path);
    }


    // 
    @Given("User is inside the Moodle Home Page")
    public void userIsInsideTheMoodleHomePage() {
        openMoodleInitStudent();
    }

    // 
    @And("Student is logged in with \"<Username>\" and \"<Password>\"")
    public void logIn(String Username, String Password) {
        acturator.logIn(Username, Password);
    }

    

    // 
    @When("all step definitions are implemented")
    public void allStepDefinitionsAreImplemented() {
    }

    // 
    @Then("the scenario passes")
    public void theScenarioPasses() {
    }

}
