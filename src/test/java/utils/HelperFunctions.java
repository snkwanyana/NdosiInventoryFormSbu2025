package utils;

import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class HelperFunctions {

    static WebDriver driver = BrowserFactory.driver;
    public static void alertHandler(String message) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            String invalidLogin = alert.getText();
            Assert.assertEquals(invalidLogin, message);
            alert.accept();

        } catch (Exception e) {
            throw new RuntimeException("Alert not found");
        }
    }

    public static String email = Faker.instance().internet().emailAddress();
}
