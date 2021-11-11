package com.example.appandroid;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appandroid.api.PersonaId;
import com.example.appandroid.api.Reserva;

import java.util.ArrayList;


public class FiltroReservaActivity extends AppCompatActivity {
    TextView empleadoAgregar;
    TextView clienteAgregar;
    EditText fechaDesde;
    EditText fechaHasta;
    String consulta = "";

    ArrayList<String> listaFiltros = new ArrayList<String>();

    PersonaId idEmpleado = new PersonaId();
    PersonaId idCliente= new PersonaId();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtro_reserva);
        fechaDesde=findViewById(R.id.txtFechaDesde);
        fechaHasta=findViewById(R.id.txtFechaHasta);
        empleadoAgregar=findViewById(R.id.txtEmpleadoAgregarReserva);
        clienteAgregar=findViewById(R.id.txtClienteAgregarReserva);
    }

    public void agregarFiltroEmpleadoReserva(View view) {
        Intent intentEmpleado=new Intent(this, ListaEmpleadoActivity.class);
        startActivityForResult(intentEmpleado, 2);
    }

    public void agregarFiltroClienteReserva(View view) {
        Intent intentEmpleado=new Intent(this, ListaClienteActivity.class);
        startActivityForResult(intentEmpleado, 3);
    }

    public void btnEventoFiltrarReserva(View v) {
        Intent principalIntent=new Intent(this, ReservasActivity.class);
        Bundle bundle=new Bundle();
        //armar la query
        //consulta=""
        /*for(int x=0; x<listaFiltros.size();x++){
            listaFiltros.get(x);
        }*/

        consulta = "";
        if(idCliente.getIdPersona()!=null){
            consulta=consulta+"\"idCliente\":{\"idPersona\":" + idCliente.getIdPersona() + "}";
        }
        if(idEmpleado.getIdPersona()!=null){
            //si el filtro no esta vacio agrega la coma
            if(!consulta.equals("")){
                consulta=consulta+',';
            }
            consulta=consulta+"\"idEmpleado\":{\"idPersona\":" + idEmpleado.getIdPersona() + "}";
        }
        if(!fechaDesde.getText().toString().equals("")){
            //si el filtro no esta vacio agrega la coma
            if(!consulta.equals("")){
                consulta=consulta+',';
            }
            consulta=consulta+"\"fechaDesdeCadena\":\""+ fechaDesde.getText().toString() +"\"";
        }
        if(!fechaHasta.getText().toString().equals("")){
            //si el filtro no esta vacio agrega la coma
            if(!consulta.equals("")){
                consulta=consulta+',';
            }
            consulta=consulta+"\"fechaHastaCadena\":\""+fechaHasta.getText().toString() +"\"";
        }

        if(!consulta.equals("")){
            consulta = "{" + consulta + "}";
        }

        bundle.putString("consulta", consulta);
        bundle.putString("user", getIntent().getExtras().getString("user"));
        principalIntent.putExtras(bundle);
        startActivity(principalIntent);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        listaFiltros = new ArrayList<String>();
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
        }
    }
}