package hellocucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class QuizAttemptActurator {

    private WebDriver driver;
    private WebDriverWait wait;

    public void initSessionAsUser(String webDriver, String  path){

        System.setProperty(webDriver,path);

        this.driver = new ChromeDriver();
        
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));

        driver.get("http://localhost/");
        driver.manage().window().setPosition(new Point(700, 5));

        System.out.println("Init Finished");
    }

    public void logIn(String Username, String password){
        // navigate to log in
        driver.findElement(By.linkText("Log in")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='username']"))).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='username']"))).sendKeys(Username);

        WebElement webElement = driver.findElement(By.xpath("//*[@id='password']"));
        webElement.sendKeys(password);

        driver.findElement(By.id("loginbtn")).click();

    }
    
}
