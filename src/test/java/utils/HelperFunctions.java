package utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class HelperFunctions extends Base {

    public static void alertHandler(String message) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            String invalidLogin = alert.getText();
            Assert.assertEquals(invalidLogin, message);
            alert.accept();

        } catch (Exception e) {
            e.getMessage();
        }
    }
}
