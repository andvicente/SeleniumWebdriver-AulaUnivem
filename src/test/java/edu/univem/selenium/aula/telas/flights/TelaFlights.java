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
    private final String locatorVooMaisBarato = "div.entry.show:nth-of-type(1) ";

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

    public void preencherDadosBuscaVoo(String origem, String destino, String dia) {
        //selenium.type("#ow_1_airportFrom",origem);
        selenium.type("#ow_1_airportTo",destino);
        //selenium.type("#date_picker_in_1","11/22/2016");
        selenium.click("#date_picker_in_1");
        selenium.click("div.month:nth-of-type(3) .day_"+ dia);

        selenium.uncheck("#cb_Decolar_com_br");
        selenium.uncheck("#cb_MAxMilhas");
        selenium.uncheck("#cb_Expedia_com_br");

        selenium.click("#CHECK_FARES_BUTTON");
    }

    public void getMenorPrecoVoo() {
        selenium.waitForVisible("div.flightList");
        String menorPreco = selenium.getText(locatorVooMaisBarato + "span.price");

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
        infoVoo.setValor(selenium.getText(locatorVooMaisBarato + "span.price"));

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
