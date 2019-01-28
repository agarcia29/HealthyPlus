package com.example.andre.healthyplus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Registro extends AppCompatActivity {
    Button btnRegistro;
    Button btnCancelar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        btnRegistro = findViewById(R.id.btnAceptarRegistro);

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent firstLogin = new Intent(Registro.this, FirstLogin.class);
                startActivity(firstLogin);
                finish();
            }
        });
        btnCancelar = findViewById(R.id.btnCancelar);
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login = new Intent(Registro.this, Login.class);
                startActivity(login);
                finish();
            }
        });
    }
}
