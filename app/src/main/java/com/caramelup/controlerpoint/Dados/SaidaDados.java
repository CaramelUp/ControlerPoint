package com.caramelup.controlerpoint.Dados;

import java.sql.Time;
import java.util.Calendar;

/**
 * Created by fbuenod on 10/11/17.
 */

public class SaidaDados {
    private long id;
    private Calendar dataSaida;
    private Time horaSaida;

    public SaidaDados(long id, Calendar dataSaida, Time horaSaida){
        this.id = id;
        this.dataSaida = dataSaida;
        this.horaSaida = horaSaida;
    }

    public SaidaDados(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Calendar getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Calendar dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Time getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(Time horaSaida) {
        this.horaSaida = horaSaida;
    }
}
