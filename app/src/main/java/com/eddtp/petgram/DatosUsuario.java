package com.eddtp.petgram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DatosUsuario extends AppCompatActivity {

    private String name;
    private String date;
    private String phone;
    private String email;
    private String description;

    TextView txtInfoName;
    TextView txtInfoDate;
    TextView txtInfoTel;
    TextView txtInfoEmail;
    TextView txtInfoDesc;
    Button btnEditInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_usuario);

        txtInfoName = (TextView) findViewById(R.id.txtInfoName);
        txtInfoDate = (TextView) findViewById(R.id.txtInfoDate);
        txtInfoTel = (TextView) findViewById(R.id.txtInfoTel);
        txtInfoEmail = (TextView) findViewById(R.id.txtInfoEmail);
        txtInfoDesc = (TextView) findViewById(R.id.txtInfoDesc);

        btnEditInfo = (Button) findViewById(R.id.btnEditInfo);

        Bundle info = getIntent().getExtras();
        name = info.getString(getResources().getString(R.string.pnombre));
        date = info.getString(getResources().getString(R.string.pfecha));
        phone = info.getString(getResources().getString(R.string.ptelefono));
        email = info.getString(getResources().getString(R.string.pemail));
        description = info.getString(getResources().getString(R.string.pdescripcion));

        txtInfoName.setText(name);
        txtInfoDate.setText("Fecha de nacimiento: " + date);
        txtInfoTel.setText("Tel. " + phone);
        txtInfoEmail.setText("E-mail: " + email);
        txtInfoDesc.setText("Descripcion: " + description);

        btnEditInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                volver();
            }
        });
    }

    public void volver (){
        Intent intent = new Intent(DatosUsuario.this, MainActivity.class);
        intent.putExtra(getResources().getString(R.string.pnombre), name);
        intent.putExtra(getResources().getString(R.string.pfecha), date);
        intent.putExtra(getResources().getString(R.string.ptelefono), phone);
        intent.putExtra(getResources().getString(R.string.pemail), email);
        intent.putExtra(getResources().getString(R.string.pdescripcion), description);
        startActivity(intent);
        finish();
    }

    public boolean onKeyDown (int keyCode, KeyEvent event){

        if (keyCode == KeyEvent.KEYCODE_BACK){
            volver();
        }
        return super.onKeyDown(keyCode, event);
    }
}
