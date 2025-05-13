package tests;

import base.BaseTest;
import config.Config;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class LoginTests extends BaseTest {
    @Test
    public void testSuccessfulLogin() {
        ProductsPage productsPage = new LoginPage(driver)
                .loginWithValidCredentials(Config.STANDARD_USER, Config.PASSWORD);

        Assert.assertTrue(productsPage.isProductsPageDisplayed());
    }

    @Test
    public void testLockedUserLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(Config.LOCKED_USER);
        loginPage.enterPassword(Config.PASSWORD);
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
        Assert.assertEquals(loginPage.getErrorMessageText(),
                "Epic sadface: Sorry, this user has been locked out.");
    }
}