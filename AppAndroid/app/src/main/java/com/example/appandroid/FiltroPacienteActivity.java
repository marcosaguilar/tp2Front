package com.example.appandroid;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class FiltroPacienteActivity extends AppCompatActivity {
    String value;

    EditText nombre;
    EditText apellido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtro_paciente);
        nombre=findViewById(R.id.textNombrePaciente);
        apellido=findViewById(R.id.textApellidoPaciente);
    }

    public void btnEventoFiltrarPaciente(View v) {
        Intent principalIntent=new Intent(this, PacientesActivity.class);
        Bundle bundle=new Bundle();

        if(nombre.getText().toString().equals("") && apellido.getText().toString().equals("")){
            bundle.putString("consulta","");
        }else if(nombre.getText().toString().equals("") && !apellido.getText().toString().equals("")){
            bundle.putString("consulta",
                    Uri.encode("{\"apellido\":\""+ apellido.getText().toString() +"\"}"));
        }
        else if(!nombre.getText().toString().equals("") && apellido.getText().toString().equals("")){
            bundle.putString("consulta",
                    Uri.encode("{\"nombre\":\""+ nombre.getText().toString() +"\"}"));
        }else if(!nombre.getText().toString().equals("") && !apellido.getText().toString().equals("")){
            bundle.putString("consulta",
                    Uri.encode( "{\"nombre\":\""
                            + nombre.getText().toString() +"\", \"apellido\":\""
                            + apellido.getText().toString() +"\"}"));
        }



        principalIntent.putExtras(bundle);
        startActivity(principalIntent);
    }
}