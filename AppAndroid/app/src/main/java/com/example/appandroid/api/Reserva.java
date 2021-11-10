package com.example.appandroid.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Reserva {
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



    public Reserva() {
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
