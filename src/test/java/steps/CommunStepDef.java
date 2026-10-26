
package steps;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Helper.config;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class CommunStepDef {

    @Before
    public void demarrerNavigateur() {

        if (config.driver == null) {
            config.driver = new org.openqa.selenium.chrome.ChromeDriver();
            config.driver.manage().window().maximize();
        }
    }


@After
public void tearDown(Scenario sc) {

    if (sc.isFailed() && config.driver != null) {
        try {
            if (config.driver.getWindowHandles().size() > 0) {

                File screenshotSource =
                    ((TakesScreenshot) config.driver)
                    .getScreenshotAs(OutputType.FILE);

                String nomFichier = sc.getName()
                    .replaceAll("[\\\\/:*?\"<>|]", "_");

                File destination = new File(
                    "C:\\Users\\limre\\eclipse-workspace\\Mabrouk\\"
                    + nomFichier + ".png"
                );

                FileUtils.copyFile(screenshotSource, destination);
                System.out.println("Capture enregistrée : " + destination);
            }
        } catch (Exception e) {
            System.out.println("Capture impossible : " + e.getMessage());
        }
    }
}
}