package com.example.appandroid.ficha;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;


public interface CategoriaService {
    @Headers({
            "Accept: application/json"
    })
    @GET("stock-nutrinatalia/categoria?")
    Call<DatosCategoria> obtenerCategoriasFiltro();



}
