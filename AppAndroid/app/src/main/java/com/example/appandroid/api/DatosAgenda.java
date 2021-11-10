package com.example.appandroid.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DatosAgenda {
    @Expose
    private Agenda[] data;

    public DatosAgenda() {
    }

    public Agenda[] getData() {
        return data;
    }

    public void setData(Agenda[] data) {
        this.data = data;
    }

}
