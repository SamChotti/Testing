package helloWorld;

import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleScreenshotTest {
	
	public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        
        driver.get("https://demo.automationtesting.in/Register.html");
        ScreenshotUtil.takeScreenshot(driver, "./Screenshots/img9.png");
        
        driver.get("https://google.com");
        ScreenshotUtil.takeScreenshot(driver, "./Screenshots/img10.png");
        
        driver.get("https://www.youtube.com/");
        ScreenshotUtil.takeScreenshot(driver, "./Screenshots/img9.png");
        
        driver.get("https://indianrailways.gov.in/");
        ScreenshotUtil.takeScreenshot(driver, "./Screenshots/img11.png");
        
        driver.quit();
        
	}        
        
}
