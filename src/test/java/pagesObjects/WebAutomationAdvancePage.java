package pagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class WebAutomationAdvancePage {

    WebDriver driver;

    @FindBy(id = "tab-btn-web")
    WebElement webAutomationTab_id;
    @FindBy(xpath = "//h3[contains(text(),'Web Assessment: Inventory Form')]")
    WebElement webAssessmentInventoryFormLebed_xpath;
    @FindBy(id = "deviceType")
    WebElement deviceType_id;
    @FindBy(id = "brand")
    WebElement brand_id;
    @FindBy(id = "color")
    WebElement color_id;
    @FindBy(xpath = "//div[@class='field-row']/div[@role='radiogroup']/label/input[@value]")
    List<WebElement> storageRadioButtons_value_xpath;
    @FindBy(id = "quantity")
    WebElement quantity_id;
    @FindBy(id = "address")
    WebElement deliveryAddressId;
    @FindBy(id = "purchase-device-btn")
    WebElement purchaseButton_id;
    @FindBy(xpath = "//h4")
    WebElement orderPlacedMessage_xpath;

    @FindBy(id = "inventory-next-btn")
    WebElement nextButtonId;
    @FindBy(id = "inventory-back-btn")
    WebElement inventoryBackButtonId;
    @FindBy(id = "add-to-cart-btn")
    WebElement addToCartBackButtonId;

    public WebAutomationAdvancePage(WebDriver driver){
        this.driver = driver;
    }

    public Select selectFromDropdownList(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByVisibleText(value);
        return select;
    }

    public void confirmIfWebAssessmentInventoryFormIsDisplayed(){
        webAssessmentInventoryFormLebed_xpath.isDisplayed();
    }

    public void selectDeviceType(String deviceType){
        deviceType_id.click();
        selectFromDropdownList(deviceType_id, deviceType);
    }

    public void selectBrand(String brand) {
        brand_id.click();
        selectFromDropdownList(brand_id, brand);

    }

    public void selectStorage(String storage){
        List<WebElement> storageOptions = storageRadioButtons_value_xpath;
        for (WebElement option : storageOptions) {
            if (option.getAttribute("value").equals(storage)) {
                option.click();
                break;
            }
        }
    }

    public void selectColor(String color){
        color_id.click();
        selectFromDropdownList(color_id, color);
    }

    public void enterQuantity(String quantity){
        quantity_id.clear();
        quantity_id.sendKeys(quantity);
    }
    public void enterDeliveryAddress(String email){
        deliveryAddressId.sendKeys(email);
    }

    public void clickPurchaseButton(){
        purchaseButton_id.click();
    }

    public void orderConfirmationMessage(String expectedMessage){
        System.out.println(orderPlacedMessage_xpath.getText());
        Assert.assertTrue(
                orderPlacedMessage_xpath.getText().equals(expectedMessage),
                "Expected message: " + expectedMessage + " but got: " + orderPlacedMessage_xpath.getText()
        );

    }

    public void clickNextButton(){
        nextButtonId.click();
    }

    public void clickBackButton(){
        inventoryBackButtonId.click();
    }
    public void clickAddToCartButton(){
        addToCartBackButtonId.click();
    }

    public void verifyAddToCartButtonIsDisplayed(){
        addToCartBackButtonId.isDisplayed();
    }

}
