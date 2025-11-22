package tests;

import org.testng.annotations.Test;
import utils.Base;

import static utils.HelperFunctions.alertHandler;

public class LoginTest extends Base {

    public void landingOnLoginScreen(){
        homePage.verifyHomePageHeading();
        homePage.clickOnLearningMaterialsTab();
        learningMaterialsPage.verifyLoginScreenIsDisplayed();

    }
    @Test(priority = 1)
    public void validCredentialsTest() {
        landingOnLoginScreen();
        learningMaterialsPage.enterEmail("sbuda@gmail.com");
        learningMaterialsPage.enterPassword("12345678");
        learningMaterialsPage.clickOnLoginButton();
        learningMaterialsPage.verifyLogoutButtonIsDisplayed();
        learningMaterialsPage.clickOnLogoutButton();
    }

    @Test(priority = 2)
    public void invalidPasswordTest() {
        learningMaterialsPage.enterEmail("sbuda@gmail.com");
        learningMaterialsPage.enterPassword("123456");
        learningMaterialsPage.clickOnLoginButton();
        alertHandler("Invalid email or password");
    }

    @Test(priority = 3)
    public void extraSpacesInCredentialsTest() {
        learningMaterialsPage.enterEmail("sbuda@gmail.com ");
        learningMaterialsPage.enterPassword(" 12345678");
        learningMaterialsPage.clickOnLoginButton();
        learningMaterialsPage.verifyLogoutButtonIsDisplayed();
        learningMaterialsPage.clickOnLogoutButton();
    }

    @Test(priority = 4)
    public void switchTheTabsTest() {
        learningMaterialsPage.enterEmail("sbuda@gmail.com");
        learningMaterialsPage.enterPassword("12345678");
        learningMaterialsPage.clickOnLoginButton();
        learningMaterialsPage.verifyLoginScreenIsDisplayed();
    }

    @Test(priority = 5)
    public void logoutTest(){
        learningMaterialsPage.enterEmail("sbuda@gmail.com");
        learningMaterialsPage.enterPassword("12345678");
        learningMaterialsPage.clickOnLoginButton();
        learningMaterialsPage.verifyLogoutButtonIsDisplayed();
        learningMaterialsPage.clickOnLogoutButton();
    }

}
