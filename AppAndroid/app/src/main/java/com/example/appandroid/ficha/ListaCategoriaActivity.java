package com.example.appandroid.ficha;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appandroid.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ListaCategoriaActivity extends AppCompatActivity {
    private RecyclerView rvCategorias;
    private AdapterCategoria adapterCategoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_categoria);
        rvCategorias=findViewById(R.id.rvListadoCategorias);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        rvCategorias.setLayoutManager(layoutManager);
        cargarCategorias();
    }

    public void cargarCategorias() {
        Call<DatosCategoria> callApi= CategoriaUtil.getCategoriaService().obtenerCategoriasFiltro();
        callApi.enqueue(new Callback<DatosCategoria>() {
            @Override
            public void onResponse(Call<DatosCategoria> call, Response<DatosCategoria> response) {
                Categoria[] arrayCategorias=response.body().getData();
                adapterCategoria=new AdapterCategoria(arrayCategorias, new AdapterCategoria.ItemClickListener() {
                    @Override
                    public void onItemClick(Categoria categoria) {
                        //volver con el dato
                        Intent output = new Intent();
                        output.putExtra("idCategoria", categoria.getIdCategoria());
                        output.putExtra("descripcion", categoria.getDescripcion());
                        setResult(RESULT_OK, output);
                        finish();
                    }
                });
                rvCategorias.setAdapter(adapterCategoria);
            }

            @Override
            public void onFailure(Call<DatosCategoria> call, Throwable t) {
                Log.e("s",t.toString());
            }
        });
    }

    private void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}