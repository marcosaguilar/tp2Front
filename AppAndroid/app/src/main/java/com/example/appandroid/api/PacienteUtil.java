package com.example.appandroid.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PacienteUtil {
    private static Retrofit retrofit=null;
    private static String URL_BASE="https://equipoyosh.com/";
    public static Retrofit getClient(String baseUrl) {
        if (retrofit==null) {
            retrofit=new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static PacienteService getPacienteService(){
        return PacienteUtil.getClient(URL_BASE).create(PacienteService.class);
    }
}
