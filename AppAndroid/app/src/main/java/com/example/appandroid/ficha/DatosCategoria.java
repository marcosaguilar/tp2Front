package com.example.appandroid.ficha;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DatosCategoria {
    @SerializedName("lista")
    @Expose
    private Categoria[] data;
    @SerializedName("totaldatos")
    @Expose
    private String total;

    public DatosCategoria() {
    }

    public Categoria[] getData() {
        return data;
    }

    public void setData(Categoria[] data) {
        this.data = data;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
