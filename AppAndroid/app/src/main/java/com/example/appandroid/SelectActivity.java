package com.example.appandroid;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appandroid.api.AdapterUsuario;
import com.example.appandroid.api.Datos;
import com.example.appandroid.api.RetrofitUtil;
import com.example.appandroid.api.Usuario;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SelectActivity extends AppCompatActivity {
    String value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        value = getIntent().getExtras().getString("usuario");
    }

    public void btnEventoAdministracionPacientes(View v) {
            System.out.println("el valor es: " + value);
            Intent principalIntent=new Intent(this, PacientesActivity.class);
            startActivity(principalIntent);
    }

    public void btnEventoReservaTurnos(View v) {
        Intent principalIntent=new Intent(this, PrincipalActivity.class);
        startActivity(principalIntent);
    }

    public void btnEventoFichaClinica(View v) {
        Intent principalIntent=new Intent(this, PrincipalActivity.class);
        startActivity(principalIntent);
    }
}