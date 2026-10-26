
package steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class MenuStepDef {

    private final String URL_ACCUEIL = "https://mabrouk.tn/";

    @Given("l'utilisateur accède à la page d'accueil")
    public void accederPageAccueil() {
        Hooks.driver.get("https://mabrouk.tn/");
    }
    @When("il survole le menu {string}")
    public void survolerMenu(String menu) {

        By menuFemme = By.xpath(
            "//a[contains(normalize-space(.),'Femme')]"
        );

        WebElement femme = Hooks.wait.until(
            ExpectedConditions.visibilityOfElementLocated(menuFemme)
        );

        new Actions(Hooks.driver).moveToElement(femme).perform();

        System.out.println("Survol du menu Femme effectué.");
    }
    @When("il clique sur le sous-menu {string}")
    public void cliquerSousMenu(String sousMenuTexte) {

        By sousMenu = By.xpath(
            "//a[contains(.,'Chemises') and contains(.,'Blouses')]"
        );

        WebElement element = Hooks.wait.until(
            ExpectedConditions.elementToBeClickable(sousMenu)
        );

        element.click();
    }

    @Then("la page {string} doit s'afficher")
    public void verifierPage(String nomPage) {
        Assert.assertTrue(
            "La catégorie n'est pas affichée.",
            Hooks.driver.getCurrentUrl().contains("chemises-blouses")
        );
    }
}
