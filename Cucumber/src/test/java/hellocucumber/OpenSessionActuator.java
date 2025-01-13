package hellocucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class OpenSessionActuator {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    private final String goToLoginPageXpath = "/html/body/div[2]/nav/div/div[2]/div/div/span/a";
    private final String usernameTextboxXpath = "/html/body/div[2]/div[2]/div/div/section/div/div/div/div/form[1]/div[1]/input";
    private final String passwordTextboxXpath = "/html/body/div[2]/div[2]/div/div/section/div/div/div/div/form[1]/div[2]/div/input";
    private final String loginButtonXpath = "/html/body/div[2]/div[2]/div/div/section/div/div/div/div/form[1]/div[3]/button";
    private final String myCoursesButtonXpath = "/html/body/div[2]/nav/div/div[1]/nav/ul/li[3]/a";
    private final String searchCourseTextboxXpath = "/html/body/div[2]/div[3]/div/div[2]/div/section/div/aside/section/div/div/div[1]/div[1]/div/div[2]/div/div/input";

    public void initSession(String webDriver, String path) {
        System.setProperty(webDriver, path);

        // new chrome driver object
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        this.driver = new ChromeDriver(options);

        // new web driver wait -> waits until element are loaded (40 sec max)
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));

        // launch website -> localhost
        driver.get("http://localhost");

        // maximize the window - some web apps look different in different sizes
        driver.manage().window().maximize();

        System.out.println("Driver setup finished for - " + driver.getTitle());
    }

    protected void waitToLoad(int millis) {
        try {
            Thread.sleep(millis);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void GoToLogin() {
        driver.findElement(By.xpath(goToLoginPageXpath)).click();
    }

    public void EnterLoginInfo(String username, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(usernameTextboxXpath))).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(passwordTextboxXpath))).sendKeys(password);
        driver.findElement(By.xpath(loginButtonXpath)).click();
        waitToLoad(500);
    }

    public void GoToMyCoursesPage() {
        driver.findElement(By.xpath(myCoursesButtonXpath)).click();
        waitToLoad(500);
    }

    protected void searchCourse(String course) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchCourseTextboxXpath))).sendKeys(course);
        waitToLoad(3000);
    }
}