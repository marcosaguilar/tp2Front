package com.example.appandroid.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datos {
    @SerializedName("data")
    @Expose
    private Usuario[] data;
    @SerializedName("meta")
    @Expose
    private Object meta;

    public Datos() {
    }

    public Usuario[] getData() {
        return data;
    }

    public void setData(Usuario[] data) {
        this.data = data;
    }

    public Object getMeta() {
        return meta;
    }

    public void setMeta(Object meta) {
        this.meta = meta;
    }
}
