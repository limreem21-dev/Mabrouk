
package steps;

import org.junit.Assert;

import Helper.config;
import pages.HomePage;
import pages.ProductPage;
import pages.CategoryPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ProductPage;

public class PanierStepDef {
	HomePage home;
	ProductPage produit;

	public PanierStepDef() {
	}
	
	@When("l'utilisateur choisit une couleur")
	public void choisirCouleur() {
	    produit = new ProductPage(Hooks.driver);
	    produit.choisirCouleur("Blanc");
	}
@When("l'utilisateur choisit une taille")
public void choisirTaille() {
    produit.choisirTaille("M");
}

@When("il ajoute le produit au panier")
public void ajouterProduitAuPanier() {
    produit.ajouterAuPanier1();
}

@When("l'utilisateur accède au panier")
public void ouvrirPanier() {
    produit.ouvrirPanier();
}
@Then("le produit est ajouté au panier")
public void verifierAjoutPanier() {
    Assert.assertTrue(
        produit.verifierProduitDansPanier("Col classique et coupe ample")
    );
}    
    }


