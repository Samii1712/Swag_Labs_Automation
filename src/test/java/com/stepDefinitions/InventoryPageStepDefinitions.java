package com.stepDefinitions;

import base.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.InventoryPage;

public class InventoryPageStepDefinitions {

	@And("is Inventory Page displayed")
	public void is_Inventory_Page_Displayed() {
		InventoryPage.isInventoryPageDisplayed();
	}
	
	@Then("add products to cart")
	public void Add_Products_To_cart() {
		InventoryPage.addProductToCart(BaseTest.getProperty("Product1"));
		InventoryPage.addProductToCart(BaseTest.getProperty("product2"));
	}
	
	@And("Go to cart section")
	public void Go_To_cart_Section() {
		InventoryPage.goToCart();
	}
}
