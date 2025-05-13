package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitHelper;

public class CheckoutPage {
    private WebDriver driver;

    @FindBy(id = "first-name") private WebElement firstNameField;
    @FindBy(id = "last-name") private WebElement lastNameField;
    @FindBy(id = "postal-code") private WebElement zipCodeField;
    @FindBy(id = "continue") private WebElement continueButton;
    @FindBy(id = "finish") private WebElement finishButton;
    @FindBy(className = "complete-header") private WebElement confirmationMessage;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterShippingInfo(String firstName, String lastName, String zipCode) {
        WaitHelper.waitForElementVisible(driver, firstNameField);
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        zipCodeField.sendKeys(zipCode);
    }

    public void continueToOverview() {
        continueButton.click();
    }

    public void finishCheckout() {
        finishButton.click();
    }

    public String getConfirmationMessage() {
        WaitHelper.waitForElementVisible(driver, confirmationMessage);
        return confirmationMessage.getText();
    }

    public boolean isCheckoutComplete() {
        return getConfirmationMessage().equals("Thank you for your order!");
    }
}