package com.example.andre.healthyplus;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.andre.healthyplus.session.Preferences;

import OpenHelper.SQLite_OpenHelper;

public class EstadoCorporal extends AppCompatActivity {
    Button btnAceptar;
    TextView popUp, txtNombre, txtPeso, txtAltura, txtImc, txtEstado;
    Preferences prf;

    SQLite_OpenHelper helper = new SQLite_OpenHelper(this,"Bdatos", null , 1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_alert);

        txtNombre = findViewById(R.id.txtNombre);
        txtPeso = findViewById(R.id.txtPeso);
        txtAltura = findViewById(R.id.txtAltura);
        txtImc = findViewById(R.id.txtImc);
        txtEstado = findViewById(R.id.txtEstado);
        btnAceptar = findViewById(R.id.btnAceptar);
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inicio = new Intent(EstadoCorporal.this, Menu.class);
                startActivity(inicio);
                finish();
            }
        });
        prf = Preferences.get(EstadoCorporal.this);
        txtNombre.setText(prf.getValue(Preferences.PREF_user_NAME));
        txtPeso.setText(prf.getValue(Preferences.PREF_user_WEIGHT));
        txtAltura.setText(prf.getValue(Preferences.PREF_user_HEIGHT));
        txtImc.setText(prf.getValue(Preferences.PREF_user_IMC));
        txtEstado.setText(prf.getValue(Preferences.PREF_user_STATUS));
    }

}
