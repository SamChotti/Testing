package helloWorld;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class RetriveTest {
    public static void main(String[] args) {
        // Set up ExtentReports
        ExtentSparkReporter spark = new ExtentSparkReporter("extentReport.html");
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(spark);
        ExtentTest test = extent.createTest("Amazon Product Search", "Search for iPhone 16 on Amazon");

        // Set the path for your WebDriver executable
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        
        test.info("Browser opened");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.amazon.in/");
        test.info("Navigated to Amazon India");

        // Wait until the search bar is visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));

        // Enter "iPhone 16" in the search bar
        searchBox.sendKeys("iPhone 16");
        searchBox.submit();
        test.info("Search for iPhone 16 initiated");

        // Wait for results to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".s-main-slot")));

        // Initialize product count
        int totalProductCount = 0;

        // Loop through and print product names
        boolean hasNextPage = true;
        while (hasNextPage) {
            // Get product names
            List<WebElement> productNames = driver.findElements(By.cssSelector(".s-main-slot h2 span"));

            // Print and log product names
            for (WebElement product : productNames) {
                String productName = product.getText();
                System.out.println(productName);
                test.info("Product: " + productName);
                totalProductCount++;
            }

            // Check if there's a next page button
            try {
                WebElement nextPageButton = driver.findElement(By.cssSelector(".s-pagination-next"));
                if (nextPageButton.isDisplayed() && nextPageButton.isEnabled() && !nextPageButton.getAttribute("class").contains("s-pagination-disabled")) {
                    nextPageButton.click(); // Go to next page
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".s-main-slot"))); // Wait for new results
                } else {
                    hasNextPage = false; // No more pages
                }
            } catch (Exception e) {
                hasNextPage = false; // No next page button found or an error occurred
                test.warning("Exception occurred while checking next page: " + e.getMessage());
            }
        }

        driver.quit(); // Close the browser after completing the loop
        test.pass("Test completed");
        test.info("Total products retrieved: " + totalProductCount);

        // Write the report to file
        extent.flush();
    }
}
