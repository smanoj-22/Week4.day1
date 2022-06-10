package Week4.day1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		// Type one pulse 9 pro and hit the button
		WebElement findElement = driver.findElement(By.id("twotabsearchtextbox"));
		findElement.sendKeys("Oneplus 9 pro", Keys.ENTER);
		//Get the Price of First Product
		WebElement price = driver.findElement(By.className("a-price-whole"));
		System.out.println("Price of the first product" + price.getText());
		Thread.sleep(1000);
		// Print the no.of customer ratings for the first displayed product
		driver.findElement(By.xpath("//span[@class= 'a-size-base s-underline-text'] [1]")).getText();
		// Click the first text line of the product
		driver.findElement(By.xpath("//span[text()= 'OnePlus 9 5G (Winter Mist, 12GB RAM, 256GB Storage)']")).click();
		// Take a screenshot of the product displayed
		File source = driver.getScreenshotAs(OutputType.FILE);
		File destination = new File("./oneplus.png");
		FileUtils.copyFile(source, destination);
		//Window Handles
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> NextWindow = new ArrayList<String>(windowHandles);
		driver.switchTo().window(NextWindow.get(1));
		Thread.sleep(1000);
		// Click on 'Add to Cart' Button
		driver.findElement(By.id("add-to-cart-button")).click();
		// Get the cart sub total and verify if it is correct
		Set setSubTotal = driver.getWindowHandles();
		List<String> lstSubTotal = new ArrayList<String>(setSubTotal);
		driver.switchTo().window(lstSubTotal.get(1));
		Thread.sleep(1000);
		String subTotal = driver.findElement(By.id("attach-accessory-cart-total-string")).getText();
		//Checking if the totals are same.
		if(subTotal.equals(subTotal))
		{
			System.out.println("Values or same");
		}
		else {
			System.out.println("values or not same");
		}
	}

}
