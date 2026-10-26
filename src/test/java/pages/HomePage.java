
package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Helper.config;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(config.driver, this);
    }

    public static void accederAccueil() {
        config.driver.get("https://mabrouk.tn/");
        config.attente(6);
    }



public void cliquerMenuFemme() {

    WebDriverWait wait = new WebDriverWait(
        config.driver, Duration.ofSeconds(15)
    );

    WebElement femme = wait.until(
        ExpectedConditions.elementToBeClickable(
            By.xpath("/html/body/div[5]/header/div/div/div[2]/nav/div/div[2]/div[1]/ul/li")
        )
    );

    new Actions(config.driver)
        .moveToElement(femme)
        .pause(Duration.ofSeconds(3))
        .perform();

    System.out.println("Survol du menu Femme effectué.");
}


    // Cliquer sur le sous-menu Chemises & Blouses


public void cliquerSousMenuChemises() {
    WebDriverWait wait = new WebDriverWait(config.driver, Duration.ofSeconds(15));

    WebElement sousMenu = wait.until(ExpectedConditions.elementToBeClickable(
        By.xpath("/html/body/div[5]/header/div/div/div[2]/nav/div/div[2]/div[1]/ul/li[2]/div/ul/li[2]/a/span")
    ));

    sousMenu.click();

    wait.until(ExpectedConditions.urlContains(
        "/categorie-produit/vetements-femmes/chemises-blouses/"
    ));

    System.out.println("Clic sur Chemises & Blouses effectué.");
}

public static void verifierPageChemises() {

    WebDriverWait wait = new WebDriverWait(
        config.driver, Duration.ofSeconds(20)
    );

    wait.until(ExpectedConditions.urlContains(
        "/categorie-produit/vetements-femmes/chemises-blouses/"
    ));

    System.out.println("Page Chemises & Blouses affichée.");
}
public void fermerPopupRoue() {

	WebDriverWait wait = new WebDriverWait(
		    config.driver, Duration.ofSeconds(1)
		
    );

    String[] xpaths = {
        "\"/html/body/div[15]/div/div[2]/div/div/div/div/div/button\""
    };

    for (String xpath : xpaths) {
        try {
            WebElement bouton = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath(xpath))
            );

            bouton.click();
            System.out.println("Pop-up fermée.");
            return;

        } catch (Exception e) {
        }
    }

    System.out.println("Aucun bouton de fermeture trouvé.");
}

}