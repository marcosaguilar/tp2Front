package com.example.appandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText usuario;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuario=findViewById(R.id.textNombreUsuario);
        password=findViewById(R.id.textPassword);
    }

    public void btnEventoIngresar(View v) {
        if (usuario.getText().toString().equalsIgnoreCase("admin")
        && password.getText().toString().equalsIgnoreCase("123")) {
            Intent principalIntent=new Intent(this, SelectActivity.class);
            Bundle bundle=new Bundle();
            bundle.putString("usuario",usuario.getText().toString());
            principalIntent.putExtras(bundle);
            startActivity(principalIntent);
        } else {
            Toast.makeText(
                    MainActivity.this,R.string.credencialNoValida,Toast.LENGTH_LONG).show();
        }
    }
}