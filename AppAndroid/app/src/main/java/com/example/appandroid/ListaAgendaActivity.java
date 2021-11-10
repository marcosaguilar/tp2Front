package com.example.appandroid;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appandroid.api.AdapterAgenda;
import com.example.appandroid.api.DatosAgenda;
import com.example.appandroid.api.Agenda;
import com.example.appandroid.api.AgendaUtil;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ListaAgendaActivity extends AppCompatActivity {
    private RecyclerView rvAgendas;
    private AdapterAgenda adapterAgenda;
    String hora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //value = getIntent().getExtras().getString("consulta");
        setContentView(R.layout.activity_lista_agenda);
        rvAgendas=findViewById(R.id.rvListadoAgendas);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        rvAgendas.setLayoutManager(layoutManager);
        cargarAgendas();
    }

    public void cargarAgendas() {
        hora = getIntent().getExtras().getString("hora");
        Call<Agenda[]> callApi= AgendaUtil.getAgendaService().obtenerAgendas(2,hora,"S");
        callApi.enqueue(new Callback<Agenda[]>() {
            @Override
            public void onResponse(Call<Agenda[]> call, Response<Agenda[]> response) {
                Agenda[] arrayAgendas=response.body();
                adapterAgenda=new AdapterAgenda(arrayAgendas, new AdapterAgenda.ItemClickListener() {
                    @Override
                    public void onItemClick(Agenda agenda) {
                        //volver con el dato
                        Intent output = new Intent();
                        output.putExtra("horaInicio", agenda.getHoraInicio());
                        output.putExtra("horaFin", agenda.getHoraFin());
                        setResult(RESULT_OK, output);
                        finish();
                    }
                });
                rvAgendas.setAdapter(adapterAgenda);
            }

            @Override
            public void onFailure(Call<Agenda[]> call, Throwable t) {

            }
        });
    }

    private void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}