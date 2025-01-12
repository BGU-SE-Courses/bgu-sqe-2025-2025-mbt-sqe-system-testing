package hellocucumber;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Moodle {

    // ====================== static ====================== |
    private static final String WEB_DRIVER_PROPERTY = "webdriver.chrome.driver";
    private static final String MOODLE_URL = "http://localhost/";
    private static final String PATH_TO_WEB_DRIVER = Utils.getRepositoryRootPath() + "chromedriver.exe";
    private static final String PATH_TO_BROWSER_BINARY = Utils.getRepositoryRootPath() + "chrome-win64/chrome.exe";
    static{
       System.setProperty(WEB_DRIVER_PROPERTY, PATH_TO_WEB_DRIVER);
    }
    /* ==================================================== */

    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    public void initSession() {

        // init driver
        ChromeOptions options = new ChromeOptions();
        options.setBinary(PATH_TO_BROWSER_BINARY);
        webDriver = new ChromeDriver(options);

        // init wait
        Duration timeout = Duration.ofSeconds(15);
        webDriverWait = new WebDriverWait(webDriver, timeout);

        // open the moodle page
        webDriver.get(MOODLE_URL);
        webDriver.manage().window().maximize();
    }

    public void goToLogIn(){
        webDriver.findElement(By.linkText("Log in")).click();
    }

    public void enterLoginInfo(String userName,String password){
        WebElement usernameField = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='username']")
        ));
        usernameField.clear();
        usernameField.click();
        usernameField.sendKeys(userName);

        Utils.delay(100);

        WebElement passwordField = webDriver.findElement(
            By.xpath("//*[@id='password']")
        );
        passwordField.clear();
        passwordField.click();
        passwordField.sendKeys(password);
        webDriver.findElement(By.id("loginbtn")).click();
    }

    public void goToCoursePage(String courseName){
        // choose My courses in the menu in the higher part of the page
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//*[contains(text(),'My courses') " +
                                    "and @role='menuitem']"))
        );
        WebElement myCoursesButton = webDriver.findElement(
            By.xpath("//*[contains(text(),'My courses') " +
                                    "and @role='menuitem']")
        );
        myCoursesButton.click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(
            By.cssSelector(".multiline[title='" + courseName + "']"))
        ).click();
    }

    public void goToChoice(String choiceName){
        String xpathExpression = "//a[contains(@href, 'mod/choice') " +
                                    "and .//span[contains(text(), '" + choiceName + "')]]";
        // use the constructed XPath to find the element and click
        WebElement quizLink = webDriver.findElement(By.xpath(xpathExpression));
        quizLink.click();
    }

    public void chooseOption(String optionName){
        // find the radio button with the given label
        WebElement option = webDriver.findElement(
            By.xpath("//*[@id='"+optionName+"']")
        );
        // click the radio button
        option.click();
    }

    public void saveChoice(){
        // find the submit button and click it
        WebElement submitButton = webDriver.findElement(
            By.xpath("//*[contains(@value, \"Save my choice\")]")
        );
        submitButton.click();
    }
}
