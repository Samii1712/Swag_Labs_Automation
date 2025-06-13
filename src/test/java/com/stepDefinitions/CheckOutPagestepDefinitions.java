package com.stepDefinitions;

import base.BaseTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import pages.CheckoutPage;
public class CheckOutPagestepDefinitions {

	@Then("Enter Order details")
	public void Enter_Order_Details() {
		CheckoutPage.enterCheckoutDetails(BaseTest.getProperty("CustomerFirstName"), BaseTest.getProperty("CustomerLastName"), BaseTest.getProperty("customerCityPinCode"));
	}
    @And("Finish order")
    public void Finish_Order() {
    	CheckoutPage.finishOrder();
    }
    @Then("check is order Complete")
    public void Check_Order_completion() {
    	CheckoutPage.isOrderComplete();
    }
    @And("Take Order confirmation screenshot")
    public void Confirm_Order() {
    	CheckoutPage.confirmOrderbyscreenshot();
    }
}
