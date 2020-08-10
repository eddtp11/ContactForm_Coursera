package com.eddtp.petgram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DatosUsuario extends AppCompatActivity {

    private TextView txtInfoName;
    private TextView txtInfoDate;
    private TextView txtInfoTel;
    private TextView txtInfoEmail;
    private TextView txtInfoDesc;
    private Button btnEditInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_usuario);

        Bundle info = getIntent().getExtras();
        String name = info.getString(getResources().getString(R.string.pnombre));
        String date = info.getString(getResources().getString(R.string.pfecha));
        String phone = info.getString(getResources().getString(R.string.ptelefono));
        String email = info.getString(getResources().getString(R.string.pemail));
        String description = info.getString(getResources().getString(R.string.pdescripcion));

        txtInfoName = (TextView) findViewById(R.id.txtInfoName);
        txtInfoDate = (TextView) findViewById(R.id.txtInfoDate);
        txtInfoTel = (TextView) findViewById(R.id.txtInfoTel);
        txtInfoEmail = (TextView) findViewById(R.id.txtInfoEmail);
        txtInfoDesc = (TextView) findViewById(R.id.txtInfoDesc);

        btnEditInfo = (Button) findViewById(R.id.btnEditInfo);

        txtInfoName.setText(name);
        txtInfoDate.setText("Fecha de nacimiento: " + date);
        txtInfoTel.setText("Tel. " + phone);
        txtInfoEmail.setText("E-mail: " + email);
        txtInfoDesc.setText("Descripcion: " + description);

        btnEditInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DatosUsuario.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public boolean onKeyDown (int keyCode, KeyEvent event){

        if (keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(DatosUsuario.this, MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }
}