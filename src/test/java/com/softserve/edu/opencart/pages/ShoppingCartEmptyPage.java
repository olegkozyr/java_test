package com.softserve.edu.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartEmptyPage extends TopPart {
    public static final String EXPECTED_RESULT = "Your shopping cart is empty!";
    private WebElement shoppingCart;
    //
    private WebElement yourShoppingCartIsEmpty;
    private WebElement continueButton;

    public ShoppingCartEmptyPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
//        // init elements
//        slideshow0 = driver.findElement(By.id("slideshow0"));
//        //
//        productsContainer = new ProductsContainer(driver);
//        //productsContainer = new ProductsContainer();
    }
}
