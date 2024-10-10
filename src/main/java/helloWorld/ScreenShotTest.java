package helloWorld;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShotTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","./driver2/chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://demo.automationtesting.in/Register.html");
//		1. print screen
//		2. paste
    //	3. save	
//		
		File printScreen = driver.getScreenshotAs(OutputType.FILE);
		
		File paste =new File ("./driver2/img.png");
		
		FileHandler.copy(printScreen, paste);
		
		
//		File printSrc = driver.getScreenshotAs(OutputType.FILE);
//				
//		File paste = new File("./Screenshots/img5.png");
//		
//		FileHandler.copy(printSrc, paste);
//		
		driver.quit();
		
	} 

}
