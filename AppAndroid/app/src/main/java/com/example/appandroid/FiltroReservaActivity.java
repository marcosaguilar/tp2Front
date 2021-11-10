package com.example.appandroid;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appandroid.api.Reserva;


public class FiltroReservaActivity extends AppCompatActivity {

    EditText nombre;
    EditText apellido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtro_reserva);
        nombre=findViewById(R.id.textNombrePaciente);
        apellido=findViewById(R.id.textApellidoPaciente);
    }

    public void btnEventoFiltrarReserva(View v) {
        Intent principalIntent=new Intent(this, ReservasActivity.class);
        Bundle bundle=new Bundle();
        bundle.putString("consulta", "");
        bundle.putString("user", getIntent().getExtras().getString("user"));
        principalIntent.putExtras(bundle);
        startActivity(principalIntent);
    }
}