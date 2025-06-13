/**
 * ProjectName : sauceDemoAutomation Framework
 * File        : InventoryPage.java
 * Description : Page Object Model for Inventory Page. Handles product addition and cart navigation.
 * Author      : Samiksha Soradge
 * Created On  : 01-06-2025
 * Last Updated: 01-06-2025
 */

package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.DriverFactory;

public class InventoryPage {
	
	
	public static  boolean isInventoryPageDisplayed() {
		return DriverFactory.driver.getCurrentUrl().contains("inventory.html");
	}
	
	public static void addProductToCart(String productName) {
		String addToCartButtonXpath = "//div[text()='" + productName + "']/ancestor::div[@class='inventory_item']//button[contains(@class, 'btn_inventory')]";
		DriverFactory.driver.findElement(By.xpath(addToCartButtonXpath)).click();
	}
	
	public static void goToCart() {
		DriverFactory.driver.executeScript("window.scrollTo(0,0)");
		
		DriverFactory.options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
		new WebDriverWait(DriverFactory.driver, Duration.ofSeconds(60)).until(ExpectedConditions.visibilityOfElementLocated(By.className("shopping_cart_link")));
		DriverFactory.driver.findElement(By.className("shopping_cart_link")).click();
	}
	
	
}
