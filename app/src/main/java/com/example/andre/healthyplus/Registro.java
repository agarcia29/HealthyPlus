package com.example.andre.healthyplus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import OpenHelper.SQLite_OpenHelper;

public class Registro extends AppCompatActivity {
    Button btnRegistro;
    Button btnCancelar;
    EditText edtName;
    EditText edtEmail;
    EditText edtPass;
    EditText edtAge;
    EditText edtAddress, edtWeight, edtHeight, edtSex, edtAllergy;

    SQLite_OpenHelper helper = new SQLite_OpenHelper(this, "Bdatos", null ,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        btnRegistro = findViewById(R.id.btnAceptarRegistro);
        edtName = (EditText) findViewById(R.id.edt_nombre);
        edtEmail = (EditText) findViewById(R.id.edt_correo);
        edtPass = (EditText) findViewById(R.id.edt_pass);
        edtAge = (EditText) findViewById(R.id.edt_fecha);
        edtAddress = (EditText) findViewById(R.id.edt_dir);
        edtWeight = (EditText) findViewById(R.id.edt_peso);
        edtHeight = (EditText) findViewById(R.id.edt_estatura);
        edtSex = (EditText) findViewById(R.id.edtSex);
        edtAllergy = (EditText) findViewById(R.id.edt_allergy);


        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                helper.abrir();
                helper.insertarReg(String.valueOf(edtName.getText()), String.valueOf(edtEmail.getText())
                        , String.valueOf(edtPass.getText())
                        , String.valueOf(edtAge.getText())
                        , String.valueOf(edtAddress.getText())
                        , String.valueOf(edtWeight.getText())
                        , String.valueOf(edtHeight.getText())
                        , String.valueOf(edtSex.getText())
                        , String.valueOf(edtAllergy.getText()));

                helper.cerrar();

                Toast.makeText(getApplicationContext(),"Registro Exitoso", Toast.LENGTH_LONG).show();

                Intent Login = new Intent(getApplicationContext(), Login.class);
                startActivity(Login);
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