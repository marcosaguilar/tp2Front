package com.example.appandroid.api;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface AgendaService {
    @Headers({
            "Accept: application/json"
    })

    @GET("stock-nutrinatalia/persona/{id}/agenda?")
    Call<Agenda[]> obtenerAgendas(@Path("id") int id,
                                   @Query(value = "fecha" ,encoded = true) String fecha,
                                   @Query(value = "disponible" ,encoded = true) String disponible);
}
