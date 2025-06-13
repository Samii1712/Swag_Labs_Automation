/**
 * ProjectName : sauceDemoAutomation Framework
 * File        : CheckoutPage.java
 * Description : Page Object Model class for handling checkout process interactions
 *               on SauceDemo including entering personal info, continuing to summary,
 *               and finishing the order.
 * Author      : Samiksha Soradge
 * Created On  : 01-06-2025
 * Last Updated: 01-06-2025
 */


package pages;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import utils.DriverFactory;

public class CheckoutPage {

	
	public static By firstNameField = By.id("first-name");
	public static By lastNameField = By.id("last-name");
	public static By postalCodeField = By.id("postal-code");
	public static By continueButton = By.id("continue");
	public static By finishButton = By.id("finish");
	public static By checkoutButton = By.id("checkout");
	public static By confirmationMessage = By.className("complete-header");
	
	public static void enterCheckoutDetails(String firstName, String lastName,String postalCode) {
		
		DriverFactory.driver.findElement(firstNameField).sendKeys(firstName);
		DriverFactory.driver.findElement(lastNameField).sendKeys(lastName);
		DriverFactory.driver.findElement(postalCodeField).sendKeys(postalCode);
		DriverFactory.driver.findElement(continueButton).click();
	}
	
	public static void finishOrder() {
		DriverFactory.driver.findElement(finishButton).click();
	}
	
	public static boolean isOrderComplete() {
		return DriverFactory.driver.findElement(confirmationMessage).getText().contains("Thank you for your order!");
		
	}
	
	public static String GetCurrentTimeanddate() {
		LocalDateTime localdatetime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-hh-mm-ss");
		String formattednow = localdatetime.format(formatter);
	return formattednow;
		
	}
	
	public static void confirmOrderbyscreenshot() {
		
		
		Screenshot src= new AShot()
				.shootingStrategy(ShootingStrategies.viewportPasting(500))
				.takeScreenshot(DriverFactory.driver);
		BufferedImage img = src.getImage();
		try {
			ImageIO.write(img, "png", new File("src/OrderDetails/"+GetCurrentTimeanddate()+ "_OrderConfirmed.png"));
		} catch (IOException e) {
			System.out.println("Unable to get screenshot");
			e.printStackTrace();
		}
		
		
	}
}
