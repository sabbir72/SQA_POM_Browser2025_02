package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitHelper;

import java.util.List;

public class ProductsPage {
    private WebDriver driver;

    @FindBy(className = "title") private WebElement pageTitle;
    @FindBy(className = "inventory_item") private List<WebElement> productItems;
    @FindBy(className = "shopping_cart_link") private WebElement cartIcon;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isProductsPageDisplayed() {
        WaitHelper.waitForElementVisible(driver, pageTitle);
        return pageTitle.getText().equals("Products");
    }

    public int getProductCount() {
        return productItems.size();
    }

    public void addProductToCart(String productName) {
        for (WebElement item : productItems) {
            if (item.getText().contains(productName)) {
                item.findElement(By.tagName("button")).click();
                break;
            }
        }
    }

    public CartPage goToCart() {
        cartIcon.click();
        return new CartPage(driver);
    }

    public String getPageTitle() {
        return pageTitle.getText();
    }
}