package demoblaze.pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import demoblaze.utils.BaseTest;

public class CheckoutPage extends BaseTest {

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void fillCheckoutForm(String name, String country, String city, String card, String month, String year) {
        enterText("id", "name", name);
        enterText("id", "country", country);
        enterText("id", "city", city);
        enterText("id", "card", card);
        enterText("id", "month", month);
        enterText("id", "year", year);
        clickElement("css", "button[onclick='purchaseOrder()']"); 
    }

    public void confirmPurchase() {
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2")));  
    }

    public String captureScreenshot(String screenshotName) {
    
        String screenshotPath = System.getProperty("user.dir") + "/demoblaze/build/reports/Reporte y captura/" + screenshotName + ".png";

      
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(screenshot, new File(screenshotPath));
            return screenshotPath;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
