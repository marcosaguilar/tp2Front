package com.example.appandroid;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appandroid.api.AdapterPaciente;
import com.example.appandroid.api.DatosPaciente;
import com.example.appandroid.api.Paciente;
import com.example.appandroid.api.PacienteUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ListaClienteActivity extends AppCompatActivity {
    String value;
    private RecyclerView rvPacientes;
    private AdapterPaciente adapterPaciente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //value = getIntent().getExtras().getString("consulta");
        setContentView(R.layout.activity_lista_empleado);
        rvPacientes=findViewById(R.id.rvListadoPacientes);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        rvPacientes.setLayoutManager(layoutManager);
        cargarPacientes();
    }

    public void cargarPacientes() {
        Call<DatosPaciente> callApi= PacienteUtil.getPacienteService().obtenerPacientesFiltro("");
        callApi.enqueue(new Callback<DatosPaciente>() {
            @Override
            public void onResponse(Call<DatosPaciente> call, Response<DatosPaciente> response) {
                Paciente[] arrayPacientes=response.body().getData();
                adapterPaciente=new AdapterPaciente(arrayPacientes, new AdapterPaciente.ItemClickListener() {
                    @Override
                    public void onItemClick(Paciente paciente) {
                        //volver con el dato
                        Intent output = new Intent();
                        output.putExtra("idPersona", paciente.getIdPersona());
                        output.putExtra("nombre", paciente.getNombre());
                        setResult(RESULT_OK, output);
                        finish();
                    }
                });
                rvPacientes.setAdapter(adapterPaciente);
            }

            @Override
            public void onFailure(Call<DatosPaciente> call, Throwable t) {
                Log.e("s",t.toString());
            }
        });
    }

    private void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}