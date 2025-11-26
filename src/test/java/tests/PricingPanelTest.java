package tests;

import org.testng.annotations.Test;
import utils.Base;

public class PricingPanelTest extends Base {

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

    /**@Test(priority = 1)
    public void verifyNoPricingForNoDeviceAndStorageTest() {
        landingOnInventoryForm();
        webAutomationAdvancePage.checkUnitPriceEquals("—");
        webAutomationAdvancePage.checkSubtotalEquals("—");

    }*/

    @Test(priority = 1)
    public void verifyPhoneAnd64GBQty1PricingTest() {
        landingOnInventoryForm();
        webAutomationAdvancePage.selectDeviceType("Phone");
        webAutomationAdvancePage.selectStorage("64GB");
        webAutomationAdvancePage.checkUnitPriceEquals("R400.00");
        webAutomationAdvancePage.checkSubtotalEquals("R400.00");
    }

    @Test(priority = 2)
    public void verifyPhoneAnd128GBQty2PricingTest() {
        webAutomationAdvancePage.selectDeviceType("Phone");
        webAutomationAdvancePage.selectStorage("128GB");
        webAutomationAdvancePage.enterQuantity("2");
        webAutomationAdvancePage.checkUnitPriceEquals("R480.00");
        webAutomationAdvancePage.checkSubtotalEquals("R960.00");
    }

    @Test(priority = 3)
    public void verifyLaptopAnd256GBQty1PricingTest() {
        webAutomationAdvancePage.selectDeviceType("Laptop");
        webAutomationAdvancePage.selectStorage("256GB");
        webAutomationAdvancePage.enterQuantity("1");
        webAutomationAdvancePage.checkUnitPriceEquals("R1,360.00");
    }

    /**@Test(priority = 5)
    public void verifyClearingDeviceResetsPricingTest() {
        webAutomationAdvancePage.selectDeviceType("Select");
        webAutomationAdvancePage.selectStorage("64GB");
        webAutomationAdvancePage.checkUnitPriceEquals("—");
        webAutomationAdvancePage.checkSubtotalEquals("—");
    }*/
}
