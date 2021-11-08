package com.example.appandroid;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appandroid.api.Paciente;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class NewPacienteActivity extends AppCompatActivity {
    private EditText nombre;
    private EditText apellido;
    private EditText email;
    private EditText telefono;
    private EditText ruc;
    private EditText cedula;
    private EditText tipoPersona;
    private EditText fechaNacimiento;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_paciente);
        nombre=findViewById(R.id.txtNombreNuevo);
        apellido=findViewById(R.id.txtApellidoNuevo);
        email=findViewById(R.id.txtEmailNuevo);
        telefono=findViewById(R.id.txtTelefonoNuevo);
        ruc=findViewById(R.id.txtRucNuevo);
        cedula=findViewById(R.id.txtCedulaNuevo);
        tipoPersona=findViewById(R.id.txtTipoPersonaNuevo);
        fechaNacimiento=findViewById(R.id.txtFechaNacimientoNuevo);
    }

    public void agregarNuevoPaciente(View v) {
        Paciente paciente =new Paciente();
        paciente.setNombre(nombre.getText().toString());
        paciente.setApellido(apellido.getText().toString());
        paciente.setEmail(email.getText().toString());
        paciente.setTelefono(telefono.getText().toString());
        paciente.setRuc(ruc.getText().toString());
        paciente.setCedula(cedula.getText().toString());
        paciente.setTipoPersona(tipoPersona.getText().toString());
        paciente.setFechaNacimiento(fechaNacimiento.getText().toString());




        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {

            public void run() {

                MediaType JSON
                        = MediaType.parse("application/json; charset=utf-8");

                OkHttpClient client = new OkHttpClient();


                RequestBody body = RequestBody.create(JSON,new Gson().toJson(paciente));
                Request request = new Request.Builder()
                        .url("https://equipoyosh.com/stock-nutrinatalia/persona")
                        .post(body)
                        //.addHeader("Authorization","Bearer d21472b7bdb23496d183a270e9a3516ce03fd7bf26f4e05e6efa94e105d1abc5")
                        .addHeader("Content-Type","application/json")
                        .build();
                Response response = null;
                try {
                    response = client.newCall(request).execute();
                    String respuesta = response.body().string();
                    Log.e("s",respuesta);
                    finish();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}