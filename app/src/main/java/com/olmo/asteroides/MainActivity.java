package com.olmo.asteroides;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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

        btnJugar= (Button) findViewById(R.id.btnJugar);
        btnJugar.setOnClickListener(this);


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
            lanzarPreferencias();
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

    public void lanzarPreferencias(){
        Intent intent=new Intent(this,Preferencias.class);
        startActivity(intent);
    }

    public void mostrarPreferencias(){
        SharedPreferences pref =

                PreferenceManager.getDefaultSharedPreferences(this);
        String s = "música: "+ pref.getBoolean("musica",true)
                +", gráficos: " +
                pref.getString("graficos","?");
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAcercaDe:
                intent = new Intent(MainActivity.this, AcercaDe.class);
                startActivity(intent);
                break;

            case R.id.btnConfigurar:
                intent = new Intent(MainActivity.this, Preferencias.class);
                startActivity(intent);
                break;

            case R.id.btnSalir:
                finish();
                break;
            case R.id.btnJugar:
                mostrarPreferencias();
                break;
        }
    }
}