package com.example.appandroid.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtil {
    private static Retrofit retrofit=null;
    private static String URL_BASE="http://gorest.co.in/public/v1/";
    public static Retrofit getClient(String baseUrl) {
        if (retrofit==null) {
            retrofit=new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static UsuarioService getUsuarioService(){
        return RetrofitUtil.getClient(URL_BASE).create(UsuarioService.class);
    }
}
