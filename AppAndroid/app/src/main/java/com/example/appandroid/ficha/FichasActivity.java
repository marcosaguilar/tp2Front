package com.example.appandroid.ficha;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appandroid.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FichasActivity extends AppCompatActivity {
    private RecyclerView rvFichas;
    private AdapterFicha adapterFicha;
    private FloatingActionButton fabNuevaFicha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ficha);
        rvFichas=findViewById(R.id.rvListadoFichas);
        fabNuevaFicha=findViewById(R.id.fabNuevaFicha);
        fabNuevaFicha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newFichaIntent=new Intent(FichasActivity.this, NewFichaActivity.class);
                Bundle bundle=new Bundle();
                bundle.putString("user",getIntent().getExtras().getString("user"));
                newFichaIntent.putExtras(bundle);
                startActivity(newFichaIntent);
            }
        });
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        rvFichas.setLayoutManager(layoutManager);
        cargarFichas();
    }

    public void cargarFichas() {
        System.out.println("La consulta fue: " + getIntent().getExtras().getString("consulta"));
        Call<DatosFicha> callApi= FichaUtil.getFichaService().obtenerFichasFiltro(Uri.encode(getIntent().getExtras().getString("consulta")));
        callApi.enqueue(new Callback<DatosFicha>() {
            @Override
            public void onResponse(Call<DatosFicha> call, Response<DatosFicha> response) {
                Ficha[] arrayFichas=response.body().getData();
                adapterFicha=new AdapterFicha(arrayFichas, new AdapterFicha.ItemClickListener() {
                    @Override
                    public void onItemClick(Ficha ficha) {
                        //ir a la pagina con los datos del paciente cargado y dos botones,
                        // uno modificar y otro eliminar (no se si para el caso de pacientes)
                        //showToast(ficha.getIdCliente().getNombre());

                        /*Intent modificarFichaIntent=new Intent(FichasActivity.this, ModificarFichaActivity.class);
                        Bundle bundle=new Bundle();
                        bundle.putString("user",getIntent().getExtras().getString("user"));
                        bundle.putString("idFicha",ficha.getIdFichaClinica().toString());
                        bundle.putString("cliente",ficha.getIdCliente().getNombre());
                        bundle.putString("empleado",ficha.getIdEmpleado().getNombre());
                        bundle.putString("fecha",ficha.getFechaHoraCadena());
                        bundle.putString("horaInicio",ficha.getFechaDesdeCadena());
                        bundle.putString("horaFin",ficha.getFechaHastaCadena());
                        bundle.putString("observacion",ficha.getObservacion());

                        modificarFichaIntent.putExtras(bundle);
                        startActivity(modificarFichaIntent);*/
                    }
                });
                rvFichas.setAdapter(adapterFicha);
            }

            @Override
            public void onFailure(Call<DatosFicha> call, Throwable t) {
                Log.e("s",t.toString());
            }
        });
    }

    private void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}