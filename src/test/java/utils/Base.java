package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import pagesObjects.HomePage;
import pagesObjects.LearningMaterialsPage;
import utils.BrowserFactory;

public class Base {

    static BrowserFactory browserFactory = new BrowserFactory();

    public static final WebDriver driver = browserFactory.startBrowser("chrome", "https://www.ndosiautomation.co.za/");
    public HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    public LearningMaterialsPage learningMaterialsPage = PageFactory.initElements(driver, LearningMaterialsPage.class);


    @AfterClass
    public static void tearDown() {
        // Close the browser after all tests in this class
        if (driver != null) {
            driver.quit();
        }
    }
}

