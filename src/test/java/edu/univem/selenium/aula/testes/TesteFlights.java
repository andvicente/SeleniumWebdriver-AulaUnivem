package edu.univem.selenium.aula.testes;

import edu.univem.selenium.aula.selenium.SeleniumTest;
import edu.univem.selenium.aula.selenium.SeleniumWebDriver;
import edu.univem.selenium.aula.telas.flights.TelaFlights;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;

/**
 * Created by andvicente on 05/11/16.
 */
public class TesteFlights  extends SeleniumTest{

    TelaFlights telaFlights;
    SeleniumWebDriver selenium;

    @Before
    public void prepararBuscaVoos() {
        this.selenium = new SeleniumWebDriver(driver);
        this.telaFlights = new TelaFlights(selenium);
        this.telaFlights.abrir();
    }

    @Test
    public void buscaVooMaisBaratoSpParaCvel() throws ParseException {
        String saoPauloTodosAeroportos = "Sao Paulo, Brazil - All Airports (SAO)";
        String cascavel = "Cascavel, Brazil - Cascavel Mncpl (CAC)";

        telaFlights.selecionarSomenteIda();
        telaFlights.preencherDadosBuscaVoo(saoPauloTodosAeroportos,cascavel,"23");
        telaFlights.getMenorPrecoVoo();
        telaFlights.getInformacoesVoo();

    }

    /**
     * Vôo mais barato que não tenha parada "NON-STOP"
     */
    @Test
    public void buscaVooMaisBaratoSemParada(){

    }

    /**
     * Busca diferença de PREÇO e TEMPO
     * Entre Voo mais Barato sem parada e com uma parada
     */
    @Test
    public void buscaDiferencaVooMaisBaratoSemParadaeComUmaParada(){

    }

}
