package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginSteps {

    WebDriver driver = hooks.Hooks.getDriver();

    @Given("estoy en la página de inicio de sesión")
    public void irALaPaginaDeInicio() {
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }

    @When("ingreso el nombre de usuario {string} y la contraseña {string}")
    public void ingresoUserPass(String usuario, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys(usuario);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @And("hago clic en el botón de inicio de sesión")
    public void clicEnIniciarSesion() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit"))).click();
    }

    @Then("debería ver el mensaje de exito {string}")
    public void validarInicioDeSesion(String mensaje) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        var textoExito = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("post-title"))).getText();

        Assertions.assertEquals(mensaje, textoExito);
    }

    @Then("debería ver el mensaje de error {string}")
    public void validarMensajeError(String mensaje) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        var textoError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error"))).getText();

        Assertions.assertEquals(mensaje, textoError);
    }
}
