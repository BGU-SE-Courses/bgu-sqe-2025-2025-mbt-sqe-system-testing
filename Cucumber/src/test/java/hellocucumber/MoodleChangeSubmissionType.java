package hellocucumber;

import io.cucumber.java.Before;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.Select;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MoodleChangeSubmissionType {
    private static WebDriver driver;
    private static WebDriverWait wait;

    public void initSessionAsUser(String webDriver, String path) {
        // webDriver = "webdriver.chrome.driver"
        System.setProperty(webDriver, path);

        // new chrome driver object
        this.driver = new ChromeDriver();

        // new web driver wait -> waits until element are loaded (40 sec max)
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));

        // launch website -> localhost
        driver.get("http://localhost/");
        // maximize the window - some web apps look different in different sizes
        //driver.manage().window().setPosition(new Point(700, 5));
    }


    public void goToLogin() {
        driver.findElement(By.xpath("//*[@id='usernavigation']/div/div/span/a")).click();
    }

    public void goToCreateCourse() {
        driver.findElement(By.xpath("/html/body/div[2]/nav/div/div[1]/nav/ul/li[3]/a")).click();
        driver.findElement(By.xpath("//div[2]/form[1]/button[1]")).click();
    }

    public void goToCreateAssignment() {
        driver.findElement(By.xpath("/html/body/div[2]/nav/div/div[2]/form/div/div/input")).click(); //enable editing
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//li[1]/div[1]/div[2]/div[2]/div[1]/button[1]")).click(); //add an activity or resource
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//div[2]/div[2]/div[1]/div[1]/div[1]/a[1]/div[2]")).click(); //assignment
    }


    public void goToAssignmentSettings() {
        driver.findElement(By.xpath("//div[2]/nav[1]/ul[1]/li[2]/a[1]")).click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void enterLoginInfo(String username, String password) {
        // locate the username input box and enter username
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='username']"))).sendKeys(username);
        // locate the password input box and enter password
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[2]/div[1]/input[1]"))).sendKeys(password);
        // locate Log in button and press
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='loginbtn']"))).click();
        wait.until(ExpectedConditions.titleContains("Dashboard"));
    }

    public void enterNewCourseInfo(String courseName, String courseShortName) {
        // locate the course name input box and enter course name
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='id_fullname']"))).sendKeys(courseName);
        // locate the course short name input box and enter course short name
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='id_shortname']"))).sendKeys(courseShortName);
        // locate the course save and display button and press
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='id_saveanddisplay']"))).click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void enterNewAssignmentInfo(String AssignmentName){
        // locate the course name input box and enter course name
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='id_name']"))).sendKeys(AssignmentName);
        driver.findElement(By.xpath("//*[@id='collapseElement-5']")).click();
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='id_teamsubmission']")));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Yes"); // Select the "Yes" option from the dropdown
                // locate the course short name input box and enter course short name
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='id_submitbutton']"))).click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void enterIndividualAssignmentSettings() {
        driver.findElement(By.xpath("//*[@id='collapseElement-5']")).click();
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='id_teamsubmission']")));
        Select select = new Select(dropdown);
        select.selectByVisibleText("No"); // Select the "Yes" option from the dropdown
        // locate the course short name input box and enter course short name
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='id_submitbutton']"))).click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void confirmSubmissionType() {
        goToAssignmentSettings();
        driver.findElement(By.xpath("//*[@id='collapseElement-5']")).click();
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='id_teamsubmission']")));
        Select select = new Select(dropdown);
        WebElement option = select.getFirstSelectedOption();
        String defaultItem = option.getText();
        System.out.println(defaultItem);
        assert(defaultItem.equals("No"));
    }
}
