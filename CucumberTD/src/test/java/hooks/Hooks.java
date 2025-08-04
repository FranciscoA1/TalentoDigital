package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {

    public static ChromeDriver driver;

    @Before
    public void beforeScenario() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("Navegador abierto");
    }

    @After
    public void afterScenario() {
        driver.quit();
        System.out.println("Navegador cerrado");
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
