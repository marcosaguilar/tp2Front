package com.example.appandroid.ficha;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SubCategoriaUtil {
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

    public static SubCategoriaService getSubCategoriaService(){
        return SubCategoriaUtil.getClient(URL_BASE).create(SubCategoriaService.class);
    }
}
