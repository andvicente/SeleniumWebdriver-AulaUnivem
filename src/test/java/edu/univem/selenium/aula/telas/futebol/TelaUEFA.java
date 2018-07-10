package edu.univem.selenium.aula.telas.futebol;

import edu.univem.selenium.aula.selenium.SeleniumWebDriver;

public class TelaUEFA {

    private SeleniumWebDriver selenium;
    private static final String URL = "https://esporte.uol.com.br/futebol/campeonatos/liga-dos-campeoes/jogos/#fase-de-grupos";

    public TelaUEFA(SeleniumWebDriver selenium) {
        this.selenium = selenium;
    }

    public void abrir() {
        selenium.driver.get(URL);
        selenium.assertTitle("Liga dos Campeões da UEFA 2018: Tabela de classificação, resultados e jogos - UOL Esporte");
    }

    public void classificadosUEFA(){
        String classificado1 = selenium.getText("section.fase.classificacao.fase-de-grupos > section:nth-child(3) > div > table > tbody.zona-1 > tr:nth-child(1) > th:nth-child(2)");
        String classificado2 = selenium.getText("section.fase.classificacao.fase-de-grupos > section:nth-child(3) > div > table > tbody.zona-1 > tr:nth-child(2) > th:nth-child(2)");

        System.out.println(classificado1);
        System.out.println(classificado2);

    }
}
