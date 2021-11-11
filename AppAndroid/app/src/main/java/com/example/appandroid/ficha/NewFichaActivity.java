package com.example.appandroid.ficha;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appandroid.ListaAgendaActivity;
import com.example.appandroid.ListaClienteActivity;
import com.example.appandroid.ListaEmpleadoActivity;
import com.example.appandroid.R;
import com.example.appandroid.api.PersonaId;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class NewFichaActivity extends AppCompatActivity {
    TextView empleadoAgregar;
    TextView clienteAgregar;
    TextView horaAgregar;
    EditText fecha;

    PersonaId idEmpleado = new PersonaId();
    PersonaId idCliente= new PersonaId();

    String horaInicio;
    String horaFin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_ficha);
        empleadoAgregar=findViewById(R.id.txtEmpleadoAgregar);
        clienteAgregar=findViewById(R.id.txtClienteAgregar);
        fecha=findViewById(R.id.txtFecha);
        horaAgregar=findViewById(R.id.txtHoraAgregar);


    }


    public void agregarFiltroEmpleado(View view) {
        Intent intentEmpleado=new Intent(this, ListaEmpleadoActivity.class);
        startActivityForResult(intentEmpleado, 2);
    }

    public void agregarFiltroCliente(View view) {
        Intent intentEmpleado=new Intent(this, ListaClienteActivity.class);
        startActivityForResult(intentEmpleado, 3);
    }

    public void buscarHora(View view) {
        Intent intentEmpleado=new Intent(this, ListaAgendaActivity.class);
        intentEmpleado.putExtra("hora",fecha.getText().toString());
        startActivityForResult(intentEmpleado, 4);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode) {
            case (2) : {
                if (resultCode == ListaEmpleadoActivity.RESULT_OK) {
                    // TODO Extract the data returned from the child Activity.
                    idEmpleado.setIdPersona(data.getIntExtra("idPersona", -1));
                    empleadoAgregar.setText(data.getStringExtra("nombre"));
                    //Toast.makeText(this, returnValue.toString(), Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case (3) : {
                if (resultCode == ListaClienteActivity.RESULT_OK) {
                    // TODO Extract the data returned from the child Activity.
                    idCliente.setIdPersona(data.getIntExtra("idPersona", -1));
                    clienteAgregar.setText(data.getStringExtra("nombre"));
                    //Toast.makeText(this, returnValue.toString(), Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case (4) : {
                if (resultCode == ListaAgendaActivity.RESULT_OK) {
                    // TODO Extract the data returned from the child Activity.
                    horaAgregar.setText(data.getStringExtra("horaInicio") + "-"+
                            data.getStringExtra("horaFin"));
                    horaInicio = data.getStringExtra("horaInicio");
                    horaFin = data.getStringExtra("horaFin");
                    //Toast.makeText(this, returnValue.toString(), Toast.LENGTH_SHORT).show();
                }
                break;
            }
        }
    }

    /*public void agregarNuevaFicha(View v) {
        FichaAdd fichaAdd =new FichaAdd();
        fichaAdd.setIdCliente(idCliente);
        fichaAdd.setIdEmpleado(idEmpleado);
        fichaAdd.setFechaCadena(fecha.getText().toString());
        fichaAdd.setHoraInicioCadena(horaInicio);
        fichaAdd.setHoraFinCadena(horaFin);




        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {

            public void run() {

                MediaType JSON
                        = MediaType.parse("application/json; charset=utf-8");

                OkHttpClient client = new OkHttpClient();


                RequestBody body = RequestBody.create(JSON,new Gson().toJson(fichaAdd));
                Request request = new Request.Builder()
                        .url("https://equipoyosh.com/stock-nutrinatalia/ficha")
                        .post(body)
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

    }*/
}