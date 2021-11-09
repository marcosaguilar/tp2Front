package com.example.appandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appandroid.api.AdapterPaciente;
import com.example.appandroid.api.Datos;
import com.example.appandroid.api.DatosPaciente;
import com.example.appandroid.api.Paciente;
import com.example.appandroid.api.PacienteUtil;
import com.example.appandroid.api.RetrofitUtil;
import com.example.appandroid.api.Usuario;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText usuario;
    EditText password;

    Paciente lista[];
    boolean error=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuario=findViewById(R.id.textNombreUsuario);
        password=findViewById(R.id.textPassword);
        cargarUsuariosLogin();
    }

    public void btnEventoIngresar(View v) {
        for (int i=0;i<lista.length;i++) {

            //System.out.println(lista[i]);
            if(lista[i].getNombre().equalsIgnoreCase(usuario.getText().toString())
                    && password.getText().toString().equalsIgnoreCase("123")){
                error = false;
                Intent principalIntent=new Intent(this, SelectActivity.class);
                Bundle bundle=new Bundle();
                bundle.putString("usuario",usuario.getText().toString());
                principalIntent.putExtras(bundle);
                startActivity(principalIntent);
                break;
            }
            error = true;
        }

        if(error) {
            Toast.makeText(
                    MainActivity.this,R.string.credencialNoValida,Toast.LENGTH_LONG).show();
        }

        /*if (usuario.getText().toString().equalsIgnoreCase("admin")
        && password.getText().toString().equalsIgnoreCase("123")) {
            Intent principalIntent=new Intent(this, SelectActivity.class);
            Bundle bundle=new Bundle();
            bundle.putString("usuario",usuario.getText().toString());
            principalIntent.putExtras(bundle);
            startActivity(principalIntent);
        } else {
            Toast.makeText(
                    MainActivity.this,R.string.credencialNoValida,Toast.LENGTH_LONG).show();
        }*/
    }

    public void cargarUsuariosLogin() {
        Call<DatosPaciente> callApi= PacienteUtil.getPacienteService().obtenerUsuariosLogin(Uri.encode("{\"soloUsuariosDelSistema\":true}"));
        callApi.enqueue(new Callback<DatosPaciente>() {
            @Override
            public void onResponse(Call<DatosPaciente> call, Response<DatosPaciente> response) {
                lista=response.body().getData();
            }

            @Override
            public void onFailure(Call<DatosPaciente> call, Throwable t) {
                Log.e("s",t.toString());
            }
        });
    }
}