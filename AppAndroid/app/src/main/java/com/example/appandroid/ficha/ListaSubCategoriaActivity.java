package com.example.appandroid.ficha;

import android.content.Intent;
import android.net.Uri;
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


public class ListaSubCategoriaActivity extends AppCompatActivity {
    private RecyclerView rvSubCategorias;
    private AdapterSubCategoria adapterSubCategoria;

    String consulta = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_subcategoria);
        rvSubCategorias=findViewById(R.id.rvListadoSubCategorias);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        rvSubCategorias.setLayoutManager(layoutManager);


        consulta = "";
        if(getIntent().getExtras().getInt("categoria") != -1){
            consulta = "{\"idCategoria\":{\"idCategoria\":"+getIntent().getExtras().getInt("categoria")+"}}";
        }

        cargarSubCategorias();
    }

    public void cargarSubCategorias() {
        System.out.println("la consulta es: "+consulta);
        Call<DatosSubCategoria> callApi= SubCategoriaUtil.getSubCategoriaService().obtenerSubCategoriasFiltro(Uri.encode(consulta));
        callApi.enqueue(new Callback<DatosSubCategoria>() {
            @Override
            public void onResponse(Call<DatosSubCategoria> call, Response<DatosSubCategoria> response) {
                SubCategoria[] arraySubCategorias=response.body().getData();
                adapterSubCategoria=new AdapterSubCategoria(arraySubCategorias, new AdapterSubCategoria.ItemClickListener() {
                    @Override
                    public void onItemClick(SubCategoria subCategoria) {
                        //volver con el dato
                        Intent output = new Intent();
                        output.putExtra("idSubCategoria", subCategoria.getIdTipoProducto());
                        output.putExtra("descripcion", subCategoria.getDescripcion());
                        setResult(RESULT_OK, output);
                        finish();
                    }
                });
                rvSubCategorias.setAdapter(adapterSubCategoria);
            }

            @Override
            public void onFailure(Call<DatosSubCategoria> call, Throwable t) {
                Log.e("s",t.toString());
            }
        });
    }

    private void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}