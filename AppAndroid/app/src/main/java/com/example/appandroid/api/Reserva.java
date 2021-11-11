package com.example.appandroid.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Reserva {
    @SerializedName("idReserva")
    @Expose
    private Integer idReserva;

    @SerializedName("fechaCadena")
    @Expose
    private String fechaCadena;

    @SerializedName("horaInicioCadena")
    @Expose
    private String horaInicioCadena;

    @SerializedName("horaFinCadena")
    @Expose
    private String horaFinCadena;

    @SerializedName("idEmpleado")
    @Expose
    private Persona idEmpleado;

    @SerializedName("idCliente")
    @Expose
    private Persona idCliente;

    @SerializedName("flagAsistio")
    @Expose
    private String flagAsistio;

    @SerializedName("observacion")
    @Expose
    private String observacion;

    @SerializedName("flagEstado")
    @Expose
    private String flagEstado;




    public Reserva() {
    }


    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public String getFechaCadena() {
        return fechaCadena;
    }

    public void setFechaCadena(String fechaCadena) {
        this.fechaCadena = fechaCadena;
    }

    public String getHoraInicioCadena() {
        return horaInicioCadena;
    }

    public void setHoraInicioCadena(String horaInicioCadena) {
        this.horaInicioCadena = horaInicioCadena;
    }

    public String getHoraFinCadena() {
        return horaFinCadena;
    }

    public void setHoraFinCadena(String horaFinCadena) {
        this.horaFinCadena = horaFinCadena;
    }

    public Persona getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Persona idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Persona getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Persona idCliente) {
        this.idCliente = idCliente;
    }

    public String getFlagAsistio() {
        return flagAsistio;
    }

    public void setFlagAsistio(String flagAsistio) {
        this.flagAsistio = flagAsistio;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getFlagEstado() {
        return flagEstado;
    }

    public void setFlagEstado(String flagEstado) {
        this.flagEstado = flagEstado;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "fechaCadena=" + fechaCadena +
                ", horaInicioCadena='" + horaInicioCadena + '\'' +
                ", horaFinCadena='" + horaFinCadena + '\'' +
                ", idEmpleado='" + idEmpleado + '\'' +
                ", idCliente='" + idCliente + '\'' +
                '}';
    }
}
