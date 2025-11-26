package pagesObjects;

import org.openqa.selenium.JavascriptExecutor;
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

    @FindBy(xpath = "//input[@type='radio'][@value]")
    List<WebElement> extrasRadioButtons_value_xpath;
    @FindBy(id = "discount-code")
    WebElement discountCode_id;

    @FindBy(id = "apply-discount-btn")
    WebElement applyDiscountButton_id;
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
    @FindBy(id = "unit-price-value")
    WebElement unitPriceValueId;

    @FindBy(id = "subtotal-value")
    WebElement subtotalValueId;

    @FindBy(id = "quantity-label")
    WebElement quantityLabelId;
    @FindBy(id = "base-price-value")
    WebElement basePriceValueId;
    @FindBy(id = "breakdown-quantity-value")
    WebElement breakdownQuantityValueId;
    @FindBy(id = "breakdown-subtotal-value")
    WebElement breakdownSubtotalValueId;
    @FindBy(id = "breakdown-warranty-value")
    WebElement breakdownWarrantyValueValueId;
    @FindBy(id = "breakdown-shipping-value")
    WebElement breakdownShippingValueValueId;
    @FindBy(id = "breakdown-discount-value")
    WebElement breakdownDiscountValueValueId;
    @FindBy(id = "breakdown-total-value")
    WebElement breakdownTotalValueValueId;


    public WebAutomationAdvancePage(WebDriver driver) {
        this.driver = driver;
    }

    public Select selectFromDropdownList(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByVisibleText(value);
        return select;
    }

    public void confirmIfWebAssessmentInventoryFormIsDisplayed() {
        webAssessmentInventoryFormLebed_xpath.isDisplayed();
    }

    public void selectDeviceType(String deviceType) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", deviceType_id);
        deviceType_id.click();
        selectFromDropdownList(deviceType_id, deviceType);
    }

    public void selectBrand(String brand) {
        brand_id.click();
        selectFromDropdownList(brand_id, brand);

    }

    public void selectStorage(String storage) {
        List<WebElement> storageOptions = storageRadioButtons_value_xpath;
        for (WebElement option : storageOptions) {
            if (option.getAttribute("value").equals(storage)) {
                option.click();
                break;
            }
        }
    }

    public void selectShippingAndWarranty(String selection) {
        List<WebElement> storageOptions = extrasRadioButtons_value_xpath;
        for (WebElement option : storageOptions) {
//            System.out.println(option.getAttribute("value"));
            if (option.getAttribute("value").equals(selection)) {
                option.click();
                break;
            }
        }
    }

    public void selectColor(String color) {
        color_id.click();
        selectFromDropdownList(color_id, color);
    }

    public void enterQuantity(String quantity) {
        quantity_id.clear();
        quantity_id.sendKeys(quantity);
    }

    public void enterDeliveryAddress(String email) {
        deliveryAddressId.sendKeys(email);
    }

    public void clickPurchaseButton() {
        purchaseButton_id.click();
    }

    public void orderConfirmationMessage(String expectedMessage) {
        System.out.println(orderPlacedMessage_xpath.getText());
        Assert.assertTrue(
                orderPlacedMessage_xpath.getText().equals(expectedMessage),
                "Expected message: " + expectedMessage + " but got: " + orderPlacedMessage_xpath.getText()
        );

    }

    public void clickNextButton() {
        nextButtonId.click();
    }

    public void clickBackButton() {
        inventoryBackButtonId.click();
    }

    public void clickAddToCartButton() {
        addToCartBackButtonId.click();
    }

    public void verifyAddToCartButtonIsDisplayed() {
        addToCartBackButtonId.isDisplayed();
    }

    public double getUnitPrice() {
        return Double.parseDouble(unitPriceValueId.getText().replace("R", "").replace(",", ""));
    }

    public double getSubtotal() {
        return Double.parseDouble(subtotalValueId.getText().replace("R", "").replace(",", ""));
    }

    public int getQuantity() {
        return Integer.parseInt(quantityLabelId.getText());
    }

    public void checkUnitPriceEquals(String expectedPrice) {
        double expectedUnitPrice = Double.parseDouble(expectedPrice.replace("R", "").replace(",", ""));
        Assert.assertEquals(getUnitPrice(), expectedUnitPrice, "Unit price does not match expected value.");
    }

    public void checkSubtotalEquals(String expectedSubtotal) {
        double expectedSubtotalPrice = Double.parseDouble(expectedSubtotal.replace("R", "").replace(",", ""));
        Assert.assertEquals(getSubtotal(), expectedSubtotalPrice, "Subtotal does not match expected value.");
    }

    public void enterDiscountCode(String discountCode) {
        discountCode_id.sendKeys(discountCode);
    }

    public void clickApplyDiscountButton() {
        applyDiscountButton_id.click();
    }

    public double getBasePrice() {
        return Double.parseDouble(basePriceValueId.getText().replace("R", "").replace(",", ""));
    }
    public double getBreakdownQuantityValue() {
        return Double.parseDouble(breakdownQuantityValueId.getText().replace("R", "").replace(",", ""));
    }
    public double getBreakdownSubtotalValue() {
        return Double.parseDouble(breakdownSubtotalValueId.getText().replace("R", "").replace(",", ""));
    }

    public double getBreakdownWarrantyValue() {
        return Double.parseDouble(breakdownWarrantyValueValueId.getText().replace("R", "").replace(",", ""));
    }
    public double getBreakdownShippingValue() {
        return Double.parseDouble(breakdownShippingValueValueId.getText().replace("R", "").replace(",", ""));
    }
    public double getBreakdownDiscountValue() {
        return Double.parseDouble(breakdownDiscountValueValueId.getText().replace("- R", "").replace(",", ""));
    }
    public double getBreakdownTotalValue() {
        return Double.parseDouble(breakdownTotalValueValueId.getText().replace("R", "").replace(",", ""));
    }

    public void verifyShippingPrice(String expectedShippingPrice) {
        double expectedShippingPriceValue = Double.parseDouble(expectedShippingPrice.replace("R", "").replace(",", ""));
        Assert.assertEquals(getBreakdownShippingValue(), expectedShippingPriceValue, "Shipping price is incorrect.");
    }

    public void verifyWarrantyPrice(String expectedWarrantyPrice) {
        double expectedWarrantyPriceValue = Double.parseDouble(expectedWarrantyPrice.replace("R", "").replace(",", ""));
        Assert.assertEquals(getBreakdownWarrantyValue(), expectedWarrantyPriceValue, "Warranty price is incorrect.");
    }
    public void calculateTotalPrice() {
        double subtotal = getBasePrice() * getBreakdownQuantityValue();
        double total = subtotal + getBreakdownWarrantyValue() + getBreakdownShippingValue() - getBreakdownDiscountValue();
        System.out.println("Calculated Total: R" + total + "and actual Total: R" + getBreakdownTotalValue());
        Assert.assertEquals(getBreakdownTotalValue(), total, "Total price calculation is incorrect.");
    }

}
