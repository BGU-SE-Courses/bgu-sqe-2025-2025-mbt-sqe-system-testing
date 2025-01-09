package hellocucumber;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StepDefinitions {
    private  static List<Moodle> allOpenMoodle;
    private static  Moodle moodleUser;
    private String webDriver = "webdriver.chrome.driver";
    private WebDriver driver;
    private final int homePageNumber=1;


//    private String path = "C:\\Users\\saada\\Desktop\\OrStudys\\שנה ג\\סמסטר א\\הנדסת איכות תוכנה\\פרויקט\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe";
    private String path = "C:\\Users\\idana\\OneDrive\\Desktop\\לימודים\\איכות תוכנה\\assignment4\\2025-mbt-r\\Selenium\\operadriver.exe";
    public void OpenMoodleInit(int windowFlag){
    System.out.println("--------------- INITIALIZING MOODLE TEST - OPENING WEBPAGE ---------------");
        if(allOpenMoodle == null)
             allOpenMoodle = new ArrayList<>();
        moodleUser = new Moodle();
        allOpenMoodle.add(moodleUser);
        moodleUser.initSession(webDriver,path);
    }

    @Given("User is on Home page")
    public void user_is_on_home_page() {
        OpenMoodleInit(homePageNumber);
    }
    @When("Student is logged in with {string} and {string}")
    public void userIsLoggedIn(String userName, String password) {
        moodleUser.goToLogIn();
        moodleUser.enterLoginInfo(userName,password);
    }
    @And("the student navigates to the {string} course page")
    public void theStudentNavigatesToTheCoursePage(String courseName) {
        moodleUser.goToCoursePage(courseName);
    }

    @And("the student clicks on the choice titled {string}")
    public void theStudentClicksOnTheChoiceTitled(String choiceName) {
        moodleUser.goToChoice(choiceName);
    }
    @And("the student clicks on the choice option titled {string}")
    public void theStudentClicksOnTheChoiceOptionTitled(String choiceOption) {
        moodleUser.chooseOption(choiceOption);
    }
    @Then("the student should be able to change his choice to {string}")
    public void theStudentShouldBeAbleToChangeHisChoiceTo(String choiceOption) {
        moodleUser.chooseOption(choiceOption);
    }
    @And("the student should be able to save the choice")
    public void theStudentShouldBeAbleToSaveTheChoice() {
        moodleUser.saveChoice();
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
