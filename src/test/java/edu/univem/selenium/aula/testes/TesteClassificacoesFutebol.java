package edu.univem.selenium.aula.testes;

import edu.univem.selenium.aula.selenium.SeleniumTest;
import edu.univem.selenium.aula.selenium.SeleniumWebDriver;
import edu.univem.selenium.aula.telas.cambio.TelaCambioUOL;
import edu.univem.selenium.aula.telas.futebol.TelaUEFA;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by andvicente on 06/11/16.
 */
public class TesteClassificacoesFutebol extends SeleniumTest {
    private SeleniumWebDriver selenium;
    private TelaUEFA telaClassificacao;
    //"tbody.zona-1"
    //"tbody.zona-3 tr:nth-of-type(1) th[col=nome-comum]"

    @Before
    public void prepararCotacoes() {
        this.selenium = new SeleniumWebDriver(driver);
        this.telaClassificacao = new TelaUEFA(selenium);
        this.telaClassificacao.abrir();
    }

    /**
     * http://esporte.uol.com.br/futebol/campeonatos/brasileirao/jogos/
     */
    @Test
    public void verificarCorinthiansEstaClassificadoLibertadores(){

    }

    @Test
    public void verificarTimesZonaRebaixamentoComPontuacao(){

    }

    /**
     * https://esporte.uol.com.br/futebol/campeonatos/liga-dos-campeoes/jogos/#fase-de-grupos
     * section:nth-child (Grupo)
     * td:nth-child(1) (1o ou 2o do Grupo)
     * th:nth-child(2) (Nome do Time)
     *
     * Grupo A - Manchester United
     * section.fase.classificacao.fase-de-grupos > section:nth-child(3) > div > table > tbody.zona-1 > tr:nth-child(1) > th:nth-child(2)
     *
     * */
    @Test
    public void verificarTimesClassificadosOitavasUEFAChampions(){
        telaClassificacao.classificadosUEFA();

    }

    /**
     * https://esporte.uol.com.br/futebol/campeonatos/liga-dos-campeoes/jogos/#fase-de-grupos
     */
    @Test
    public void verificarBarcelonaMelhorRealMadridUEFAChampions(){

    }

}
