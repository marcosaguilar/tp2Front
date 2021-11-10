package com.example.appandroid.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DatosReserva {
    @SerializedName("lista")
    @Expose
    private Reserva[] data;
    @SerializedName("totaldatos")
    @Expose
    private String total;

    public DatosReserva() {
    }

    public Reserva[] getData() {
        return data;
    }

    public void setData(Reserva[] data) {
        this.data = data;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
