package com.example.andre.healthyplus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class FirstLogin extends AppCompatActivity {
    private Button btnAceptar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_login);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        String[] letra = {"Seleccionar","Hombre","Mujer"};
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, letra));

        btnAceptar = findViewById(R.id.btnAceptarRegistro);
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login = new Intent(FirstLogin.this, Menu.class);
                startActivity(login);
                finish();
            }
        });
    }
}
