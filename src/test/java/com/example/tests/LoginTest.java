package com.example.tests;

import com.example.base.BaseTest;
import com.example.listeners.TestListener;
import com.example.pages.InventoryPage;
import com.example.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {

    @Test(description = "Valid login should land to inventory page")
    public void validLogin() {
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");
        InventoryPage inventory = new InventoryPage(driver);
        Assert.assertEquals(inventory.getTitle(), "PRODUCTS", "Expected to be on PRODUCTS inventory page");
    }

    @Test(description = "Invalid login shows error")
    public void invalidLogin() {
        LoginPage login = new LoginPage(driver);
        login.login("invalid_user", "bad_pass");
        Assert.assertTrue(login.isErrorDisplayed(), "Error message should be displayed for invalid login");
    }
}
