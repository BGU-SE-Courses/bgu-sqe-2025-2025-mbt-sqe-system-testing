package hellocucumber;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Moodle {
    private WebDriver driver;
    private WebDriverWait wait;

    public void initUserSession(String webDriver, String  path){

        System.setProperty(webDriver,path);

        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));

        driver.get("http://localhost/");
        driver.manage().window().maximize();

        System.out.println("Driver setup finished for - " + driver.getTitle());
    }
    public void initSession(String webDriver, String path) {

        System.setProperty(webDriver, path);

        // new chrome driver object
        this.driver = new ChromeDriver();

        // new web driver wait -> waits until element are loaded (40 sec max)
        Duration timeout = Duration.ofSeconds(15);
        this.wait = new WebDriverWait(driver, timeout);

        // launch website -> localhost
        driver.get("http://localhost/");

        // maximize the window - some web apps look different in different sizes
        driver.manage().window().maximize();
        System.out.println("Driver setup finished for - " + driver.getTitle());
    }
    public void goToLogIn(){
        driver.findElement(By.linkText("Log in")).click();
    }
    public void enterLoginInfo(String userName,String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='username']"))).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='username']"))).sendKeys(userName);
        WebElement webElement = driver.findElement(By.xpath("//*[@id='password']"));
        webElement.sendKeys(password);
        driver.findElement(By.id("loginbtn")).click();
    }
    public void goToCoursePage(String courseName){
        // choose My courses in the menu in the higher part of the page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'My courses') and @role='menuitem']")));
        WebElement myCoursesButton = driver.findElement(By.xpath("//*[contains(text(),'My courses') and @role='menuitem']"));
        myCoursesButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".multiline[title='" + courseName + "']"))).click();
    }
    public void goToChoice(String choiceName){
        String xpathExpression = "//a[contains(@href, 'mod/choice') and .//span[contains(text(), '" + choiceName + "')]]";
        // use the constructed XPath to find the element and click
        WebElement quizLink = driver.findElement(By.xpath(xpathExpression));
        quizLink.click();
    }

    public void chooseOption(String optionName){
        // find the radio button with the given label
        WebElement option = driver.findElement(By.xpath("//*[@id='"+optionName+"']"));
        // click the radio button
        option.click();
    }
    public void saveChoice(){
        // find the submit button and click it
        WebElement submitButton = driver.findElement(By.xpath("//*[contains(@value, \"Save my choice\")]"));
        submitButton.click();
    }

    

}
