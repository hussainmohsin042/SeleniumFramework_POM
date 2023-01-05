package FrameworkDesign.Tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import FrameworkDesign.PageObjects.CartPage;
import FrameworkDesign.PageObjects.CheckoutPage;
import FrameworkDesign.PageObjects.ProductCatalogue;
import mohsinhussain.TestComponents.BaseTest;

public class ErrorValidationsTest extends BaseTest {

	@Test(groups= {"ErrorHandling"})

	public void loginErrorValidation() throws IOException, InterruptedException {
		landingpage.loginApplication("hussainmohsin34@gmail.com", "Test@12345");
		Assert.assertEquals("Incorrect email or passsword.", landingpage.getErrorMessage());

	}

	@Test

	public void productErrorValidation() throws IOException, InterruptedException {
		String productName = "ZARA COAT 3";
		ProductCatalogue productcatalogue = landingpage.loginApplication("hussainmohsin234@gmail.com", "Test@12345");
		List<WebElement> products = productcatalogue.getProductList();
		productcatalogue.addProductToCart(productName);
		CartPage cartPage = productcatalogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);
		CheckoutPage checkoutpage = cartPage.goToCheckout();

	}

}
