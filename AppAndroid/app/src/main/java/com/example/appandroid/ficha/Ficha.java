package com.example.appandroid.ficha;

import com.example.appandroid.api.Persona;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ficha {
    @SerializedName("idFichaClinica")
    @Expose
    private Integer idFichaClinica;

    @SerializedName("fechaHoraCadena")
    @Expose
    private String fechaHoraCadena;

    @SerializedName("fechaDesdeCadena")
    @Expose
    private String fechaDesdeCadena;

    @SerializedName("fechaHastaCadena")
    @Expose
    private String fechaHastaCadena;

    @SerializedName("idEmpleado")
    @Expose
    private Persona idEmpleado;

    @SerializedName("idCliente")
    @Expose
    private Persona idCliente;

    @SerializedName("motivoConsulta")
    @Expose
    private String motivoConsulta;

    @SerializedName("diagnostico")
    @Expose
    private String diagnostico;

    @SerializedName("observacion")
    @Expose
    private String observacion;




    public Ficha() {
    }

    public Integer getIdFichaClinica() {
        return idFichaClinica;
    }

    public void setIdFichaClinica(Integer idFichaClinica) {
        this.idFichaClinica = idFichaClinica;
    }

    public String getFechaHoraCadena() {
        return fechaHoraCadena;
    }

    public void setFechaHoraCadena(String fechaHoraCadena) {
        this.fechaHoraCadena = fechaHoraCadena;
    }

    public String getFechaDesdeCadena() {
        return fechaDesdeCadena;
    }

    public void setFechaDesdeCadena(String fechaDesdeCadena) {
        this.fechaDesdeCadena = fechaDesdeCadena;
    }

    public String getFechaHastaCadena() {
        return fechaHastaCadena;
    }

    public void setFechaHastaCadena(String fechaHastaCadena) {
        this.fechaHastaCadena = fechaHastaCadena;
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

    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @Override
    public String toString() {
        return "Ficha{" +

                '}';
    }
}
