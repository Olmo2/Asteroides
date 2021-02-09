package com.olmo.asteroides;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Preferencias extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new
                        PreferenciasFragment())
                .commit();
    }
}