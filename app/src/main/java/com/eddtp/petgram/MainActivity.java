package com.eddtp.petgram;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText etxName;
    private EditText etxPhone;
    private EditText etxEmail;
    private EditText etxDescription;
    private EditText etxFecha;
    DatePickerDialog.OnDateSetListener setListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etxName = (EditText) findViewById(R.id.etxName);
        etxPhone = (EditText) findViewById(R.id.etxPhone);
        etxEmail = (EditText) findViewById(R.id.etxEmail);
        etxDescription = (EditText) findViewById(R.id.etxDescription);
        etxFecha = (EditText) findViewById(R.id.etxFecha);

        etxFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                final int year = calendar.get(Calendar.YEAR);
                final int month = calendar.get(Calendar.MONTH);
                final int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        MainActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        setListener, year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String date = day + "/" + month + "/" + year;
                etxFecha.setText(date);
            }
        };

        Button btnNext = (Button) findViewById(R.id.btnNext);
        btnNext.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DatosUsuario.class);
                intent.putExtra(getResources().getString(R.string.pnombre), etxName.getText().toString());
                intent.putExtra(getResources().getString(R.string.pfecha), etxFecha.getText().toString());
                intent.putExtra(getResources().getString(R.string.ptelefono), etxPhone.getText().toString());
                intent.putExtra(getResources().getString(R.string.pemail), etxEmail.getText().toString());
                intent.putExtra(getResources().getString(R.string.pdescripcion), etxDescription.getText().toString());
                startActivity(intent);
                finish();
            }
        });
    }
}