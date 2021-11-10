package com.example.appandroid;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appandroid.api.AdapterReserva;
import com.example.appandroid.api.AdapterReserva;
import com.example.appandroid.api.DatosPaciente;
import com.example.appandroid.api.DatosReserva;
import com.example.appandroid.api.Paciente;
import com.example.appandroid.api.Reserva;
import com.example.appandroid.api.ReservaUtil;
import com.example.appandroid.api.Reserva;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ReservasActivity extends AppCompatActivity {
    private RecyclerView rvReservas;
    private AdapterReserva adapterReserva;
    private FloatingActionButton fabNuevaReserva;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva);
        rvReservas=findViewById(R.id.rvListadoReservas);
        fabNuevaReserva=findViewById(R.id.fabNuevaReserva);
        fabNuevaReserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newReservaIntent=new Intent(ReservasActivity.this, NewReservaActivity.class);
                Bundle bundle=new Bundle();
                bundle.putString("user",getIntent().getExtras().getString("user"));
                newReservaIntent.putExtras(bundle);
                startActivity(newReservaIntent);
            }
        });
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        rvReservas.setLayoutManager(layoutManager);
        cargarReservas();
    }

    public void cargarReservas() {
        Call<DatosReserva> callApi= ReservaUtil.getReservaService().obtenerReservasFiltro(getIntent().getExtras().getString("consulta"));
        callApi.enqueue(new Callback<DatosReserva>() {
            @Override
            public void onResponse(Call<DatosReserva> call, Response<DatosReserva> response) {
                Reserva[] arrayReservas=response.body().getData();
                adapterReserva=new AdapterReserva(arrayReservas, new AdapterReserva.ItemClickListener() {
                    @Override
                    public void onItemClick(Reserva reserva) {
                        //ir a la pagina con los datos del paciente cargado y dos botones,
                        // uno modificar y otro eliminar (no se si para el caso de pacientes)
                        showToast(reserva.getIdCliente().getNombre());
                    }
                });
                rvReservas.setAdapter(adapterReserva);
            }

            @Override
            public void onFailure(Call<DatosReserva> call, Throwable t) {
                Log.e("s",t.toString());
            }
        });
    }

    private void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}