package com.example.appandroid.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PersonaId {
    @SerializedName("idPersona")
    @Expose
    private Integer idPersona;



    public PersonaId() {
    }



    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }


    @Override
    public String toString() {
        return "Persona{" +
                "idPersona=" + idPersona +
                '}';
    }
}
