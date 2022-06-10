package Week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
       WebElement eleusername = driver.findElement(By.id("username"));
       eleusername.sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		//Clicking Contacts tab
		driver.findElement(By.xpath("//a[text()= 'Contacts']")).click();
		//Click on Merge contact
		driver.findElement(By.xpath("//a[text()= 'Merge Contacts']")).click();
		// Clicking on Widget of form contact
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//img[@alt= 'Lookup']) [1]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> newWindow = new ArrayList<String>(windowHandles);
		driver.switchTo().window(newWindow.get(0));
		System.out.println("title is -->" + driver.getTitle());
		// Click on first Row of find Contacts
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@class= 'linktext']) [1]")).click();
		Thread.sleep(1000);
		driver.switchTo().window(newWindow.get(0));
		System.out.println("Title is" + driver.getTitle());
		// Click on Widget of To Contact
		driver.findElement(By.xpath("(//img[@alt= 'Lookup']) [2]")).click();
		Set<String> toWindowHandles = driver.getWindowHandles();
		List<String> newToWindow = new ArrayList<String>(toWindowHandles);
		driver.switchTo().window(newToWindow.get(1));
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[2]/a")).click();
		driver.switchTo().window(newToWindow.get(0));
		
		//clicking on Merge button
				driver.findElement(By.linkText("Merge")).click();
				Alert alert = driver.switchTo().alert();
				alert.accept();

	}

}
