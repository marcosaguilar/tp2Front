package com.example.appandroid.ficha;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;


public interface SubCategoriaService {
    @Headers({
            "Accept: application/json"
    })
    @GET("stock-nutrinatalia/tipoProducto?")
    Call<DatosSubCategoria> obtenerSubCategoriasFiltro(@Query(value = "ejemplo" ,encoded = true) String address);



}
