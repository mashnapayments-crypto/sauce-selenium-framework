package com.example.tests;

import com.example.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TitleTest extends BaseTest {

    @Test(description = "Validate home page title")
    public void validateTitle() {
        String title = driver.getTitle();
        Assert.assertEquals(title, "Swag Labs", "Page title should be 'Swag Labs'");
    }
}
