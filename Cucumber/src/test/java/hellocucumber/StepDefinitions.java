package hellocucumber;

import io.cucumber.java.en.*;

import org.junit.jupiter.api.Assertions.*;

public class StepDefinitions {
    private QuizAttemptActurator first_scenario_acturator;
    private QuizAttemptActurator second_scenario_acturator;
    private QuizAttemptActurator third_scenario_acturator;
    private String webDriver = "webdriver.chrome.driver";
    private String path = "/opt/homebrew/bin/chromedriver";

    // Initialize the session for the student
    public void openMoodleInitStudent(){
        System.out.println("Open Moodle at WebPage");
        first_scenario_acturator = new QuizAttemptActurator();
        first_scenario_acturator.initSessionAsUser(webDriver, path);
    }

    // Step to navigate to the Moodle Home Page for the student
    @Given("User is inside the Moodle Home Page")
    public void userIsInsideTheMoodleHomePage() {
        openMoodleInitStudent();
    }

    // Step for student login with credentials
    @And("Student is logged in with {string} and {string}")
    public void logIn(String Username, String Password) {
        first_scenario_acturator.logIn(Username, Password);
    }

    // Step for student navigating to a specific course
    @When("Student navigates to the {string}")
    public void studentNavigaresToTheCourse(String courseName) {
        first_scenario_acturator.navigateToCourse(courseName);
    }

    // Step for student selecting a quiz
    @And("Student selects the quiz {string}")
    public void studentSelectsTheQuiz(String quizName) {
        first_scenario_acturator.selectQuiz(quizName);
    }

    // Step for student clicking to start a quiz attempt
    @And("Student clicks \"start attemp\"")
    public void studentClickesStartAttemp() {
        first_scenario_acturator.startQuiz();
    }

    // Step for student answering the quiz questions
    @And("Student answers the quiz questions")
    public void studentAnswersTheQuizQuestions() {
        first_scenario_acturator.answerQuiz();
    }

    // Step for student finishing the quiz attempt
    @And("Student finish attemp")
    public void studentFinishAttemp() {
        first_scenario_acturator.finishQuiz();
    }

    // Step to check that the quiz attempt is marked as "Finished"
    @Then("The quiz attempt is marked as \"Finished\"")
    public void theQuizAttempIsMarkedAsFinished() {
        first_scenario_acturator.markedFinished();
    }

    // Step for student to see the quiz results
    @And("The student sees the quiz results")
    public void theStudenSeesTheQuizResults() {
        first_scenario_acturator.quizResults();
    }

    // Initialize the session for the teacher
    public void openMoodleInitTeacher(){
        System.out.println("Open Moodle at WebPage");
        second_scenario_acturator = new QuizAttemptActurator();
        second_scenario_acturator.initSessionAsUser(webDriver, path);
    }

    // Step for teacher to be on the Moodle Home page
    @Given("Teacher is on Home page")
    public void teacherIsOnHomePage() {
        openMoodleInitTeacher();  
    }

    // Step for teacher login with credentials
    @And("Teacher is logged in with {string} and {string}")
    public void teacherIsLoggedIn(String Username, String Password) {
        second_scenario_acturator.logIn(Username, Password);  
    }

    // Step for teacher navigating to a specific course page
    @And("Teacher navigate to course page {string}")
    public void teacherNavigateToCoursePage(String courseName) {
        second_scenario_acturator.navigateToCourse(courseName);  
    }

    // Verify that the quiz is available for the course
    @And("a quiz titled {string} is available")
    public void aQuizTitledIsAvailableForTheCourse(String quizName) {
        second_scenario_acturator.verifyQuizIsAvailable(quizName);  
    }

    // Step for teacher hiding a specific quiz
    @And("Teacher hide quiz")
    public void teacherHideQuiz() {
        second_scenario_acturator.hideQuiz();  // Teacher hides the specified quiz
    }

    // Step for verifying the quiz is hidden
    @And("quiz should be with hidden status")
    public void quizShouldBeWithHiddenStatus() {
        second_scenario_acturator.verifyQuizIsOnHiddenStatus();  // Verify that the quiz is hidden
    }

    // Step for teacher to log out
    @And("Teacher logged out")
    public void teacherLoggedOut() {
        second_scenario_acturator.logOut();  // Log out the current session
    }

    // Step for student to log in with credentials
    @When("Student log in with {string} and {string}")
    public void studentLogIn(String Username, String Password) {
        openMoodleInitStudent();
        first_scenario_acturator.logIn(Username, Password);  // Student logs in with provided credentials
    }

    // Step for student navigating to a specific course page
    @And("Student navigate to course page {string}")
    public void studentNavigateToCoursePage(String courseName) {
        first_scenario_acturator.navigateToCourse(courseName);  // Student navigates to the specified course
    }

    // Step for student trying to access a quiz and failing
    @Then("Student try to access quiz and fail {string}")
    public void studentTryToAccessQuizAndFailed(String quizName) {
        first_scenario_acturator.failedGoToQuiz(quizName);  
    }

    // Scenario for "Student tries to access the quiz after the deadline"
    public void openMoodleInitForDeadlineScenario(){
        System.out.println("Open Moodle for Deadline Scenario");
        third_scenario_acturator = new QuizAttemptActurator();
        third_scenario_acturator.initSessionAsUser(webDriver, path);  // Initialize session for third scenario
    }

    // Step to initialize the session for the deadline scenario
    @Given("Anon is inside the Moodle Home Page")
    public void anonIsInsideTheMoodleHomePageForDeadline() {
        openMoodleInitForDeadlineScenario();  // Initialize session for the deadline scenario
    }

    // Step for student to log in with credentials for the deadline scenario
    @And("Student is log in with {string} and {string}")
    public void studentIsLoggedInForDeadline(String Username, String Password) {
        third_scenario_acturator.logIn(Username, Password);  // Student logs in for the deadline scenario
    }

    // Step for student navigating to a specific course page for the deadline scenario
    @When("the student navigates to the {string} course page")
    public void studentNavigatesToCoursePageForDeadline(String courseName) {
        third_scenario_acturator.navigateToCourse(courseName);  // Student navigates to the course in deadline scenario
    }

    // Step for student clicking on the quiz in the deadline scenario
    @And("the student clicks on the quiz titled {string}")
    public void studentClicksOnTheQuizForDeadline(String quizTitle) {
        third_scenario_acturator.selectQuiz(quizTitle);  // Student clicks on the quiz in the deadline scenario
    }

    // Step for student seeing a message indicating the quiz is closed
    @Then("The student should not see \"start attemp\" button")
    public void theStudentShouldSeeMessageIndicatingQuizIsClosedForDeadline() {
        third_scenario_acturator.verifyQuizIsClosed();  // Verify the message for closed quiz
    }

}
