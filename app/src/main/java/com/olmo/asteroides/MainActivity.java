package com.olmo.asteroides;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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

    /*Para configurar la barra de tareas*/
    @Override public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true; /** true -> el menú ya está visible */
    }
    @Override public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.acercaDe) {
            lanzarAcercaDe();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void lanzarAcercaDe(){
        Intent intent=new Intent(this,AcercaDe.class);
        startActivity(intent);
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