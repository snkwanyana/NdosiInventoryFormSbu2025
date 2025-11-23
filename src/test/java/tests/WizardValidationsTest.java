package tests;

import org.testng.annotations.Test;
import utils.Base;

import static utils.HelperFunctions.alertHandler;

public class WizardValidationsTest extends Base {

    public void landingOnInventoryForm(){
        homePage.verifyHomePageHeading();
        homePage.clickOnLearningMaterialsTab();
        learningMaterialsPage.verifyLoginScreenIsDisplayed();
        learningMaterialsPage.enterEmail("sbuda@gmail.com");
        learningMaterialsPage.enterPassword("12345678");
        learningMaterialsPage.clickOnLoginButton();
        learningMaterialsPage.verifyLogoutButtonIsDisplayed();
        learningMaterialsPage.clickOnWebAutomationAdvanceTab();
    }
    @Test(priority = 1)
    public void noDeviceSelectedValidationTest() {
        landingOnInventoryForm();
        webAutomationAdvancePage.clickNextButton();
        alertHandler("Select a device type");
    }

    @Test(priority = 2)
    public void noBrandSelectedValidationTest() {
        webAutomationAdvancePage.selectDeviceType("Laptop");
        webAutomationAdvancePage.clickNextButton();
        alertHandler("Select a brand");
    }

    @Test(priority = 3)
    public void noStorageSelectedValidationTest() {
        webAutomationAdvancePage.selectDeviceType("Laptop");
        webAutomationAdvancePage.selectBrand("Macbook pro");
        webAutomationAdvancePage.clickNextButton();
        alertHandler("Choose storage size");
    }

    @Test(priority = 4)
    public void noQuantityEnteredValidationTest() {
        webAutomationAdvancePage.selectDeviceType("Laptop");
        webAutomationAdvancePage.selectBrand("Macbook pro");
        webAutomationAdvancePage.selectStorage("256GB");
        webAutomationAdvancePage.clickNextButton();
        alertHandler(" Quantity must be ≥ 1");
    }

    @Test(priority = 5)
    public void quantityMustBeLessThanOrEqualToTenValidationTest() {
        webAutomationAdvancePage.selectDeviceType("Laptop");
        webAutomationAdvancePage.selectBrand("Macbook pro");
        webAutomationAdvancePage.selectStorage("256GB");
        webAutomationAdvancePage.enterQuantity("11");
        webAutomationAdvancePage.clickNextButton();
        alertHandler(" Quantity must be ≤ 10");
    }

    @Test(priority = 6)
    public void addressNotEnteredValidationTest() {
        webAutomationAdvancePage.selectDeviceType("Laptop");
        webAutomationAdvancePage.selectBrand("Macbook pro");
        webAutomationAdvancePage.selectStorage("256GB");
        webAutomationAdvancePage.enterQuantity("2");
        webAutomationAdvancePage.clickNextButton();
        alertHandler("Address required");
    }

    @Test(priority = 7)
    public void allFieldsPopulatedTest(){
        webAutomationAdvancePage.selectDeviceType("Laptop");
        webAutomationAdvancePage.selectBrand("Macbook pro");
        webAutomationAdvancePage.selectStorage("256GB");
        webAutomationAdvancePage.enterQuantity("2");
        webAutomationAdvancePage.enterDeliveryAddress("address");
        webAutomationAdvancePage.clickNextButton();
        webAutomationAdvancePage.verifyAddToCartButtonIsDisplayed();
    }

}
