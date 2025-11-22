package tests;

import org.testng.annotations.Test;
import utils.Base;

import static utils.HelperFunctions.alertHandler;
import static utils.HelperFunctions.email;

public class RegistrationTest extends Base {

    public void landingOnLoginScreen(){
        homePage.verifyHomePageHeading();
        homePage.clickOnLearningMaterialsTab();
        learningMaterialsPage.verifyLoginScreenIsDisplayed();
        learningMaterialsPage.clickOnSignupButton();
        learningMaterialsPage.verifyCreateAccountButtonIsDisplayed();

    }

    @Test(priority = 1)
    public void passwordMismatchTest() {
        landingOnLoginScreen();
        learningMaterialsPage.enterFirstName("John");
        learningMaterialsPage.enterLastName("Doe");
        learningMaterialsPage.enterRegistrationEmail("email@email.com");
        learningMaterialsPage.enterRegistrationPassword("password123");
        learningMaterialsPage.enterConfirmPassword("password321");
        learningMaterialsPage.clickOnCreateAccountButton();
        alertHandler("Passwords do not match!");
    }

    @Test(priority = 2)
    public void badEmailFormatTest() {
        learningMaterialsPage.enterFirstName("John");
        learningMaterialsPage.enterLastName("Doe");
        learningMaterialsPage.enterRegistrationEmail("emailemail.com");
        learningMaterialsPage.enterRegistrationPassword("password123");
        learningMaterialsPage.enterConfirmPassword("password123");
        learningMaterialsPage.clickOnCreateAccountButton();
        alertHandler("Please enter a valid email address");
    }

    @Test(priority = 3)
    public void passwordLessThan8Test(){
        learningMaterialsPage.enterFirstName("John");
        learningMaterialsPage.enterLastName("Doe");
        learningMaterialsPage.enterRegistrationEmail("email@email.com");
        learningMaterialsPage.enterRegistrationPassword("passwo");
        learningMaterialsPage.enterConfirmPassword("passwo");
        learningMaterialsPage.clickOnCreateAccountButton();
        alertHandler("Password must be at least 8 characters long");
    }

    @Test(priority = 4)
    public void successRegistrationTest(){
        learningMaterialsPage.enterFirstName("John");
        learningMaterialsPage.enterLastName("Doe");
        learningMaterialsPage.enterRegistrationEmail(email);
        learningMaterialsPage.enterRegistrationPassword("password123");
        learningMaterialsPage.enterConfirmPassword("password123");
        learningMaterialsPage.clickOnCreateAccountButton();
        alertHandler("Registration successful! You can now login with your credentials.");
    }

    @Test(priority = 5)
    public void emailAlreadyRegisteredTest(){
        learningMaterialsPage.clickOnSignupButton();
        learningMaterialsPage.enterFirstName("John");
        learningMaterialsPage.enterLastName("Doe");
        learningMaterialsPage.enterRegistrationEmail(email);
        learningMaterialsPage.enterRegistrationPassword("password123");
        learningMaterialsPage.enterConfirmPassword("password123");
        learningMaterialsPage.clickOnCreateAccountButton();
        alertHandler("User with this email already exists");
    }
}
