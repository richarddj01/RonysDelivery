package com.example.ronysdelivery;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Pedidos extends AppCompatActivity {

    private TextView lbl_cantidad,lbl_restaurante,lbl_total,lbl_NombreCombo, subtotal, serv_entrega, isv, total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedidos);
        Herramientas herramientas = new Herramientas();
        ArrayList<String> datos = herramientas.datosPedido();
        lbl_cantidad = (TextView) findViewById(R.id.lbl_Cantidad);
        lbl_restaurante = (TextView) findViewById(R.id.lbl_Restaurante);
        lbl_NombreCombo = (TextView) findViewById(R.id.lbl_NombreCombo);
        lbl_total = (TextView) findViewById(R.id.lbl_TotalPedido);

        lbl_cantidad.setText(datos.get(0));
        lbl_total.setText(datos.get(1));
        lbl_NombreCombo.setText(datos.get(2));
        lbl_restaurante.setText(datos.get(3));

        subtotal = (TextView) findViewById(R.id.lbl_subtotal2);
        serv_entrega = (TextView) findViewById(R.id.lbl_servicioEntrega2);
        isv = (TextView) findViewById(R.id.lbl_isv2);
        total = (TextView) findViewById(R.id.lbl_total2);

        serv_entrega.setText("L.12.00");
        subtotal.setText(datos.get(1));
        isv.setText("L."+String.valueOf(Float.parseFloat(datos.get(1).substring(2))*0.15));
        total.setText("L."+String.valueOf(Float.parseFloat(datos.get(1).substring(2))+Float.parseFloat(serv_entrega.getText().toString().substring(2))+Float.parseFloat(isv.getText().toString().substring(2))));
        //Toast.makeText(this, datos.get(0), Toast.LENGTH_SHORT).show();
    }

    public void inicio(View view) {
        Intent pagina = new Intent(this, MainActivity.class);
        startActivity(pagina);
    }

    public void perfil(View view) {
        Intent pagina = new Intent(this, Perfil.class);
        startActivity(pagina);
    }

    public void historial(View view) {
        Intent pagina = new Intent(this, HistorialPedidos.class);
        startActivity(pagina);
    }

    public void soporte(View view) {
        Intent pagina = new Intent(this, Soporte.class);
        startActivity(pagina);
    }
    public void ponerNombres(View view){
        lbl_cantidad.setText("a");
        lbl_total.setText("datos.get(1)");
        lbl_NombreCombo.setText("datos.get(2)");
        lbl_restaurante.setText("datos.get(3)");
    }
}