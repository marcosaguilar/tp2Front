package com.example.appandroid.ficha;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FichaUtil {
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

    public static FichaService getFichaService(){
        return FichaUtil.getClient(URL_BASE).create(FichaService.class);
    }
}
