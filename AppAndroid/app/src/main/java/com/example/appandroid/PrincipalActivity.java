package com.example.appandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;

import com.example.appandroid.api.AdapterUsuario;
import com.example.appandroid.api.Datos;
import com.example.appandroid.api.RetrofitUtil;
import com.example.appandroid.api.Usuario;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PrincipalActivity extends AppCompatActivity {
    private RecyclerView rvUsuarios;
    private AdapterUsuario adapterUsuario;
    private FloatingActionButton fabNuevoUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        rvUsuarios=findViewById(R.id.rvListadoUsuarios);
        fabNuevoUsuario=findViewById(R.id.fabNuevoUsuario);
        fabNuevoUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newUserIntent=new Intent(PrincipalActivity.this, NewUserActivity.class);
                startActivity(newUserIntent);
            }
        });
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        rvUsuarios.setLayoutManager(layoutManager);
        cargarUsuarios();
    }
    public void invocarApi(View v) {
        Call<Datos> callApi= RetrofitUtil.getUsuarioService().obtenerUsuarios();
        callApi.enqueue(new Callback<Datos>() {
            @Override
            public void onResponse(Call<Datos> call, Response<Datos> response) {
                Usuario[] arrayUsuarios=response.body().getData();
                for (int i=0;i<arrayUsuarios.length;i++) {
                    Log.e("s","usuario "+i+": "+arrayUsuarios[i]);
                }
            }

            @Override
            public void onFailure(Call<Datos> call, Throwable t) {
                Log.e("s",t.toString());
            }
        });
    }

    public void cargarUsuarios() {
        Call<Datos> callApi= RetrofitUtil.getUsuarioService().obtenerUsuarios();
        callApi.enqueue(new Callback<Datos>() {
            @Override
            public void onResponse(Call<Datos> call, Response<Datos> response) {
                Usuario[] arrayUsuarios=response.body().getData();
                adapterUsuario=new AdapterUsuario(arrayUsuarios);
                rvUsuarios.setAdapter(adapterUsuario);
            }

            @Override
            public void onFailure(Call<Datos> call, Throwable t) {
                Log.e("s",t.toString());
            }
        });
    }
}