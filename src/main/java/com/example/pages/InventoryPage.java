package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {

    private final WebDriver driver;

    @FindBy(css = "span.title")
    private WebElement titleLabel;
    
    // Use the title label as the products heading; the previous XPath sometimes fails to locate the element
    // Keep a single source of truth for the heading

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getTitle() {
        return titleLabel.getText();
    }
    
    public String getProductsHeading() {
        return titleLabel.getText().trim();
    }
    
	/*
	 * public String getproductTitle() { return productLabel.getText(); }
	 */
    		
}
 