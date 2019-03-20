package com.example.andre.healthyplus;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.andre.healthyplus.session.Preferences;

import OpenHelper.SQLite_OpenHelper;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {
    private TextView textView;

    public PerfilFragment() {
        // Required empty public constructor
    }
    TextView nombre, peso, altura, edad, correo;
    Button btnEditPeso;
    Preferences prf;

    SQLite_OpenHelper helper = new SQLite_OpenHelper(getContext(),"Bdatos", null , 1);
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_perfil, container, false);

        nombre = (TextView) vista.findViewById(R.id.name_profile);
        peso = (TextView) vista.findViewById(R.id.weight_profile);
        altura = (TextView) vista.findViewById(R.id.height_profile);
        edad = (TextView) vista.findViewById(R.id.age_profile);
        correo = (TextView) vista.findViewById(R.id.email_profile);
        btnEditPeso = (Button) vista.findViewById(R.id.changePeso);
        prf = Preferences.get(getContext());
        nombre.setText(prf.getValue(Preferences.PREF_user_NAME));
        peso.setText(prf.getValue(Preferences.PREF_user_WEIGHT));
        altura.setText(prf.getValue(Preferences.PREF_user_HEIGHT));
        edad.setText(prf.getValue(Preferences.PREF_user_AGE));
        correo.setText(prf.getValue(Preferences.PREF_user_EMAIL));
        return vista;
    }



}
