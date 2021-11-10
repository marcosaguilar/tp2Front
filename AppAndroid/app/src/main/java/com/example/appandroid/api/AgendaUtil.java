package com.example.appandroid.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AgendaUtil {
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

    public static AgendaService getAgendaService(){
        return AgendaUtil.getClient(URL_BASE).create(AgendaService.class);
    }

}
