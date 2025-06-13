package com.stepDefinitions;

import base.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.CartPage;

public class CartPageStepDefinitions {

	@Then("check Products added into cart or not")
	public void Check_Cart_Products() {
		CartPage.isproductInCart(BaseTest.getProperty("Product1"));
		CartPage.isproductInCart(BaseTest.getProperty("Product2"));
	}
    @And("Click on checkoutButton")
    public void Click_CheckOut_Button() {
    	CartPage.clickCheckoutButton();
    }
}
