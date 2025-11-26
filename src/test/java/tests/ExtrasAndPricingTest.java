package tests;

import org.testng.annotations.Test;
import utils.Base;

public class ExtrasAndPricingTest extends Base {

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

    @Test
    public void verifyExtrasAndPricingTest() {
        landingOnInventoryForm();

        webAutomationAdvancePage.selectDeviceType("Phone");
        webAutomationAdvancePage.selectBrand("Apple");
        webAutomationAdvancePage.selectStorage("128GB");
        webAutomationAdvancePage.enterQuantity("2");
        webAutomationAdvancePage.enterDeliveryAddress("address");
        webAutomationAdvancePage.clickNextButton();
        webAutomationAdvancePage.verifyAddToCartButtonIsDisplayed();

        webAutomationAdvancePage.selectShippingAndWarranty("standard");
        webAutomationAdvancePage.verifyShippingPrice("R0.00");

        webAutomationAdvancePage.selectShippingAndWarranty("express");
        webAutomationAdvancePage.verifyShippingPrice("R25.00");

        webAutomationAdvancePage.selectShippingAndWarranty("none");
        webAutomationAdvancePage.verifyWarrantyPrice("R0.00");

        webAutomationAdvancePage.selectShippingAndWarranty("1yr");
        webAutomationAdvancePage.verifyWarrantyPrice("R49.00");

        webAutomationAdvancePage.selectShippingAndWarranty("2yr");
        webAutomationAdvancePage.verifyWarrantyPrice("R89.00");

        webAutomationAdvancePage.selectShippingAndWarranty("1yr");
        webAutomationAdvancePage.enterDiscountCode("SAVE10");
        webAutomationAdvancePage.clickApplyDiscountButton();
        webAutomationAdvancePage.calculateTotalPrice();
    }
}
