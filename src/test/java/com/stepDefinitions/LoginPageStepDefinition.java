package com.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginPageStepDefinition {

	@Given("Enter Url")
	public void EnterURL() {
		LoginPage.enter_URL();
	}
	
	@And("Enter username {string} and password {string}")
	public void Enter_Username_And_Password(String username , String password) {
		LoginPage.enterUsernameAndpassword(username, password);
	}
	
	@When("click on Login")
	public void Click_On_Login() {
		LoginPage.clickLogin();
	}
	@Then("Check is Login successfull")
	public void Check_Successfull_Login() {
		LoginPage.isLoginsuccessful();
	}
}
