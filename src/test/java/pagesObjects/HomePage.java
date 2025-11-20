package pagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
        headingHomePageXpath.isDisplayed();
    }

    public void clickOnLearningMaterialsTab() {
        learningMaterialsId.click();
    }
}
