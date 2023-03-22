import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Naukri {

	
	@Test
	public void update() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.naukri.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.xpath("//input[contains(@placeholder,\"Username\")]")).sendKeys("n.jorapur1997@gmail.com");
		driver.findElement(By.xpath("//input[contains(@placeholder,\"password\")]")).sendKeys("8618552905");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		driver.findElement(By.xpath("//a[text()='View']")).click();
		File f=new File("./Nagaraj Jorapur-QA-2.8 yrs.pdf");
		String path = f.getAbsolutePath();
		driver.findElement(By.xpath("//input[@id=\"attachCV\"]")).sendKeys(path);
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleContains("Profile"));
		driver.close();
	}
}
