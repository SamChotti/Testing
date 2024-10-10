package helloWorld;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://demo.automationtesting.in/Register.html");
		driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input")).sendKeys("Sam");
		driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[2]/input")).sendKeys("Ashik");
		driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[2]/div/textarea")).sendKeys("No: 18, MGR Nagar, Saidapet, Chennai.");
		driver.findElement(By.id("eid")).click();
		driver.findElement(By.xpath("//*[@id=\"eid\"]/input")).sendKeys("test@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[4]/div/input")).sendKeys("9876543210");
		driver.findElement(By.name("radiooptions")).click();
		driver.findElement(By.id("checkbox1")).click();
		driver.findElement(By.id("checkbox2")).click();
		driver.findElement(By.id("Skills")).click();		
		driver.findElement(By.xpath("//*[@id=\"Skills\"]/option[3]")).click();
		driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[10]/div/span")).click();
		driver.findElement(By.xpath("//*[@id=\"country\"]/option[4]")).click();
		driver.findElement(By.id("yearbox")).click();
		driver.findElement(By.xpath("//*[@id=\"yearbox\"]/option[85]")).click();
		driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[11]/div[2]/select")).click();
		driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[11]/div[2]/select/option[6]")).click();
		driver.findElement(By.id("daybox")).click();
		driver.findElement(By.xpath("//*[@id=\"daybox\"]/option[12]")).click();
		driver.findElement(By.id("firstpassword")).sendKeys("Sam@12345678");
		driver.findElement(By.id("secondpassword")).sendKeys("Sam@12345678");
		driver.findElement(By.id("submitbtn")).click();
		driver.close(); 
	
	}

}
