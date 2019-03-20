package com.example.andre.healthyplus;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.andre.healthyplus.Object.Almuerzo;
import com.example.andre.healthyplus.Object.Cena;
import com.example.andre.healthyplus.Object.Desayuno;
import com.example.andre.healthyplus.Object.Merienda;

import OpenHelper.SQLite_OpenHelper;


/**
 * A simple {@link Fragment} subclass.
 */
public class InicioFragment extends Fragment {
    TextView desa, almu, meri, cena;
    String popUp = "";
    boolean alert = true;
    SQLite_OpenHelper helper = new SQLite_OpenHelper(getContext(),"Bdatos", null , 1);
    public InicioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_inicio, container, false);
      /*  if (alert) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            //popUp = helper.leer();
            builder.setTitle("Importante");
            builder.setMessage(popUp);
            builder.setPositiveButton("OK", null);
            builder.create();
            builder.show();
            alert = false;
        }*/

        desa= (TextView) vista.findViewById(R.id.dieta_desa);
        almu= (TextView) vista.findViewById(R.id.dieta_almu);
        meri= (TextView) vista.findViewById(R.id.dieta_mer);
        cena= (TextView) vista.findViewById(R.id.dieta_cena);

        Dietario dietario = new Dietario();
        String des = dietario.generarDesa().getIngre1();
        String almuer = dietario.generarAlmu().getIngre1();
        String cen = dietario.generarCena().getIngre1();
        String merie = dietario.generarMeri().getIngre1();

        desa.setText(des);
        almu.setText(almuer);
        meri.setText(merie);
        cena.setText(cen);

        return vista;
 }


}
