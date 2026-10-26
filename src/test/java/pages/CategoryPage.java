
package pages;

import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Helper.config;

public class CategoryPage {

    public CategoryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void accederCategorie() {

        config.driver.get(
            "https://mabrouk.tn/categorie-produit/vetements-femmes/chemises-blouses/"
        );

        config.attente(5);
    }

public void cliquerProduit(String nomProduit) {
    WebDriverWait wait = new WebDriverWait(
        config.driver, Duration.ofSeconds(15)
    );

    By produit = By.xpath(
        "/html/body/div[5]/div[3]/div[4]/main/div/div[4]/div/ul/li[2]/div/div[2]/div[5]/div[1]/h6/a"
    );

    wait.until(ExpectedConditions.visibilityOfElementLocated(produit));

    WebElement element = wait.until(
        ExpectedConditions.presenceOfElementLocated(produit)
    );

    ((JavascriptExecutor) config.driver).executeScript(
        "arguments[0].scrollIntoView({block:'center'});", element
    );

    element = wait.until(
        ExpectedConditions.presenceOfElementLocated(produit)
    );

    ((JavascriptExecutor) config.driver).executeScript(
        "arguments[0].click();",
        config.driver.findElement(produit)
    );

    System.out.println("Produit sélectionné : " + nomProduit);
}
}