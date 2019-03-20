package com.example.andre.healthyplus;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.andre.healthyplus.session.Preferences;

import OpenHelper.SQLite_OpenHelper;

public class Login extends AppCompatActivity {
    Button btnRegistrar;
    Button btnIniciar;
    EditText edtUserLogin, edtPassLogin;
    Preferences prf=null;

    SQLite_OpenHelper helper = new SQLite_OpenHelper(this,"Bdatos", null , 1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnRegistrar = findViewById(R.id.btnregis);
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registro = new Intent(Login.this, Registro.class);
                startActivity(registro);
                finish();
            }
        });



        btnIniciar = findViewById(R.id.btniniciar);
       // popUp = findViewById(R.id.popUp);
                btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtUserLogin = (EditText) findViewById(R.id.user_login);
                edtPassLogin = (EditText) findViewById(R.id.pass_login);

                try {
                    Cursor cursor = helper.ValidacionLogin(edtUserLogin.getText().toString()
                            , edtPassLogin.getText().toString());
                    if (cursor.getCount()>0){
                        prf = Preferences.get(Login.this);
                        prf.saveAuthData(helper.leerBd(cursor));
                        Intent login = new Intent(Login.this, EstadoCorporal.class);
                        startActivity(login);
                        finish();
                    }
                    /*else {
                        cursor = helper.ValidacionLogin(edtUserLogin.getText().toString()
                                , edtPassLogin.getText().toString());
                        if (cursor.getCount() > 0) {
                            Intent login = new Intent(Login.this, Menu.class);
                            startActivity(login);
                        } */else {
                            Toast.makeText(getApplicationContext(), "Correo o contraseña incorrecta"
                                    , Toast.LENGTH_LONG).show();
                        }

                        edtPassLogin.setText("");
                        edtUserLogin.findFocus();

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        });
    }

}
