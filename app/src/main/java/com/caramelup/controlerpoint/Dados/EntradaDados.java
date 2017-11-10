package com.caramelup.controlerpoint.Dados;

import java.sql.Time;
import java.util.Calendar;

/**
 * Created by fbuenod on 10/11/17.
 */

public class EntradaDados {
    private long id;
    private Calendar dataEntrada;
    private Time horaEntrada;

    public EntradaDados(long id, Calendar dataEntrada, Time horaEntrada){
        this.id = id;
        this.dataEntrada = dataEntrada;
        this.horaEntrada = horaEntrada;
    }

    public EntradaDados(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Calendar getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Calendar dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Time getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Time horaEntrada) {
        this.horaEntrada = horaEntrada;
    }
}
