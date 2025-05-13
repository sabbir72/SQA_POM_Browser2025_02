package tests;

import base.BaseTest;
import config.Config;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class ProductTests extends BaseTest {
    @Test
    public void testProductCount() {
        ProductsPage productsPage = new LoginPage(driver)
                .loginWithValidCredentials(Config.STANDARD_USER, Config.PASSWORD);

        Assert.assertEquals(productsPage.getProductCount(), 6);
    }

    @Test
    public void testAddProductToCart() {
        ProductsPage productsPage = new LoginPage(driver)
                .loginWithValidCredentials(Config.STANDARD_USER, Config.PASSWORD);

        productsPage.addProductToCart("Sauce Labs Backpack");
        Assert.assertTrue(productsPage.goToCart().isItemInCart("Sauce Labs Backpack"));
    }
}