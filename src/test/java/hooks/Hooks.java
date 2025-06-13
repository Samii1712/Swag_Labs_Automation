package hooks;

import base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.DriverFactory;

public class Hooks {

	@Before
	public void openBrowser() {
		DriverFactory.launchBrowser(BaseTest.getProperty("browser"));
	}
	
	@After
	public void tearDown() {
		DriverFactory.quitDriver();
	}
}
