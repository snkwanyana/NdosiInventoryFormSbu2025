package pagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public LearningMaterialsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLoginScreenIsDisplayed() {
        loginScreenXpath.isDisplayed();
    }

    public void enterEmail(String email) {
        emailFieldId.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordFieldId.sendKeys(password);
    }

    public void clickOnLoginButton() {
        loginButtonId.click();
    }

    public void clickOnSignupButton() {
        signupButtonId.click();
    }

}
