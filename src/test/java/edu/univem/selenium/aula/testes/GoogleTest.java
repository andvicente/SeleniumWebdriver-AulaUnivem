package edu.univem.selenium.aula.testes;

import edu.univem.selenium.aula.selenium.SeleniumTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by andvicente on 06/03/17.
 */
public class GoogleTest extends SeleniumTest{

    @Test
    public void testGoogleSearch(){
        driver.get("https://google.com.br");

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("André Abe Vicente");

        searchBox.sendKeys(Keys.RETURN);

        driver.findElement(By.id("resultStats"));

        WebElement resultadoGoogle = driver.findElement(By
                .cssSelector("#rso > div:nth-child(1) h3 > a"));
        resultadoGoogle.click();

        assertEquals("André Abe Vicente - Software Quality Specialist - PagSeguro UOL | LinkedIn", driver.getTitle());

        driver.navigate().back();

    }



}