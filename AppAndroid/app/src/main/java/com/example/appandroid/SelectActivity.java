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
import com.example.appandroid.ficha.FiltroFichaActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
    }

    public void btnEventoAdministracionPacientes(View v) {
            Intent principalIntent=new Intent(this, FiltroPacienteActivity.class);
            startActivity(principalIntent);
    }

    public void btnEventoReservaTurnos(View v) {
        Intent principalIntent=new Intent(this, FiltroReservaActivity.class);
        Bundle bundle=new Bundle();
        bundle.putString("user",getIntent().getExtras().getString("user"));
        principalIntent.putExtras(bundle);
        startActivity(principalIntent);
    }

    public void btnEventoFichaClinica(View v) {
        Intent principalIntent=new Intent(this, FiltroFichaActivity.class);
        Bundle bundle=new Bundle();
        bundle.putString("user",getIntent().getExtras().getString("user"));
        principalIntent.putExtras(bundle);
        startActivity(principalIntent);
    }
}