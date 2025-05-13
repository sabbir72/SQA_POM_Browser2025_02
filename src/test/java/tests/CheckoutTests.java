package tests;

import base.BaseTest;
import config.Config;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class CheckoutTests extends BaseTest {
    @Test
    public void testCompleteCheckout() {
        // Login and add product to cart
        ProductsPage productsPage = new LoginPage(driver)
                .loginWithValidCredentials(Config.STANDARD_USER, Config.PASSWORD);
        productsPage.addProductToCart("Sauce Labs Backpack");

        // Go through checkout process
//        boolean isComplete = productsPage.goToCart()
//                .proceedToCheckout()
//                .enterShippingInfo("John", "Doe", "12345")
//
//                .finishCheckout()
//                .isCheckoutComplete();

//        Assert.assertTrue(isComplete);
    }
}