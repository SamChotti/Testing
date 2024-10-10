package helloWorld;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import java.io.File;
import java.io.IOException;

public class ScreenshotUtil {

    public static void takeScreenshot(ChromeDriver driver, String filePath) {
        File printSrc = driver.getScreenshotAs(OutputType.FILE);
        File paste = new File(filePath);
        try {
            FileHandler.copy(printSrc, paste);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
