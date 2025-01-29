package hellocucumber;

import io.cucumber.java.en.*;

import java.util.ArrayList;
import java.util.List;

public class StepDefinitions {

    private static List<MoodleChangeSubmissionType> allOpenCarts;
    private static MoodleChangeSubmissionType moodleUser;
    private static GroupSubmission moodleStudent;
    // private static List<MoodleChangeSubmissionType> allopenCarts;
    private String webDriver = "webdriver.chrome.driver";
    private String path = "C:\\Users\\Gigabyte\\University\\Year4\\QA\\Final Project\\2025-mbt-ag\\Selenium\\chromedriver.exe";

    public void MoodleInitUser() {
        System.out.println("--------------- INITIALIZING MOODLE TEST - OPENING WEBPAGE ---------------");
//        if(allopenCarts == null){
//            allopenCarts = new ArrayList<>();
//        }
        moodleUser = new MoodleChangeSubmissionType();
        //allopenCarts.add(moodleUser);
        moodleUser.initSessionAsUser(webDriver, path);
    }

    public void MoodleInitStudent(){
        System.out.println("--------------- INITIALIZING MOODLE TEST - OPENING WEBPAGE ---------------");
        moodleStudent = new GroupSubmission();
        moodleStudent.initSessionAsUser(webDriver, path);
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

    // -------------------------------------------------------

    @Given("I am logged in as a student")
   public void iAmLoggedInAsAStudent() {
      this.MoodleInitStudent();
   }

   @When("I am logged in as a student with {string} and {string}")
   public void iAmLoggedInAsAStudentWithAnd(String username, String password) {
       moodleStudent.goToLogin();
       moodleStudent.enterLoginInfo(username, password);
   }

//   @And("I navigate to the assignment {string}")
//   public void iNavigateToTheCourse(String assignmentName) {
//        moodleStudent.goToAssignment(assignmentName);
//    }

   @And("I navigate to the assignment {string}")
   public void iNavigateToTheAssignment(String assignmentName) {
      moodleStudent.goToAssignment(assignmentName);
   }

   @And("I click Add submission")
   public void iClickAddSubmission(){
        moodleStudent.addSubmission();
   }

   @And("I write {string} as the answer")
   public void writeText(String text) {
      moodleStudent.writeText("hello");
   }

   @And("I click the submit button")
   public void iClickTheSubmitButton() {
      moodleStudent.submitAssignment();
   }

   @Then("the system should confirm the submission was successful")
   public void theSystemShouldConfirmTheSubmissionWasSuccessful() {
      moodleStudent.confirmSubmissionSuccess();
   }

//   @And("the submission should be visible for all group members of {string}")
//   public void theSubmissionShouldBeVisibleForAllGroupMembers(String groupName) {
//      moodleStudent.confirmGroupSubmissionVisibility(groupName);
//   }

//    @Then("the group submission option should no longer be available")
//    public void theGroupSubmissionOptionShouldNoLongerBeAvailable() {
//       moodleUser.confirmGroupSubmissionUnavailable();
//    }

//    @Then("the system should display an error or message indicating individual submission is required")
//    public void theSystemShouldDisplayAnErrorOrMessageIndicatingIndividualSubmissionIsRequired() {
//       moodleUser.confirmIndividualSubmissionMessage();
//    }

}
