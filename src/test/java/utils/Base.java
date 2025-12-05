package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pagesObjects.HomePage;
import pagesObjects.LearningMaterialsPage;
import pagesObjects.WebAutomationAdvancePage;

public class Base {

    protected WebDriver driver;
    protected HomePage homePage;
    protected LearningMaterialsPage learningMaterialsPage;
    protected WebAutomationAdvancePage webAutomationAdvancePage;
    @BeforeClass
    public void cleanUp() {
        BrowserFactory browserFactory = new BrowserFactory();
        driver = browserFactory.startBrowser("chrome", "https://www.ndosiautomation.co.za/");
        homePage = PageFactory.initElements(driver, HomePage.class);
        learningMaterialsPage = PageFactory.initElements(driver, LearningMaterialsPage.class);
        webAutomationAdvancePage = PageFactory.initElements(driver, WebAutomationAdvancePage.class);

    }

    @AfterClass
    public void tearDown() {
        // Close the browser after all tests in this class
        if (driver != null) {
            driver.quit();
        }
    }
}

