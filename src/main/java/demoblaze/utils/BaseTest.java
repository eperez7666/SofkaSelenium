package demoblaze.utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;

    // Configura el path del driver del navegador
    private final String chromeDriverPath = "C:/WebDriver/chromedriver.exe";
    private final String firefoxDriverPath = "C:/WebDriver/geckodriver.exe";
    private final String edgeDriverPath = "C:/WebDriver/msedgedriver.exe";

    public void setup() {
        String browserType = "CHROME"; // Cambia a "FIREFOX" o "EDGE" según sea necesario

        switch (browserType.toUpperCase()) {
            case "CHROME":
                System.setProperty("webdriver.chrome.driver", chromeDriverPath);
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(chromeOptions);
                break;
            case "FIREFOX":
                System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case "EDGE":
                System.setProperty("webdriver.edge.driver", edgeDriverPath);
                EdgeOptions edgeOptions = new EdgeOptions();
                driver = new EdgeDriver(edgeOptions);
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser type!");
        }

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected void clickElement(String locatorType, String locatorValue) {
        WebElement element = findElementWithTimeout(locatorType, locatorValue);
        element.click();
    }

    protected WebElement findElementWithTimeout(String locatorType, String locatorValue) {
        WebElement element = null;
        switch (locatorType.toLowerCase()) {
            case "id":
                element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
                break;
            case "name":
                element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorValue)));
                break;
            case "xpath":
                element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
                break;
            case "css":
                element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locatorValue)));
                break;
            default:
                throw new IllegalArgumentException("Locator type not supported: " + locatorType);
        }
        return element;
    }

    protected void enterText(String locatorType, String locatorValue, String text) {
        WebElement element = findElementWithTimeout(locatorType, locatorValue);
        element.clear();
        element.sendKeys(text);
    }

    protected void acceptAlert() {
        wait.until(ExpectedConditions.alertIsPresent()).accept();
    }

    // Método para capturar la pantalla y guardar en el directorio especificado
    public String captureScreenshot(String screenshotName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "/build/reports/Reporte y captura/" + screenshotName + ".png";
        try {
            FileHandler.copy(source, new File(destination));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }
}
