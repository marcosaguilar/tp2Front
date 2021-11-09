package com.example.appandroid.api;

import android.net.Uri;

import java.net.URI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;



public interface PacienteService {
    @Headers({
            "Accept: application/json"
    })
    @GET("stock-nutrinatalia/persona")
    Call<DatosPaciente> obtenerPacientes();

    /*@Headers({
            "Accept: application/json"
    })

    @GET("stock-nutrinatalia/persona?ejemplo=%7B%22soloUsuariosDelSistema%22%3Atrue%7D")
    Call<DatosPaciente> obtenerUsuariosLogin();*/

    @Headers({
            "Accept: application/json",
            "Authorization: Bearer d21472b7bdb23496d183a270e9a3516ce03fd7bf26f4e05e6efa94e105d1abc5"
    })
    @POST("users/")
    Call<DatosPaciente> agregarPaciente(@Body Paciente paciente);


    @Headers({
            "Accept: application/json"
    })

    @GET("stock-nutrinatalia/persona?")
    Call<DatosPaciente> obtenerUsuariosLogin(@Query(value = "ejemplo" ,encoded = true) String address);
    //Call<DatosPaciente> obtenerUsuariosLogin2(@Path(value = "datos", encoded = true) String datos);
}
