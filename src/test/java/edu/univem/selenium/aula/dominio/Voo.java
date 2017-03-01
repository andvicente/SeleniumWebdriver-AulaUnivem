package edu.univem.selenium.aula.dominio;

import java.time.Duration;
import java.util.Calendar;
import java.util.Currency;

/**
 * Created by andvicente on 05/11/16.
 */
public class Voo {

    private String companhiaAereaNome;
    private String partidaAeroporto;
    private Calendar partidaHorario;
    private Duration duracaoVoo;
    private String chegadaAeroporto;
    private Calendar chegadaHorario;
    private String paradas;
    private String valor;

    public Voo() {

    }

    public String getCompanhiaAereaNome() {
        return companhiaAereaNome;
    }

    public void setCompanhiaAereaNome(String companhiaAereaNome) {
        this.companhiaAereaNome = companhiaAereaNome;
    }

    public String getPartidaAeroporto() {
        return partidaAeroporto;
    }

    public void setPartidaAeroporto(String partidaAeroporto) {
        this.partidaAeroporto = partidaAeroporto;
    }

    public Calendar getPartidaHorario() {
        return partidaHorario;
    }

    public void setPartidaHorario(Calendar partidaHorario) {
        this.partidaHorario = partidaHorario;
    }

    public String getChegadaAeroporto() {
        return chegadaAeroporto;
    }

    public void setChegadaAeroporto(String chegadaAeroporto) {
        this.chegadaAeroporto = chegadaAeroporto;
    }

    public Calendar getChegadaHorario() {
        return chegadaHorario;
    }

    public void setChegadaHorario(Calendar chegadaHorario) {
        this.chegadaHorario = chegadaHorario;
    }

    public Duration getDuracaoVoo() {
        return duracaoVoo;
    }

    public void setDuracaoVoo(Duration duracaoVoo) {
        this.duracaoVoo = duracaoVoo;
    }

    public String getParadas() {
        return paradas;
    }

    public void setParadas(String paradas) {
        this.paradas = paradas;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Voo [" +
                "companhiaAereaNome='" + companhiaAereaNome + '\'' +
                ",\n partidaAeroporto='" + partidaAeroporto + '\'' +
                ",\n partidaHorario=" + partidaHorario.get(Calendar.HOUR_OF_DAY) +":"+ partidaHorario.get(Calendar.MINUTE)+
                ",\n chegadaAeroporto='" + chegadaAeroporto + '\'' +
                ",\n chegadaHorario=" + chegadaHorario.get(Calendar.HOUR_OF_DAY) +":"+ chegadaHorario.get(Calendar.MINUTE)+
                ",\n duracaoVoo=" + duracaoVoo.toHours()%24 + "h "+ duracaoVoo.toMinutes()%60 + "m" +
                ",\n paradas=" + paradas +
                ",\n valor=" + valor +
                ']';
    }
}
