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

}
