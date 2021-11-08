package com.example.appandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appandroid.api.Datos;
import com.example.appandroid.api.RetrofitUtil;
import com.example.appandroid.api.Usuario;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class NewUserActivity extends AppCompatActivity {
    private EditText nombre;
    private EditText email;
    private EditText genero;
    private EditText estado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);
        nombre=findViewById(R.id.txtUsuarioNuevo);
        email=findViewById(R.id.txtEmailNuevo);
        genero=findViewById(R.id.txtGeneroNuevo);
        estado=findViewById(R.id.txtEstadoNuevo);
    }

    public void agregarNuevoUsuario(View v) {
        Usuario usuario=new Usuario();
        usuario.setName(nombre.getText().toString());
        usuario.setEmail(email.getText().toString());
        usuario.setGender(genero.getText().toString());
        usuario.setStatus(estado.getText().toString());

        /*Call<DatosPostResponse> callApi= RetrofitUtil.getUsuarioService().agregarUsuario(usuario);
        callApi.enqueue(new Callback<DatosPostResponse>() {
            @Override
            public void onResponse(Call<DatosPostResponse> call, Response<DatosPostResponse> response) {
                Usuario usuarioAgregado=response.body().getData();
                Toast.makeText(
                        NewUserActivity.this,"usuario nuevo agregado con id: "+usuarioAgregado.getId(),Toast.LENGTH_LONG).show();
                finish();
            }

            @Override
            public void onFailure(Call<DatosPostResponse> call, Throwable t) {
                Log.e("s",t.toString());
            }
        });*/



        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {

            public void run() {

                MediaType JSON
                        = MediaType.parse("application/json; charset=utf-8");

                OkHttpClient client = new OkHttpClient();


                RequestBody body = RequestBody.create(JSON,new Gson().toJson(usuario));
                Request request = new Request.Builder()
                        .url("https://gorest.co.in/public/v1/users")
                        .post(body)
                        .addHeader("Authorization","Bearer d21472b7bdb23496d183a270e9a3516ce03fd7bf26f4e05e6efa94e105d1abc5")
                        .addHeader("Content-Type","application/json")
                        .build();
                Response response = null;
                try {
                    response = client.newCall(request).execute();
                    String respuesta = response.body().string();
                    Log.e("s",respuesta);
                    finish();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });






    }
}