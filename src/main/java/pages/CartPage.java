package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitHelper;

import java.util.List;

public class CartPage {
    private WebDriver driver;

    @FindBy(className = "title") private WebElement pageTitle;
    @FindBy(className = "cart_item") private List<WebElement> cartItems;
    @FindBy(id = "checkout") private WebElement checkoutButton;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isCartPageDisplayed() {
        WaitHelper.waitForElementVisible(driver, pageTitle);
        return pageTitle.getText().equals("Your Cart");
    }

    public int getCartItemCount() {
        return cartItems.size();
    }

    public boolean isItemInCart(String itemName) {
        for (WebElement item : cartItems) {
            if (item.getText().contains(itemName)) {
                return true;
            }
        }
        return false;
    }

    public CheckoutPage proceedToCheckout() {
        checkoutButton.click();
        return new CheckoutPage(driver);
    }
}