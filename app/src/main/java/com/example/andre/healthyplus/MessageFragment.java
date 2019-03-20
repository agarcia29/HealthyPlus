package com.example.andre.healthyplus;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

public class MessageFragment extends AppCompatDialogFragment {

    public Dialog OnCreateDialog(Bundle savedInstanceState){
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.message_alert, null);

        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.i("TAG","Alerta");
            }
        };

        return new AlertDialog.Builder(getActivity())
                .setTitle("Estado Corporal")
                .setView(view)
                .setPositiveButton(android.R.string.ok, listener)
                .create();
    }
}
