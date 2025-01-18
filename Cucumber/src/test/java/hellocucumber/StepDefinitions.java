package hellocucumber;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.*;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;


public class StepDefinitions {
    private final static String dir = System.getProperty("user.dir");
    private final static String CHROME_DRIVER_PATH = dir + "\\..\\Selenium\\chromedriver.exe";

    private final String studentUsername="student";
    private final String studentPassword = "P4$$w0rd";
    private final String teacherUsername="teacher";
    private final String teacherPassword="P4$$w0rd";

    private static ChromeDriver driver;
    private static WebDriverWait wait;


    /*
     ********************* Helper methods *********************
     */
    private void enterEditMode() {
        // xPaths
        String xEditMode = "/html/body/div[2]/nav/div/div[2]/form/div/div";

        // Enter edit mode
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xEditMode))).click();
    }

    private void seleniumClick(String xPath) {
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath))).click();
    }

    private void seleniumSendKeys(String xPath, String keys) {
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath))).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath))).sendKeys(keys);
    }

    private void userLogin(String username, String password) {
        // XPaths
        String xLoginEnter = "//*[@id=\"usernavigation\"]/div/div/span/a";
        String xUsernameInput = "//*[@id=\"username\"]";
        String xPasswordInput = "//*[@id=\"password\"]";
        String xLoginSubmit = "//*[@id=\"loginbtn\"]";

        // Open login window
        seleniumClick(xLoginEnter);

        // Fill in username and password
        seleniumSendKeys(xUsernameInput, username);
        seleniumSendKeys(xPasswordInput, password);

        // Login
        seleniumClick(xLoginSubmit);
    }

    private void enterSQE() {
        // xPaths
        String xMyCourses = "/html/body/div[2]/nav/div/div[1]/nav/ul/li[3]/a";
        String xSQECourse = "/html/body/div[2]/div[3]/div/div[2]/div/section/div/aside/section/div/div/div[1]/div[2]/div/div/div[1]/div/div/div/div/a";

        // Enter the SQE course
        seleniumClick(xMyCourses);
        seleniumClick(xSQECourse);
    }

    private void teacherLogout() {
        // xPaths
        String xOpenDropDown = "//*[@id=\"user-menu-toggle\"]";
        String xLogoutButton = "//*[@id=\"carousel-item-main\"]/a[8]";

        //String xLogoutButton = "//*[@id=\"carousel-item-main\"]/a[7]";
        
        // Open the dropdown menu
        seleniumClick(xOpenDropDown);

        // Click the logout button
        seleniumClick(xLogoutButton);
    }

    private void studentLogout(){
        // xPaths
        String xOpenDropDown = "//*[@id=\"user-menu-toggle\"]";
        String xLogoutButton = "//*[@id=\"carousel-item-main\"]/a[7]";
        
        // Open the dropdown menu
        seleniumClick(xOpenDropDown);

        // Click the logout button
        seleniumClick(xLogoutButton);
    }
    

    /*
     ********************* Actual tests *********************
     */
    @BeforeAll
    public static void before_all() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        driver.manage().window().maximize();
        driver.get("http://localhost/");

    }


    /**
     * student posts comment
     */
     @Given("Forum is opened")
     public void forumIsOpened()
     {
        // XPaths
        String xAddActivity = "//*[@id=\"coursecontentcollapse0\"]/div[2]/div/button/div/span";
        String xForumActivity = "//*[@id=\"all-5\"]/div/div[8]/div/a";
        String xForumName = "//*[@id=\"id_name\"]";
        String xCreateForum = "//*[@id=\"id_submitbutton2\"]";

        // Login as teacher
        userLogin(teacherUsername, teacherPassword);
        
        // Enter the SQE course
        enterSQE();
        
        // Open the forum
        enterEditMode();
        
        seleniumClick(xAddActivity); // Add new activity
        seleniumClick(xForumActivity); // Add new forum
        seleniumSendKeys(xForumName, "forum"); // Set forum name
        seleniumClick(xCreateForum); // Create the forum

        // Logout
        teacherLogout();
     }


    @And("Student is logged in")
    public void studentLogin() {
        userLogin(studentUsername, studentPassword);
    }


    @When("User posts a discussion with subject {string} and body {string} on forum")
    public void postDiscussionOnForum(String subject, String body)
    {
        // xPaths
        String xForum = "/html/body/div[2]/div[4]/div/div[3]/div/section/div/div/div/ul/li[1]/div/div[2]/ul/li[2]/div/div[2]/div[2]/div/div/a";
        String xAddDiscussionTopic = "//*[@id=\"region-main\"]/div[2]/div[1]/div/div[2]/a";
        String xSubjectInput = "//*[@id=\"id_subject\"]";
        String xBodyInput = "//*[@id=\"tinymce\"]";
        String xSubmitPost = "//*[@id=\"id_submitbutton\"]";
        
        String idIframe = "id_message_ifr";

        enterSQE();

        seleniumClick(xForum); // Enter the forum
        seleniumClick(xAddDiscussionTopic); // Add discussion topic
        seleniumSendKeys(xSubjectInput, subject); // Set subject

        // Wwitch to iframe, set body and switch back
        WebElement iframe = driver.findElement(By.id(idIframe));
        driver.switchTo().frame(iframe);
        seleniumSendKeys(xBodyInput, body);
        driver.switchTo().defaultContent();
        
        seleniumClick(xSubmitPost); // Submit post
    }

    @Then("The discussion was posted successfully")
    public void verifyDiscussionIsPosted()
    {
        // xPaths
        String xPost = "/html/body/div[3]/div[4]/div/div[2]/div/section/div[2]/div[2]/div[3]/div/table/tbody/tr";

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (driver.findElements(By.xpath(xPost)).size() == 0) {
            fail("Post not found");
        }

        studentLogout();
    }


    /**
     * TODO: teacher deletes forum
     */


    @Given("The forum Exists")
    public void forumExists(){
        String xForum = "/html/body/div[2]/div[4]/div/div[3]/div/section/div/div/div/ul/li[1]/div/div[2]/ul/li[2]/div/div[2]/div[2]/div/div/a/div/a";
        
        userLogin(teacherUsername, teacherPassword);

        enterSQE();
        
        // Check that the forum exists
        // if (driver.findElements(By.xpath(xForum)).size() == 0) {
        //     fail("Forum not found");
        // }
    }

    @When("The teacher deletes the forum")
    public void deleteForum(){
        String xThreePoints = "/html/body/div[4]/div[5]/div/div[3]/div/section/div/div/div/ul/li[1]/div[1]/div[2]/ul/li[2]/div[2]/div[2]/div[4]/div/div/div/div/a/i";
        String xDelete = "/html/body/div[4]/div[5]/div/div[3]/div/section/div/div/div/ul/li[1]/div[1]/div[2]/ul/li[2]/div[2]/div[2]/div[4]/div/div/div/div/div/a[8]";
        String xSureDelete = "//*[@id=\"page-course-view-topics\"]/div[7]/div[2]/div/div/div[3]/button[2]";
       
        enterEditMode();

        seleniumClick(xThreePoints);

        seleniumClick(xDelete);

        seleniumClick(xSureDelete);

    }

    @Then("The forum is deleted successfully")
    public void checkForumIsDeleted(){
        String xForum = "*[@id=\"module-2\"]/div/div[2]/div[2]/div/div/a";

        // Check that the forum does not exist after deletion
        if (driver.findElements(By.xpath(xForum)).size() > 0) {
            fail("Forum is not deleted");
        }

        teacherLogout(); //Logout to allow for another testing
    }


}