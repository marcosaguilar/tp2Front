package com.example.appandroid.ficha;

import com.example.appandroid.api.Persona;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Categoria {
    @SerializedName("idCategoria")
    @Expose
    private Integer idCategoria;

    @SerializedName("descripcion")
    @Expose
    private String descripcion;

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Categoria() {
    }



    @Override
    public String toString() {
        return "Ficha{" +

                '}';
    }
}
