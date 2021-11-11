package com.example.appandroid.ficha;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubCategoria {
    @SerializedName("idTipoProducto")
    @Expose
    private Integer idTipoProducto;

    @SerializedName("descripcion")
    @Expose
    private String descripcion;

    @SerializedName("idCategoria")
    @Expose
    private Categoria idCategoria;



    public SubCategoria() {
    }


    public Integer getIdTipoProducto() {
        return idTipoProducto;
    }

    public void setIdTipoProducto(Integer idTipoProducto) {
        this.idTipoProducto = idTipoProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    @Override
    public String toString() {
        return "Ficha{" +

                '}';
    }
}
