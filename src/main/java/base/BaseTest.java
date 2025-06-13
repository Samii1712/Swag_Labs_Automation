/**
 * ProjectName : sauceDemoAutomation FrameWork
 * File: BaseTest.java
 * Description: Base test class for SauceDemo project. Handles WebDriver setup and teardown,
 *              and loads configuration from the properties file.
 * Author: Samiksha Soradge
 * Created On: 01-06-2025
 * Last Updated: 01-06-2025
 */

package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;


import utils.DriverFactory;

public class BaseTest {
	
	static Logger log = Logger.getLogger(BaseTest.class);
	
	public static  Properties config;
	
	
	public  static String getProperty(String key) {
		config = new Properties();
		String value = null;
		try {
			FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
			config.load(fis);
			value = config.getProperty(key);
		} catch (FileNotFoundException e) {
			log.error("Unable to open Properties file");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace(); 
		}
		return value;
	}
	
	
	public void teardown() {
		DriverFactory.quitDriver();
		log.info("Driver closed!");
	}
}


//driver = DriverFactory.launchBrowser(config.getProperty("browser"));
//log.info("Driver launched...");
//driver.get(config.getProperty("baseUrl"));
//log.info("Url is paassed and application is loading....");
