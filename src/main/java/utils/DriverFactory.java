/**
 * ProjectName : sauceDemoAutomation Framework
 * File        : DriverFactory.java
 * Description : Provides methods to initialize and quit WebDriver instances.
 *               Supports cross-browser setup using browser name from config.properties file.
 * Author      : Samiksha Soradge
 * Created On  : 01-06-2025
 * Last Updated: 01-06-2025
 */

package utils;

import java.time.Duration;


import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {
	
	static Logger log = Logger.getLogger(DriverFactory.class);
	public static RemoteWebDriver driver;

	public static ChromeOptions options = new ChromeOptions();

	public static RemoteWebDriver launchBrowser(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			
			ChromeOptions options = new ChromeOptions();
            log.info("Launching chrome Browser...");
			// 🔧 Disable automation and password-related popups
		    options.addArguments("--disable-save-password-bubble");
			options.addArguments("--disable-notifications");
			options.addArguments("--disable-popup-blocking");
			options.addArguments("--incognito");
		
			driver = new ChromeDriver(options);

		} else if (browserName.equalsIgnoreCase("Microsoft edge")) {
			driver = new EdgeDriver();
			 log.info("Launching Microsoft edge Browser...");

		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			 log.info("Launching firefox Browser...");

		} else {
			log.error("Error: Invalid browser name: " + browserName + ". Defaulting to Chrome.");

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		return driver;
	}

	public static void quitDriver() {
		if (driver != null) {
			driver.quit();
		}
	}
}
