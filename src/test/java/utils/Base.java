package utils;

import org.openqa.selenium.WebDriver;
import pagesObjects.HomePage;
import pagesObjects.LearningMaterialsPage;
import utils.BrowserFactory;

public class Base {

    BrowserFactory browserFactory = new BrowserFactory();

    final WebDriver driver = browserFactory.startBrowser("chrome", "https://www.ndosiautomation.co.za/");
    HomePage homePage = new HomePage(driver);
    LearningMaterialsPage learningMaterialsPage = new LearningMaterialsPage(driver);
}
