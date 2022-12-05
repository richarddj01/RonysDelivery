package com.example.ronysdelivery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Intro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
    }

    public void registrarse(View view) {
        Intent pagina = new Intent(this, Registrarse.class);
        startActivity(pagina);
    }

    public void iniciarSesion(View view) {
        Intent pagina = new Intent(this, KFC.class);
        startActivity(pagina);
    }
    public void llevarKFC(View view) {
        Intent pagina = new Intent(this, IniciarSesion.class);
        startActivity(pagina);
    }
}