
package steps;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.AfterAll;

public class Hooks {

    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeAll
    public static void demarrerNavigateur() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(
            driver, Duration.ofSeconds(20)
        );
    }

    @AfterAll
    public static void fermerNavigateur() {
        if (driver != null) {
            driver.quit();
            driver = null;
            wait = null;
        }
    }
}
