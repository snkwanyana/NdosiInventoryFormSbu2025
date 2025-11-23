package tests;

import org.testng.annotations.Test;
import utils.Base;

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
    @Test
    public void noDeviceSelectedValidationTest() {

    }
}
