package com.example.appandroid.ficha;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DatosFicha {
    @SerializedName("lista")
    @Expose
    private Ficha[] data;
    @SerializedName("totaldatos")
    @Expose
    private String total;

    public DatosFicha() {
    }

    public Ficha[] getData() {
        return data;
    }

    public void setData(Ficha[] data) {
        this.data = data;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
