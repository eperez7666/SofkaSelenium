package demoblaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;  // Asegúrate de que esta línea esté presente
import demoblaze.utils.BaseTest;

public class HomePage extends BaseTest {

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  
    }
    public void goToHomePage() {
        driver.get("https://www.demoblaze.com/");
    }

    public void addFirstProductToCart() {
        clickElement("css", "div.card.h-100 a");  
        clickElement("xpath", "//a[text()='Add to cart']");  
        acceptAlert();
        goToHomePage();
    }

    public void addSecondProductToCart() {
        clickElement("css", "div:nth-child(3) div:nth-child(1) a:nth-child(1) img:nth-child(1)");  
        clickElement("xpath", "//a[text()='Add to cart']");  
        acceptAlert();
        goToHomePage();
    }
}
