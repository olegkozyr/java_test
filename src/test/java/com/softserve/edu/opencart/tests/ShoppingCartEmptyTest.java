package com.softserve.edu.opencart.tests;


import com.softserve.edu.opencart.pages.HomePage;
import com.softserve.edu.opencart.pages.ShoppingCartEmptyPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingCartEmptyTest extends TestRunnerFirst {
    @Test
    public void checkShoppingCartEmpty() {
        // Steps
        HomePage homePage = loadApplication();
        presentationSleep();

        ShoppingCartEmptyPage shoppingCartEmptyPage = new ShoppingCartEmptyPage(homePage.)

        //
        // Check
        Assert.assertEquals(homePage.getSlideshow0FirstImageAttributeAltText(), HomePage.EXPECTED_IPHONE_6);
        Assert.assertTrue(homePage.getSlideshow0FirstImageAttributeSrcText().contains(HomePage.EXPECTED_IPHONE6));
    }

}
