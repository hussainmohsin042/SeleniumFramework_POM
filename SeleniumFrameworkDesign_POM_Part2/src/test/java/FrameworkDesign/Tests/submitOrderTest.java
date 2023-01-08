package FrameworkDesign.Tests;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import FrameworkDesign.PageObjects.CartPage;
import FrameworkDesign.PageObjects.CheckoutPage;
import FrameworkDesign.PageObjects.ConfirmationPage;
import FrameworkDesign.PageObjects.LandingPage;
import FrameworkDesign.PageObjects.OrderPage;
import FrameworkDesign.PageObjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;
import mohsinhussain.TestComponents.BaseTest;

public class submitOrderTest extends BaseTest {
	String productName = "ZARA COAT 3";
	
	@Test(dataProvider = "getData", groups= {"Purchase"})

	public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException {
		
		ProductCatalogue productcatalogue = landingpage.loginApplication(input.get("email"), input.get("password"));
		List<WebElement> products = productcatalogue.getProductList();
		productcatalogue.addProductToCart(input.get("product"));
		CartPage cartPage = productcatalogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckoutPage checkoutpage = cartPage.goToCheckout();
		// checkoutpage.selectCountry("india");
		// ConfirmationPage confirmationpage = checkoutpage.submitOrder();

		// String confirmMessage = confirmationpage.getConfirmationMesage();
		// Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE
		// ORDER."));
	}

	// To verify the ZARA COAT 3 is displaying in orders page

	@Test(dependsOnMethods = { "submitOrder" })
	public void orderHistoryTest() {
		// "ZARA COAT 3";

		ProductCatalogue productcatalogue = landingpage.loginApplication("hussainmohsin234@gmail.com", "Test@12345");
		OrderPage ordersPage=productcatalogue.goToOrdersPage();  
		Assert.assertTrue(ordersPage.VerifyOrderDisplay(productName));
	}

//	@DataProvider
//	public Object[][] getData()
//	{
//		return new Object[][]
//				{{"hussainmohsin234@gmail.com","Test@12345","ZARA COAT 3"},{"hussainmohsin34@gmail.com","Test@12345","ADIDAS ORIGINAL"}};
//		
//		
//		
//	}
	
	@DataProvider
	public Object[][] getData()
	{
		HashMap<String,String> map=new HashMap<String,String>();
		map.put("email", "hussainmohsin234@gmail.com");
		map.put("password","Test@12345");
		map.put("product", "ZARA COAT 3");
		//map.put("email", "hussainmohsin34@gmail.com");
		//map.put("password","Test@12345");
		
		HashMap<String,String> map1=new HashMap<String,String>();
		map1.put("email", "hussainmohsin34@gmail.com");
		map1.put("password","Test@12345");
		map1.put("product", "ADIDA Original");
		//map.put("email", "hussainmohsin34@gmail.com");
		//map.put("password","Test@12345");
		
		
		
		return new Object[][]
		{{map},{map1}};
		
	}
	
}
