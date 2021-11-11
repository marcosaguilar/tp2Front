package com.example.appandroid.ficha;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DatosSubCategoria {
    @SerializedName("lista")
    @Expose
    private SubCategoria[] data;
    @SerializedName("totaldatos")
    @Expose
    private String total;

    public DatosSubCategoria() {
    }

    public SubCategoria[] getData() {
        return data;
    }

    public void setData(SubCategoria[] data) {
        this.data = data;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
