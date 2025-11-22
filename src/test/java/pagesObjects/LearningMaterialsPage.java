package pagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LearningMaterialsPage {

    WebDriver driver;

    @FindBy(xpath = "//span[contains(text(),'Access Learning Materials')]")
    WebElement loginScreenXpath;
    @FindBy(id = "login-email")
    WebElement emailFieldId;

    @FindBy(id = "login-password")
    WebElement passwordFieldId;

    @FindBy(id = "login-submit")
    WebElement loginButtonId;

    @FindBy(id = "signup-toggle")
    WebElement signupButtonId;

    @FindBy(id = "logout-button")
    WebElement logoutButtonId;

    /** Registratin page elements added here **/

    @FindBy(id = "register-firstName")
    WebElement firstNameFieldId;
    @FindBy(id = "register-lastName")
    WebElement lastNameFieldI;
    @FindBy(id = "register-email")
    WebElement emailFieldI;
    @FindBy(id = "register-password")
    WebElement passwordFieldI;
    @FindBy(id = "register-confirmPassword")
    WebElement confirmPasswordFieldI;
    @FindBy(id = "register-submit")
    WebElement createAccountButtonId;


    public LearningMaterialsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLoginScreenIsDisplayed() {
        loginScreenXpath.isDisplayed();
    }

    public void enterEmail(String email) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(emailFieldId));
        emailFieldId.clear();
        emailFieldId.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordFieldId.clear();
        passwordFieldId.sendKeys(password);
    }

    public void clickOnLoginButton() {
        loginButtonId.click();
    }

    public void clickOnSignupButton() {
        signupButtonId.click();
    }

    public void clickOnLogoutButton() {
        logoutButtonId.click();
    }

    public void verifyLogoutButtonIsDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(logoutButtonId));
        logoutButtonId.isDisplayed();
    }

    public void enterFirstName(String firstName){
        firstNameFieldId.clear();
        firstNameFieldId.sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        lastNameFieldI.clear();
        lastNameFieldI.sendKeys(lastName);
    }

    public void enterRegistrationEmail(String email) {
        emailFieldI.clear();
        emailFieldI.sendKeys(email);
    }
    public void enterRegistrationPassword(String password) {
        passwordFieldI.clear();
        passwordFieldI.sendKeys(password);
    }
    public void enterConfirmPassword(String confirmPassword) {
        confirmPasswordFieldI.clear();
        confirmPasswordFieldI.sendKeys(confirmPassword);
    }
    public void clickOnCreateAccountButton() {
        createAccountButtonId.click();
    }

    public void verifyCreateAccountButtonIsDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(createAccountButtonId));
        createAccountButtonId.isDisplayed();
    }

}
