package FrameworkDesign;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class arrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://rahulshettyacademy.com/client/");

		driver.findElement(By.id("userEmail")).sendKeys("hussainmohsin234@gmail.com");

		driver.findElement(By.id("userPassword")).sendKeys("Test@12345");

		driver.findElement(By.id("login")).click();
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

		List<String> all_elements_text = new ArrayList<>();

		for (int i = 0; i < products.size(); i++) {

			// loading text of each element in to array all_elements_text
			all_elements_text.add(products.get(i).getText());

			// to print directly
			System.out.println(products.get(i).getText());

		}
	}

}
