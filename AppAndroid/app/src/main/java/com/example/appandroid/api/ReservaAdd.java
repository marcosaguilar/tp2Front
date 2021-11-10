package com.example.appandroid.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ReservaAdd {
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
    private PersonaId idEmpleado;

    @SerializedName("idCliente")
    @Expose
    private PersonaId idCliente;



    public ReservaAdd() {
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

    public PersonaId getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(PersonaId idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public PersonaId getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(PersonaId idCliente) {
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
