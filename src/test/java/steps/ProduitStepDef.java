
package steps;

import steps.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProduitStepDef {

    private final String URL_CATEGORIE =
        "https://mabrouk.tn/categorie-produit/vetements-femmes/chemises-blouses/";

    private final String URL_PRODUIT =
        "chemise-a-col-classique-et-coupe-ample";

    @Given("l'utilisateur est sur la page {string}")
    public void utilisateurSurPage(String page) {

        if (!Hooks.driver.getCurrentUrl().contains("chemises-blouses")) {
            Hooks.driver.get(URL_CATEGORIE);
        }

        Hooks.wait.until(
            ExpectedConditions.urlContains("chemises-blouses")
        );

        System.out.println("Page Chemises & Blouses affichée.");
    }

    @When("l'utilisateur clique sur le produit {string}")
    public void cliquerSurProduit(String nomProduit) {

        if (Hooks.driver.getCurrentUrl().contains(URL_PRODUIT)) {
            return;
        }


By produitLocator = By.xpath(
    "//a[contains(translate(normalize-space(.)," +
    "'abcdefghijklmnopqrstuvwxyzàâçéèêëîïôùûüÿ'," +
    "'ABCDEFGHIJKLMNOPQRSTUVWXYZÀÂÇÉÈÊËÎÏÔÙÛÜŸ')," +
    "'COL CLASSIQUE ET COUPE AMPLE')]"
);

WebElement produit = Hooks.wait.until(
    ExpectedConditions.elementToBeClickable(produitLocator)
);

((JavascriptExecutor) Hooks.driver).executeScript(
    "arguments[0].scrollIntoView({block:'center'});", produit
);

((JavascriptExecutor) Hooks.driver).executeScript(
    "arguments[0].click();", produit
);

Hooks.wait.until(
    ExpectedConditions.urlContains(
        "chemise-a-col-classique-et-coupe-ample"
    )
);
    }
    @Then("la page du produit est affichée")
    public void verifierPageProduit() {

        WebElement titre = Hooks.wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h1[@itemprop='name']")
            )
        );

        Assert.assertTrue(
            "Le nom du produit n'est pas affiché.",
            titre.getText().toUpperCase()
                .contains("COL CLASSIQUE ET COUPE AMPLE")
        );

        System.out.println("Fiche produit vérifiée.");
    }
}
