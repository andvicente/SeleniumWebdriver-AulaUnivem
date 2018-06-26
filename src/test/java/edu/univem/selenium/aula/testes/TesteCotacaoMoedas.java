package edu.univem.selenium.aula.testes;

import edu.univem.selenium.aula.dominio.Moeda;
import edu.univem.selenium.aula.selenium.SeleniumTest;
import edu.univem.selenium.aula.selenium.SeleniumWebDriver;
import edu.univem.selenium.aula.telas.cambio.TelaCambioUOL;
import edu.univem.selenium.aula.telas.cambio.TelaHistoricoMoeda;
import org.junit.Before;
import org.junit.Test;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by andvicente on 05/11/16.
 */
public class TesteCotacaoMoedas  extends SeleniumTest {

    TelaCambioUOL telaCambio;
    SeleniumWebDriver selenium;

    @Before
    public void prepararCotacoes() {
        this.selenium = new SeleniumWebDriver(driver);
        this.telaCambio = new TelaCambioUOL(selenium);
        this.telaCambio.abrir();
    }

    /**
     * Compara a cotação do Dolar, Peso e Euro e verifica se o Euro é a que
     * possui a cotação mais alta.
     *
     *
     */
    @Test
    public void testeCotacaoDiariaDolarPesoEuro() throws ParseException {
        Moeda peso = telaCambio.consultarCotacaoPesoArgentino();
        Moeda dolar = telaCambio.consultarCotacaoDolarComercial();
        Moeda euro = telaCambio.consultarCotacaoEuro();
        assertTrue(euroCotacaoMaisAlta(peso, dolar, euro));
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

    /**
     * Verifica a cotação do dólar comercial (Venda) mais baixa e mais alta dos
     * últimos 50 dias
     */
    @Test
    public void testeCotacaoMaisBaixaAltaDolarUltimos50dias() {

        telaCambio.consultarCotacaoDolarComercial();
        TelaHistoricoMoeda historicoMoeda = new TelaHistoricoMoeda(selenium);
        ArrayList cotacaoMaisBaixaMaisAlta = historicoMoeda
                .getCotacaoMoedaMaisBaixaMaisAlta();

        selenium.takeScreenshot();

        assertEquals("18/04/2018 3,3801", cotacaoMaisBaixaMaisAlta.get(0));
        assertEquals("07/06/2018 3,9258", cotacaoMaisBaixaMaisAlta.get(1));
        System.out.println("Cotação mais BAIXA: "
                + cotacaoMaisBaixaMaisAlta.get(0));
        System.out.println("Cotação mais ALTA:  "
                + cotacaoMaisBaixaMaisAlta.get(1));
    }

    /**
     * Dado que a cota para viagens para o exterior é de $500. Consulte a cota
     * em R$ (reais) utilizando o "Conversor de Moedas"
     * 
     * Site: Utilizar http://www.economia.com.br com a busca "Dolar to Real"
     * Verificacoes: 
     *      Cotacao do dolar está maior que R$ 3,00
     *      Verificar que o valor é maior que R$ 1600
     * Imprimir no Console:
     *       Cotação e valor da cota em R$
     */
    @Test
    public void testeConsultaLimiteCotaViagemExteriorEmReais() {
        // TODO: Implementar Caso de Teste (Limite Cota Viagem Exterior)
    }
}
