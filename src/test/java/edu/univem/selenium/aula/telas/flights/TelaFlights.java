package edu.univem.selenium.aula.telas.flights;

import edu.univem.selenium.aula.dominio.Voo;
import edu.univem.selenium.aula.selenium.SeleniumWebDriver;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by andvicente on 05/11/16.
 */
public class TelaFlights {

    private SeleniumWebDriver selenium;
    private static final String URL = "https://www.tripadvisor.com/CheapFlightsHome";
    private final String locatorVooMaisBarato = "div.flightList > div:nth-child(1) ";

    public TelaFlights(SeleniumWebDriver selenium) {
        this.selenium = selenium;
    }

    public void abrir() {
        selenium.driver.get(URL);
        selenium.assertTitle("Cheap Flights, Airline Tickets and Airfare Search - TripAdvisor");
    }

    public void selecionarSomenteIda() {
        selenium.clickByLinkText("One-way");
    }

    public void preencherDadosBuscaVoo(String origem, String destino, String dia) throws InterruptedException {
        selenium.type("div.tabContent.oneWay.active input.query.origWithLabel",origem);
        Thread.sleep(1000);
        selenium.type("div.tabContent.oneWay.active input.query.destWithLabel",destino);
        Thread.sleep(1000);
        selenium.click("#ow_ui_picker.ui_picker");
        selenium.click("span.dsdc-month:nth-child(1)  span[data-date=\"2018-6-" + dia +"\"]");

//        selenium.uncheck("#cb_Decolar_com_br");
//        selenium.uncheck("#cb_MAxMilhas");
//        selenium.uncheck("#cb_Expedia_com_br");
        selenium.click("div.tabContent.oneWay.active button.form_submit.searchBtn.en_US.en");
    }


    public void getMenorPrecoVoo() {
        selenium.waitForElementPresent("div.flightList");
        String menorPreco = selenium.getText(locatorVooMaisBarato + "div.viewDeal span.viewDealPrice");

        System.out.println("Menor Preço: " + menorPreco);

        //selenium.takeScreenshot();
    }

    public void getInformacoesVoo() throws ParseException {

        Voo infoVoo = new Voo();

        infoVoo.setCompanhiaAereaNome(selenium.getText(locatorVooMaisBarato + "div.airlineName"));

        String[] partidaInfo = selenium.getText(locatorVooMaisBarato + "div.departureDescription.airportDescription").split("\\s+");
        Calendar horarioPartidaVoo = setHorarioVoo(partidaInfo);
        infoVoo.setPartidaAeroporto(partidaInfo[0]);
        infoVoo.setPartidaHorario(horarioPartidaVoo);

        String[] chegadaInfo = selenium.getText(locatorVooMaisBarato + "div.arrivalDescription.airportDescription").split("\\s+");;
        Calendar horarioChegadaVoo = setHorarioVoo(chegadaInfo);
        infoVoo.setChegadaAeroporto(chegadaInfo[0]);
        infoVoo.setChegadaHorario(horarioChegadaVoo);

        String duracaoVoo = selenium.getText(locatorVooMaisBarato + "div.segmentDuration");
        Duration duracaoVooCal = Duration.parse("PT"+ duracaoVoo.toUpperCase().replaceAll("\\s",""));
        infoVoo.setDuracaoVoo(duracaoVooCal);

        infoVoo.setParadas(selenium.getText(locatorVooMaisBarato + "div.segmentStops"));
        infoVoo.setValor(selenium.getText(locatorVooMaisBarato + "span.viewDealPrice"));

        System.out.println(infoVoo.toString());


    }

    public Calendar salvaDuracao(String duracaoVoo) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("HH:mm");
        Date d = df.parse(duracaoVoo);
        Calendar gc = new GregorianCalendar();
        gc.setTime(d);
        return gc;
    }

    public Calendar setHorarioVoo(String[] chegada) throws ParseException {
        String horarioChegada = chegada[1]+" "+chegada[2];
        SimpleDateFormat df = new SimpleDateFormat("hh:mm aa");
        Date d = df.parse(horarioChegada);
        Calendar gc = new GregorianCalendar();
        gc.setTime(d);
        return gc;
    }
}
