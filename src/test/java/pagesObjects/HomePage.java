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

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

}
