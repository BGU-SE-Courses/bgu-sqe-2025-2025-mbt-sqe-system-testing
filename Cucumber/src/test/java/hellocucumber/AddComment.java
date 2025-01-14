package hellocucumber;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddComment {

    private WebDriver driver;
    private WebDriverWait wait;
    final String URL = "http://localhost:8080/en/";
    final private String WEB_DRIVER = "webdriver.chrome.driver";
    final private String PATH = "/Users/davidvolodarsky/homebrew/bin/chromedriver";

    public void Init() {
        System.out.println("--------------- OPENING WEBPAGE ---------------");
        System.setProperty(WEB_DRIVER, PATH);
        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        driver.get(URL);
        driver.manage().window().maximize();
        System.out.println("Driver setup finished for - " + driver.getTitle());
    }

    public void NavigateToLogin() {
        System.out.println("--------------- EXECUTING NavigateToLogin ---------------");
        driver.findElement(By.linkText("Sign in")).click();
    }

    public void Login(String username, String password) {
        System.out.println("--------------- EXECUTING Login ---------------");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("field-email"))).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("field-password"))).sendKeys(password);
        driver.findElement(By.id("submit-login")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("_desktop_logo"))).click();
    }

    public void VerifyLogin() {
        System.out.println("--------------- VERIFYING Login ---------------");
        driver.findElement(By.linkText("Sign out"));
    }


public void NavigateToProduct(String productName) {
    System.out.println("--------------- SEARCHING AND NAVIGATING TO PRODUCT ---------------");

    // Locate the search bar
    WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.cssSelector("input[placeholder='Search our catalog']")));

    // Enter the product name and press ENTER
    searchBox.clear();
    searchBox.sendKeys(productName + Keys.ENTER);

    // Wait for search results to load
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.products")));

    // XPath for the product title (case-insensitive search)
    String productXPath = "//h2[contains(@class, 'product-title')]/a[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + productName.toLowerCase() + "')]";

    // Wait for the product link to appear and click it
    WebElement productLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(productXPath)));
    productLink.click();

    System.out.println("Navigated to product page of '" + productName + "'.");
}


    public void WriteComment(String title, String body) throws InterruptedException {
        System.out.println("--------------- WRITING COMMENT ---------------");

        driver.manage().window().maximize();
        Thread.sleep(1000);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll down incrementally
            js.executeScript("window.scrollBy(0, document.body.scrollHeight);");
            Thread.sleep(500);


        // Remove fixed headers, footers, and modals
        js.executeScript("document.querySelectorAll('*').forEach(el => { " +
                "if (getComputedStyle(el).position === 'fixed') el.style.display = 'none'; });");
        Thread.sleep(500);

        // Locate the "Write your review" button
        WebElement reviewButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("button.btn.btn-comment.btn-comment-big.post-product-comment")));

        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", reviewButton);
        Thread.sleep(1000);

        // Click the review button
        try {
            js.executeScript("arguments[0].click();", reviewButton);
            System.out.println("Clicked 'Write your review' button.");
        } catch (Exception e) {
            System.out.println("Failed to click 'Write your review' button.");
            return;
        }

        // Fill in the Title
        WebElement titleField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("comment_title")));
        titleField.clear();
        titleField.sendKeys(title);

        // Ensure the body field is interactable
        WebElement bodyField = wait.until(ExpectedConditions.elementToBeClickable(By.id("comment_content")));
        bodyField.clear();
        bodyField.sendKeys(body);
        System.out.println("Filled in the review body.");

//        // Click a star rating (e.g., 4 stars)
        WebElement starRating = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector(".grade-stars .star-full .star:nth-child(4)")));

        js.executeScript("arguments[0].click();", starRating);
        System.out.println("Selected a 4-star rating.");

        // Submit the review
        WebElement sendButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button.btn.btn-comment.btn-comment-big[type='submit']")));
        js.executeScript("arguments[0].scrollIntoView(true);", sendButton);
        js.executeScript("arguments[0].click();", sendButton);

        System.out.println("Comment submitted with title: '" + title + "' and body: '" + body + "'.");
        // Wait for the modal to appear
        Thread.sleep(1000);

    }


    public void VerifyCommentVisible(String productName, String commentTitle, String commentBody) {
        System.out.println("--------------- VERIFYING COMMENT IS VISIBLE ---------------");
        NavigateToProduct(productName);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0, 1000);");

        // Verify the comment title inside <p class="h4"> within .comment-content
        wait.until(ExpectedConditions.textToBePresentInElementLocated(
                By.xpath("//div[contains(@class, 'comment-content')]/p[@class='h4']"), commentTitle));

        System.out.println("Verified the comment title: '" + commentTitle + "'");

    // Verify the comment body inside <p> tag within .comment-content
        wait.until(ExpectedConditions.textToBePresentInElementLocated(
                By.xpath("//div[contains(@class, 'comment-content')]/p[not(@class)]"), commentBody));

        System.out.println("Verified the comment body: '" + commentBody + "'");

    }


    public void VerifyProductExists(String productName) {
    System.out.println("--------------- VERIFYING PRODUCT EXISTS ---------------");

    // Locate the search bar
    WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.cssSelector("input[placeholder='Search our catalog']")));

    // Enter the product name and press ENTER
    searchBox.clear();
    searchBox.sendKeys(productName + Keys.ENTER);

    // Wait for search results to load
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.products")));

    // Updated XPath for case-insensitive match
    String productXPath = "//h2[contains(@class, 'product-title')]/a[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + productName.toLowerCase() + "')]";

    // Wait for the product to appear
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(productXPath)));

    // Verify the product exists
    boolean productExists = !driver.findElements(By.xpath(productXPath)).isEmpty();

    if (!productExists) {
        throw new AssertionError("Product '" + productName + "' does not exist in the store!");
    }

    System.out.println("Product '" + productName + "' exists in the store.");
}



    public void NavigateToAdminLogin() {
        System.out.println("--------------- NAVIGATING TO ADMIN LOGIN ---------------");
        driver.get(URL + "admin");
    }

    public void AdminLogin(String username, String password) {
        System.out.println("--------------- ADMIN LOGIN ---------------");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("passwd"))).sendKeys(password);
        driver.findElement(By.name("submitLogin")).click();
    }

    public void DeleteProduct(String productName) {
        System.out.println("--------------- DELETING PRODUCT ---------------");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Catalog"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Products"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(productName))).click();
        driver.findElement(By.className("delete-product-button")).click();
        driver.switchTo().alert().accept();
    }

    public void VerifyProductDeleted(String productName) {
        System.out.println("--------------- VERIFYING PRODUCT DELETION ---------------");
        driver.findElement(By.id("search_query_top")).sendKeys(productName);
        driver.findElement(By.name("submit_search")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("alert-warning"), "No results were found"));
    }

    public void VerifyCommentNotVisible(String productName, String commentTitle, String commentBody) {
        System.out.println("--------------- VERIFYING COMMENT IS NOT VISIBLE ---------------");

        // Navigate to the product page
        NavigateToProduct(productName);

        // Check if both the comment title and body are present on the page
        boolean isTitlePresent = driver.getPageSource().contains(commentTitle);
        boolean isBodyPresent = driver.getPageSource().contains(commentBody);

        // If either the title or body is still present, throw an error
        if (isTitlePresent || isBodyPresent) {
            throw new AssertionError("Comment with title '" + commentTitle + "' and body '" + commentBody + "' is still visible after product deletion!");
        }

        System.out.println("Comment with title '" + commentTitle + "' and body '" + commentBody + "' is no longer visible.");
    }


    public void Close() {
        System.out.println("--------------- CLOSING DRIVER ---------------");
        driver.quit();
    }
}
