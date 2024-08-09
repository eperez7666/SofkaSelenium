package demoblaze.pages;

import java.time.Duration;  

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import demoblaze.utils.BaseTest;

public class CartPage extends BaseTest {

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  
    }

    public void goToCart() {
        driver.get("https://www.demoblaze.com/cart.html");  
        clickElement("css", ".btn.btn-success");
    }
}
