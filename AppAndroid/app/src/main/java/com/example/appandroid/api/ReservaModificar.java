package com.example.appandroid.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ReservaModificar {
    @SerializedName("idReserva")
    @Expose
    private Integer idReserva;

    @SerializedName("observacion")
    @Expose
    private String observacion;

    @SerializedName("flagAsistio")
    @Expose
    private String flagAsistio;



    public ReservaModificar() {
    }


    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getFlagAsistio() {
        return flagAsistio;
    }

    public void setFlagAsistio(String flagAsistio) {
        this.flagAsistio = flagAsistio;
    }

    @Override
    public String toString() {
        return "Reserva{" +

                '}';
    }
}
