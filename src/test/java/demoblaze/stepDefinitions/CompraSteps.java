package demoblaze.stepDefinitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import demoblaze.pages.CartPage;
import demoblaze.pages.CheckoutPage;
import demoblaze.pages.HomePage;
import demoblaze.utils.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CompraSteps extends BaseTest {

    private HomePage homePage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private ExtentReports extent;
    private ExtentTest test;

    @Given("El usuario esta en la pagina principal de Demoblaze")
    public void el_usuario_esta_en_la_pagina_principal_de_demoblaze() {
        String reportPath = System.getProperty("user.dir") + "/build/reports/Reporte y captura/ExtentReport.html";
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
        
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        
        test = extent.createTest("Prueba de flujo de compra en Demoblaze");

        try {
            setup();  
            homePage = new HomePage(driver);
            homePage.goToHomePage();
            test.log(Status.PASS, "El usuario navega a la página principal de Demoblaze");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error al navegar a la página principal: " + e.getMessage());
        }
    }

    @When("Agrega dos productos al carrito")
    public void agrega_dos_productos_al_carrito() {
        try {
            homePage.addFirstProductToCart();
            test.log(Status.PASS, "El primer producto fue agregado al carrito");

            homePage.addSecondProductToCart();
            test.log(Status.PASS, "El segundo producto fue agregado al carrito");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error al agregar productos al carrito: " + e.getMessage());
            test.addScreenCaptureFromPath(captureScreenshot("Error_Agregando_Productos"));
        }
    }

    @When("Visualiza el carrito")
    public void visualiza_el_carrito() {
        try {
            cartPage = new CartPage(driver);
            cartPage.goToCart();
            test.log(Status.PASS, "El usuario visualiza el carrito de compras");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error al visualizar el carrito: " + e.getMessage());
            test.addScreenCaptureFromPath(captureScreenshot("Error_Visualizando_Carrito"));
        }
    }

    @When("Completa el formulario de compra")
    public void completa_el_formulario_de_compra() {
        try {
            checkoutPage = new CheckoutPage(driver);
            checkoutPage.fillCheckoutForm("Nombre", "Pais", "Ciudad", "Tarjeta", "Mes", "Año");
            test.log(Status.PASS, "El usuario completa el formulario de compra");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error al completar el formulario de compra: " + e.getMessage());
            test.addScreenCaptureFromPath(captureScreenshot("Error_Completando_Formulario"));
        }
    }

    @Then("Finaliza la compra exitosamente")
    public void finaliza_la_compra_exitosamente() {
        try {
            checkoutPage.confirmPurchase();
            test.log(Status.PASS, "Compra finalizada exitosamente");

            String screenshotPath = captureScreenshot("Compra_Exitosa");
            test.addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            test.log(Status.FAIL, "Error al finalizar la compra: " + e.getMessage());
            test.addScreenCaptureFromPath(captureScreenshot("Error_Finalizando_Compra"));
        } finally {
            // Escribe y cierra el informe de ExtentReports
            extent.flush();
            
            // Cierra el navegador y finaliza la sesión de WebDriver
            tearDown();
        }
    }
}
