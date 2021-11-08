package com.example.appandroid.api;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface UsuarioService {
    @Headers({
            "Accept: application/json"
    })
    @GET("users")
    Call<Datos> obtenerUsuarios();

    @Headers({
            "Accept: application/json",
            "Authorization: Bearer d21472b7bdb23496d183a270e9a3516ce03fd7bf26f4e05e6efa94e105d1abc5"
    })
    @POST("users/")
    Call<Datos> agregarUsuario(@Body Usuario usuario);
}
