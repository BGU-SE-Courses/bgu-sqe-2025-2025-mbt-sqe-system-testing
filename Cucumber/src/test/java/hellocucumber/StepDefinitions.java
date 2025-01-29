package hellocucumber;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.junit.jupiter.api.Assertions.*;

public class StepDefinitions {
    
    WebDriver driver;
    String password = "Essa14325!";
    String teacher1 = "athelta";
    String password1 = "Athel12345#";
    String teacher2 = "eliasbs";
    String password2 = "Elias12345#";



    //------------------------------------------------------------------------ Use Case 1 -------------------------------------------------------------------
    @Given("a user with TA permissions exists")
    public void aUserWithTAPermissionsExists() {
        // Initialize WebDriver
        driver = new ChromeDriver();
        driver.get("http://localhost/");

        // Log in as admin to create a user with TA permissions
        driver.findElement(By.xpath("/html/body/div[2]/nav/div/div[2]/div/div/span/a")).click();
        driver.findElement(By.xpath("//*[@id='username']")).sendKeys(teacher1);
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys(password1);
        driver.findElement(By.xpath("//*[@id='loginbtn']")).click();

    }

    @When("the teacher downgrades the user's permissions to Student")
    public void theTeacherDowngradesTheUsersPermissionsToStudent() throws InterruptedException {
        // Navigate to user roles and downgrade permissions
        driver.findElement(By.xpath("/html/body/div[2]/nav/div/div[1]/nav/ul/li[3]/a")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//body/div[2]/div[3]/div[1]/div[2]/div[1]/section[1]/div[1]/aside[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/span[3]/span[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[2]/div[4]/div/div[2]/nav/ul/li[3]/a")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[2]/div[4]/div/div[3]/div/section/div/div[3]/form/div/div[1]/div[3]/table/tbody/tr[1]/td[3]/span/a/span/i")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[2]/div[4]/div/div[3]/div/section/div/div[3]/form/div/div[1]/div[3]/table/tbody/tr[1]/td[3]/span/div[1]/span/span")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[1]/div[2]/span[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[2]/div[4]/div/div[3]/div/section/div/div[3]/form/div/div[1]/div[3]/table/tbody/tr[1]/td[3]/span/ul/li[5]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[2]/div[4]/div/div[3]/div/section/div/div[3]/form/div/div[1]/div[3]/table/tbody/tr[1]/td[3]/span/a[1]/i")).click();

    }



    @Then("the user role in the course is student")
    public void theRoleUpdated() throws InterruptedException {
        // Verify error message or restricted action
        driver.findElement(By.xpath("/html/body/div[2]/nav/div/div[2]/div[3]/div/div/a/span/span/span/span")).click();
        driver.findElement(By.xpath("/html/body/div[2]/nav/div/div[2]/div[3]/div/div/div/div/div/div/a[8]")).click();
        driver.findElement(By.xpath("/html/body/div[2]/nav/div/div[2]/div/div/span/a")).click();
        driver.findElement(By.xpath("//*[@id='username']")).clear();
        driver.findElement(By.xpath("//*[@id='username']")).sendKeys(teacher2);
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys(password2);
        driver.findElement(By.xpath("//*[@id='loginbtn']")).click();
        driver.findElement(By.xpath("/html/body/div[2]/nav/div/div[1]/nav/ul/li[3]/a")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[1]/div[1]/div[1]/a[1]/span[3]/span[2]")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[4]/div/div[2]/nav/ul/li[2]/a")).click();
        boolean ans = driver.findElement(By.xpath("//*[@id='user-index-participants-2_r0_c2']")).getAccessibleName().equals("Student");
        try {
            if (!ans) {
                throw new Exception("baddddd");
            }
        }catch (Exception e){
            System.out.println("bddd");
        }

    }

    //------------------------------------------------------------------------ Use Case 1 Done -------------------------------------------------------------------


    //------------------------------------------------------------------------ Use Case 2 ------------------------------------------------------------------------

    @Given("logging in with the user after making him student")
    public void LoggingIn() {
        driver = new ChromeDriver();
        driver.get("http://localhost/");

        driver.findElement(By.xpath("/html/body/div[2]/nav/div/div[2]/div/div/span/a")).click();
        driver.findElement(By.xpath("//*[@id='username']")).sendKeys(teacher2);
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys(password2);
        driver.findElement(By.xpath("//*[@id='loginbtn']")).click();
    }

    @When("going to course and try but no edit option")
    public void tryToEdit() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[2]/nav/div/div[1]/nav/ul/li[3]/a")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[3]/span[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[2]/nav[1]/ul[1]/li[2]/a[1]")).click();
    }

    @Then("no edit option")
    public void noEdit(){
        driver.findElement(By.xpath("//tbody[1]/tr[1]/td[2]")).findElements(By.xpath("/html/body/div[2]/div[4]/div/div[3]/div/section/div/div[3]/form/div/div[1]/div[3]/table/tbody/tr[1]/td[3]/span/a/span/i")).isEmpty();
        driver.quit();
    }

}
