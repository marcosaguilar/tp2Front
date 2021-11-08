package com.example.appandroid.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DatosPaciente {
    @SerializedName("lista")
    @Expose
    private Paciente[] data;
    @SerializedName("totaldatos")
    @Expose
    private String total;

    public DatosPaciente() {
    }

    public Paciente[] getData() {
        return data;
    }

    public void setData(Paciente[] data) {
        this.data = data;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
