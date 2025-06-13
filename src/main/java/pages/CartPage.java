/**
 * ProjectName : sauceDemoAutomation Framework
 * File        : CartPage.java
 * Description : Page Object Model for Cart Page. Verifies product presence in the cart.
 * Author      : Samiksha Soradge
 * Created On  : 01-06-2025
 * Last Updated: 01-06-2025
 */

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import utils.DriverFactory;

public class CartPage {

	public static boolean isproductInCart(String productName) {
		return DriverFactory.driver.findElements(By.xpath("//div[@class='cart_item']//div[text()='" + productName + "']")).size() > 0;
	}
	
	public static void clickCheckoutButton() {
		DriverFactory.driver.findElement(By.id("checkout")).click();
	}
}
