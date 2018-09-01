package edu.univem.selenium.aula.testes;

import edu.univem.selenium.aula.dominio.Moeda;
import edu.univem.selenium.aula.selenium.SeleniumTest;
import edu.univem.selenium.aula.selenium.SeleniumWebDriver;
import edu.univem.selenium.aula.telas.cambio.TelaCambioMSN;
import edu.univem.selenium.aula.telas.cambio.TelaCambioUOL;
import org.junit.Before;
import org.junit.Test;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class TesteCotacaoMSN   extends SeleniumTest {

    TelaCambioMSN telaCambio;
    SeleniumWebDriver selenium;

    @Before
    public void prepararCotacoes() {
        this.selenium = new SeleniumWebDriver(driver);
        this.telaCambio = new TelaCambioMSN(selenium);
        this.telaCambio.abrir();
    }

    @Test
    public void CotacaoMaisAltaEuroPesoDolar() throws ParseException {
        Moeda dolar = telaCambio.consultaMoeda("USD");
        Moeda euro = telaCambio.consultaMoeda("EUR");
        Moeda peso = telaCambio.consultaMoeda("ARS");

        System.out.println("USD: " + dolar.getVenda());
        System.out.println("EUR: " + euro.getVenda());
        System.out.println("ARS: " + peso.getVenda());

        assertTrue(euroCotacaoMaisAlta(peso,dolar,euro));


    }

    /**
     * Dado que a cota para viagens para o exterior é de $500. Consulte a cota
     * em R$ (reais) utilizando o "Conversor de Moedas"
     *
     * Site: Utilizar https://www.msn.com/pt-br/dinheiro/cotacao-do-dolar
     * Verificacoes:
     *      Cotacao do dolar está maior que R$ 4,00
     *      Verificar que o valor é maior que R$ 2000
     * Imprimir no Console:
     *       Cotação e valor da cota em R$
     */
    @Test
    public void testeConsultaLimiteCotaViagemExteriorEmReais() throws ParseException {
        // TODO: Implementar Caso de Teste (Limite Cota Viagem Exterior)

    }

    private boolean euroCotacaoMaisAlta(Moeda peso, Moeda dolar, Moeda euro)
            throws ParseException {

        NumberFormat nf = NumberFormat.getInstance(Locale.US);
        float vendaPeso = nf.parse(peso.getVenda()).floatValue();
        float vendaDolar = nf.parse(dolar.getVenda()).floatValue();
        float vendaEuro = nf.parse(euro.getVenda()).floatValue();

        if ((vendaEuro > vendaPeso) && (vendaEuro > vendaDolar))
            return true;
        else
            return false;
    }

}
