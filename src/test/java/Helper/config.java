

package Helper;

import java.time.Duration;
import org.openqa.selenium.WebDriver;

import steps.Hooks;

public class config {

    public static WebDriver driver;

    public static void ouvrirNavigateur() {
        driver = Hooks.driver;

        driver.manage().window().maximize();
        driver.get("https://mabrouk.tn/");
    }

    public static void attente(int s) {
        driver.manage().timeouts()
              .implicitlyWait(Duration.ofSeconds(s));
    }
}
