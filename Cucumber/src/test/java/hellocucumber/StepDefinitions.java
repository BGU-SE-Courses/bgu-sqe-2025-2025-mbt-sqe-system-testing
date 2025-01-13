package hellocucumber;

import io.cucumber.java.en.*;

import java.util.ArrayList;
import java.util.List;

public class StepDefinitions {

    private static List<MoodleChangeSubmissionType> allOpenCarts;
    private static MoodleChangeSubmissionType moodleUser;
   // private static List<MoodleChangeSubmissionType> allopenCarts;
    private String webDriver = "webdriver.chrome.driver";
    private String path = "C:\\Users\\Daniel\\Documents\\University\\QA\\2025-mbt-ag\\Selenium\\chromedriver.exe";

    public void MoodleInitUser() {
        System.out.println("--------------- INITIALIZING MOODLE TEST - OPENING WEBPAGE ---------------");
//        if(allopenCarts == null){
//            allopenCarts = new ArrayList<>();
//        }
        moodleUser = new MoodleChangeSubmissionType();
        //allopenCarts.add(moodleUser);
        moodleUser.initSessionAsUser(webDriver, path);
    }

    @Given("I am logged in as a teacher")
    public void iAmLoggedInAsATeacher() {
        MoodleInitUser();
    }

    @And("I navigate to the assignment settings page")
    public void iNavigateToTheAssignmentSettingsPage() {
        moodleUser.goToAssignmentSettings();
    }

    @When("I select individual submission in the submission type dropdown making sure to save")
    public void iSelectInTheSubmissionTypeDropdown() {
        moodleUser.enterIndividualAssignmentSettings();
        
    }

    @Then("the system should confirm the submission type is set to individual")
    public void theSystemShouldConfirmTheSubmissionTypeIsSetTo() {
        moodleUser.confirmSubmissionType();
        
    }

    @When("I am logged in with {string} and {string}")
    public void iAmLoggedInWithAnd(String username, String password) {
        moodleUser.goToLogin();
        moodleUser.enterLoginInfo(username, password);
    }

    @And("I create a new course named {string}")
    public void iCreateANewCourse(String courseName) {
        moodleUser.goToCreateCourse();
        moodleUser.enterNewCourseInfo(courseName, "Test");

    }

    @And("I create a new assignment named {string} with submission type set to group")
    public void iCreateANewAssignment(String assignmentName) {
        moodleUser.goToCreateAssignment();
        moodleUser.enterNewAssignmentInfo(assignmentName);
    }
}
