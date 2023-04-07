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
        // init elements
        shoppingCart = driver.findElement((By.xpath("//*[@id=\"content\"]/h1")));
        yourShoppingCartIsEmpty = driver.findElement((By.xpath("//*[@id=\"content\"]/p")));
        continueButton = driver.findElement(By.cssSelector("a.btn.btn-primary[href*='common/home']"));
    }

    public WebElement getShoppingCart() {
        return shoppingCart;
    }

    public String getshoppingCartText() {
        return getShoppingCart().getText();
    }

    public WebElement getYourShoppingCartIsEmpty() {
        return yourShoppingCartIsEmpty;
    }

    public String getYourShoppingCartIsEmptyText() {
        return getYourShoppingCartIsEmpty().getText();
    }

    public WebElement getContinueButton() {
        return continueButton;
    }

    public String getContinueButtonText() {
        return getContinueButton().getText();
    }

    public void clickContinueButton() {
        getContinueButton().click();
    }

}
