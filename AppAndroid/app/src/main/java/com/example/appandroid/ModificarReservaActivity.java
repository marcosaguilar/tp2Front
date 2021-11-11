package com.example.appandroid;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appandroid.api.PersonaId;
import com.example.appandroid.api.Reserva;
import com.example.appandroid.api.ReservaAdd;
import com.example.appandroid.api.ReservaModificar;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class ModificarReservaActivity extends AppCompatActivity {
    TextView empleadoModificar;
    TextView clienteModificar;
    TextView fechaModificar;
    TextView horaInicioModificar;
    TextView horaFinModificar;
    TextView flagEstado;
    EditText observacion;
    EditText asistio;

    PersonaId idEmpleado = new PersonaId();
    PersonaId idCliente= new PersonaId();

    String horaInicio;
    String horaFin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Reserva reserva = (Reserva) getIntent().getSerializableExtra("reserva");

        setContentView(R.layout.activity_modificar_reserva);
        empleadoModificar=findViewById(R.id.txtEmpleadoModificar);
        clienteModificar=findViewById(R.id.txtClienteModificar);
        fechaModificar=findViewById(R.id.txtFechaModificar);
        horaInicioModificar=findViewById(R.id.txtHoraInicioModificar);
        horaFinModificar=findViewById(R.id.txtHoraFinModificar);
        flagEstado=findViewById(R.id.txtFlagEstado);
        observacion=findViewById(R.id.txtObservacion);
        asistio=findViewById(R.id.txtAsistio);

        empleadoModificar.setText(getIntent().getExtras().getString("empleado"));
        clienteModificar.setText(getIntent().getExtras().getString("cliente"));
        fechaModificar.setText(getIntent().getExtras().getString("fecha"));
        horaInicioModificar.setText(getIntent().getExtras().getString("horaInicio"));
        horaFinModificar.setText(getIntent().getExtras().getString("horaFin"));
        flagEstado.setText(getIntent().getExtras().getString("flagEstado"));
        observacion.setText(getIntent().getExtras().getString("observacion"));
        asistio.setText(getIntent().getExtras().getString("asistio"));



    }




    public void modificarReserva(View v) {
        ReservaModificar reservaModificar =new ReservaModificar();
        reservaModificar.setIdReserva(Integer.parseInt(getIntent().getExtras().getString("idReserva")));
        reservaModificar.setObservacion(observacion.getText().toString());
        reservaModificar.setFlagAsistio(asistio.getText().toString());


        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {

            public void run() {

                MediaType JSON
                        = MediaType.parse("application/json; charset=utf-8");

                OkHttpClient client = new OkHttpClient();


                RequestBody body = RequestBody.create(JSON,new Gson().toJson(reservaModificar));
                Request request = new Request.Builder()
                        .url("https://equipoyosh.com/stock-nutrinatalia/reserva")
                        .put(body)
                        //.addHeader("Authorization","Bearer d21472b7bdb23496d183a270e9a3516ce03fd7bf26f4e05e6efa94e105d1abc5")
                        .addHeader("Content-Type","application/json")
                        .addHeader("usuario",getIntent().getExtras().getString("user"))
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


    public void eliminarReserva(View v) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {

            public void run() {

                System.out.println("url de la reserva es: " + "https://equipoyosh.com/stock-nutrinatalia/reserva/" + getIntent().getExtras().getString("idReserva"));

                MediaType JSON
                        = MediaType.parse("application/json; charset=utf-8");

                OkHttpClient client = new OkHttpClient();


                Request request = new Request.Builder()
                        .url("https://equipoyosh.com/stock-nutrinatalia/reserva/" + getIntent().getExtras().getString("idReserva"))
                        .delete()
                        //.addHeader("Authorization","Bearer d21472b7bdb23496d183a270e9a3516ce03fd7bf26f4e05e6efa94e105d1abc5")
                        .addHeader("Content-Type","application/json")
                        .addHeader("usuario",getIntent().getExtras().getString("user"))
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