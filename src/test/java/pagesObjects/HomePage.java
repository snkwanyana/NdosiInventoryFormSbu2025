package pagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    WebDriver driver;

    @FindBy(id = "nav-btn-overview")
    WebElement homeTabId;
    @FindBy(xpath = "//h2[contains(text(),'Learn Automation the Right Way')]")
    WebElement headingHomePageXpath;

    @FindBy(id = "nav-btn-practice")
    WebElement learningMaterialsId;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnHomeTab() {
        homeTabId.click();
    }

    public void verifyHomePageHeading() {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(headingHomePageXpath));
        headingHomePageXpath.isDisplayed();
    }

    public void clickOnLearningMaterialsTab() {
        learningMaterialsId.click();
    }
}
