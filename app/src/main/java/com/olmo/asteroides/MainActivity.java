package com.olmo.asteroides;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnJugar,btnConfigurar,btnPuntuaciones,btnAcercaDe,btnSalir;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAcercaDe= (Button) findViewById(R.id.btnAcercaDe);
        btnAcercaDe.setOnClickListener(this);
        btnSalir= (Button) findViewById(R.id.btnSalir);
        btnSalir.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAcercaDe:
                intent = new Intent(MainActivity.this, AcercaDe.class);
                startActivity(intent);
                break;

            case R.id.btnSalir:
                finish();
                break;
        }
    }
}