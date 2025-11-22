package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {

     static WebDriver driver;

    public static WebDriver startBrowser(String browserChoice, String url) {

        switch (browserChoice.toLowerCase()) {
            case "chrome":
                // Initialize ChromeDriver with options
                 ChromeOptions chromeOptions = new ChromeOptions();
                 chromeOptions.addArguments("--incognito");
                 driver = new ChromeDriver(chromeOptions);
                break;
            case "internetexplore":
                 driver = new InternetExplorerDriver();
                break;
            case "firefox":
                 driver = new FirefoxDriver();
                break;
            case "safari":
                 driver = new SafariDriver();
                break;
            default:
                 driver = new EdgeDriver();
                break;
        }

        driver.manage().window().maximize();
        driver.get(url);

        return driver;
    }
}
