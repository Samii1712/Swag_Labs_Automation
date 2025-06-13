/**
 * ProjectName : sauceDemoAutomation FrameWork
 * File: LoginPage.java
 * Description: Page Object Model class for SauceDemo Login functionality.
 *              Contains element locators and actions for login page.
 * Author: Samiksha Soradge
 * Created On: 01-06-2025
 * Last Updated: 01-06-2025
 */


package pages;

import org.openqa.selenium.By;
import base.BaseTest;
import utils.DriverFactory;

public class LoginPage {

	
	
	public static By usernameField = By.id("user-name");
	public static By passwordField = By.id("password");
	public static By loginButton = By.id("login-button");
	public static By productsText = By.className("title");
	public static By errorMessage = By.cssSelector("h3[data-test='error");
	
	
	public static void enter_URL() {
		DriverFactory.driver.get(BaseTest.getProperty("baseUrl"));
	}
	public static void enterUsernameAndpassword(String username, String password) {
		DriverFactory.driver.findElement(usernameField).sendKeys(username);
		DriverFactory.driver.findElement(passwordField).sendKeys(password);
	}
	

	
	public static void clickLogin() {
		DriverFactory.driver.findElement(loginButton).click();
	}
	
	public static boolean isLoginsuccessful() {
		return DriverFactory.driver.findElement(productsText).isDisplayed();
	}
	
	public static String getErrorMessage() {
		return DriverFactory.driver.findElement(errorMessage).getText();
	}
	
}
