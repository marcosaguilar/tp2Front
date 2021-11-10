package com.example.appandroid.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Agenda {
    @SerializedName("horaInicioCadena")
    @Expose
    private String horaInicio;
    @SerializedName("horaFinCadena")
    @Expose
    private String horaFin;

    public Agenda() {
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "horaInicio=" + horaInicio +
                ", horaFin='" + horaFin + '\'' +
                '}';
    }
}
