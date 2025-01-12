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
        
    }

    @When("I select {string} in the submission type dropdown")
    public void iSelectInTheSubmissionTypeDropdown(String arg0) {
        
    }

    @And("I save the changes")
    public void iSaveTheChanges() {
        
    }

    @Then("the system should confirm the submission type is set to {string}")
    public void theSystemShouldConfirmTheSubmissionTypeIsSetTo(String arg0) {
        
    }

    @When("I attempt to change the submission type to {string}")
    public void iAttemptToChangeTheSubmissionTypeTo(String arg0) {
        
    }

    @Given("I am logged in as a teacher without editing permissions")
    public void iAmLoggedInAsATeacherWithoutEditingPermissions() {
        
    }

    @Then("I should see an error message stating {string}")
    public void iShouldSeeAnErrorMessageStating(String arg0) {
        
    }

    @And("the backend service fails")
    public void theBackendServiceFails() {
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
