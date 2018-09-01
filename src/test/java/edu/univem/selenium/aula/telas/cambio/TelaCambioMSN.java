package edu.univem.selenium.aula.telas.cambio;

import edu.univem.selenium.aula.dominio.Moeda;
import edu.univem.selenium.aula.selenium.SeleniumWebDriver;

import java.text.NumberFormat;
import java.text.ParseException;

public class TelaCambioMSN {

    private SeleniumWebDriver selenium;
    private static final String URL = "https://www.msn.com/pt-br/dinheiro/cotacao-do-dolar";

    public TelaCambioMSN(SeleniumWebDriver selenium) {
        this.selenium = selenium;
    }

    public void abrir() {
        selenium.driver.get(URL);
        selenium.assertTitle("Conversor de Moedas - Dólar, Euro, Peso - MSN Dinheiro");
    }

    public Moeda consultaMoeda(String moedaSimbolo){
        selenium.clickByLinkText(moedaSimbolo);
        Moeda moeda = new Moeda();
        moeda.setVenda(selenium.getValue("#totxtbx"));
        return moeda;
    }

    public boolean cotaExteriorDolar(double dolares) throws ParseException {
        selenium.type("#frmtxtbx","500");
        String cota = selenium.getValue("#totxtbx");

        String cotaSemPonto = cota.replace(".","");
        String cotaSemVirgula = cotaSemPonto.replace(",",".");
        if (dolares <= Double.parseDouble(cotaSemVirgula))
            return true;
        else
            return false;
    }
}
