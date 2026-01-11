package com.example.tests;

import com.example.base.BaseTest;
import com.example.pages.InventoryPage;
import com.example.pages.LoginPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TitleTest extends BaseTest {

    @Test(description = "Validate home page title")
    public void validateTitle() {
        String title = driver.getTitle();
        Assert.assertEquals(title, "Swag Labs", "Page title should be 'Swag Labs'");
    }
    
    @Test(description= "Validate home page product title")
    public void validateProductTitle() {
    	LoginPage login = new LoginPage(driver);
    	login.login("standard_user", "secret_sauce");
    	InventoryPage inventoryPage = new InventoryPage(driver);
    	String heading = inventoryPage.getProductsHeading();
    	Assert.assertTrue(heading != null && heading.trim().equalsIgnoreCase("Products"), "Page title should be 'Products'");
    }
   
    
}
