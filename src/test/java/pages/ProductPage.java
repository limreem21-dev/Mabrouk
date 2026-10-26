

package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Helper.config;

public class ProductPage {

	
	private WebDriver driver;
	private WebDriverWait wait;

	public ProductPage(WebDriver driver) {
	    this.driver = driver;
	    this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    PageFactory.initElements(driver, this);
	}
   
    public void choisirCouleur(String couleur) {

        By couleurXPath = By.xpath(
            "/html/body/div[5]/div[3]/div[2]/div/main/div[1]/div[1]/div[3]/div[2]/div/div[2]/div/form/div/div[1]/div[2]/div[3]/span[2]"
        );

        WebElement element = wait.until(
            ExpectedConditions.elementToBeClickable(couleurXPath)
        );

        element.click();

        System.out.println("Couleur sélectionnée.");
    }

public void choisirTaille(String string) {

    By tailleXPath = By.xpath(
        "/html/body/div[5]/div[3]/div[2]/div/main/div[1]/div[1]/div[3]/div[2]/div/div[2]/div/form/div/div[1]/div[3]/span/ul/li[2]/div"
    );

    WebElement taille = wait.until(
        ExpectedConditions.elementToBeClickable(tailleXPath)
    );

    ((JavascriptExecutor) driver).executeScript(
        "arguments[0].scrollIntoView({block:'center'});",
        taille
    );

    wait.until(
        ExpectedConditions.elementToBeClickable(tailleXPath)
    ).click();

    System.out.println("Taille sélectionnée.");
}


public void ajouterAuPanier1() {

    By boutonAjouter = By.xpath(
        "/html/body/div[5]/div[3]/div[2]/div/main/div[1]/div[1]/div[3]/div[2]/div/div[2]/div/form/div/div[4]/div[2]/a"
    );

    WebElement bouton = wait.until(
        ExpectedConditions.elementToBeClickable(boutonAjouter)
    );

    bouton.click();

    System.out.println("Clic sur Ajouter au panier effectué.");
}

public void verifierAjoutPanier1() {

    WebDriverWait wait = new WebDriverWait(
        config.driver, Duration.ofSeconds(15)
    );

    By boutonViewCart = By.xpath("/html/body/div[5]/div[3]/div[2]/div/main/div[1]/div[1]/div[3]/div[2]/div/div[2]/div/form/div/div[4]/div[2]/a[2]");

    wait.until(
        ExpectedConditions.visibilityOfElementLocated(boutonViewCart)
    );

    System.out.println("Le bouton View cart / Voir le panier est affiché.");
}


public void ouvrirPanier() {

    WebDriverWait wait = new WebDriverWait(
        driver, Duration.ofSeconds(15)
    );

    By boutonVoirPanier = By.xpath(
        "/html/body/div[5]/div[3]/div[2]/div/main/div[1]/div[1]/div[3]/div[2]/div/div[2]/div/form/div/div[4]/div[2]/a[2]"
    );

    WebElement bouton = wait.until(
        ExpectedConditions.elementToBeClickable(boutonVoirPanier)
    );

    bouton.click();

    System.out.println("Accès au panier effectué.");
}

public boolean verifierProduitDansPanier(String nomProduit) {
    WebDriverWait wait = new WebDriverWait(
        driver, Duration.ofSeconds(15)
    );

    By produitPanier = By.xpath(
        "/html/body/div[5]/div[3]/div[2]/div/main//a[contains(.,'COL CLASSIQUE ET COUPE AMPLE')]"
    );

    return wait.until(
        ExpectedConditions.visibilityOfElementLocated(produitPanier)
    ).isDisplayed();
}
}