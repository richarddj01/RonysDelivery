package com.example.ronysdelivery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PH_Pizza_Personal_Doble extends AppCompatActivity {
    private String precioConComplemento;
    private boolean seleccionado;
    private TextView precio;
    private TextView total;
    private TextView lbl_cantidad;
    private int cantidad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ph_pizza_personal_doble);
    }

    public void inicio(View view) {
        Intent pagina = new Intent(this, MainActivity.class);
        startActivity(pagina);
    }

    public void historial(View view) {
        Intent pagina = new Intent(this, HistorialPedidos.class);
        startActivity(pagina);
    }

    public void pedidos(View view) {
        Intent pagina = new Intent(this, Pedidos.class);
        startActivity(pagina);
    }

    public void soporte(View view) {
        Intent pagina = new Intent(this, Soporte.class);
        startActivity(pagina);
    }

    public void perfil(View view) {
        Intent pagina = new Intent(this, Perfil.class);
        startActivity(pagina);
    }
    Herramientas herramientas = new Herramientas();
    public void radioSeleccionado199(View view){
        precio = (TextView)  findViewById(R.id.lbl_comboPrecio);
        String price = precio.getText().toString();
        sumarAlTotal(199,price.substring(2));
        seleccionado = true;
        lbl_cantidad = (TextView) findViewById(R.id.lbl_cantidad);
        herramientas.cantidad = Integer.parseInt(lbl_cantidad.getText().toString());
        calcularTotal(view);
    }
    public void radioSeleccionado0(View view){
        precio = (TextView)  findViewById(R.id.lbl_comboPrecio);
        String price = precio.getText().toString();
        sumarAlTotal(0,price.substring(2));
        seleccionado = true;
        lbl_cantidad = (TextView) findViewById(R.id.lbl_cantidad);
        herramientas.cantidad = Integer.parseInt(lbl_cantidad.getText().toString());
        calcularTotal(view);
    }
    public void radioSeleccionado169(View view){
        precio = (TextView)  findViewById(R.id.lbl_comboPrecio);
        String price = precio.getText().toString();
        sumarAlTotal(169,price.substring(2));
        seleccionado = true;
        lbl_cantidad = (TextView) findViewById(R.id.lbl_cantidad);
        herramientas.cantidad = Integer.parseInt(lbl_cantidad.getText().toString());
        calcularTotal(view);
    }
    public void radioSeleccionado99(View view){
        precio = (TextView)  findViewById(R.id.lbl_comboPrecio);
        String price = precio.getText().toString();
        sumarAlTotal(99,price.substring(2));
        seleccionado = true;
        lbl_cantidad = (TextView) findViewById(R.id.lbl_cantidad);
        herramientas.cantidad = Integer.parseInt(lbl_cantidad.getText().toString());
        calcularTotal(view);
    }
    public void radioSeleccionado22(View view){
        precio = (TextView)  findViewById(R.id.lbl_comboPrecio);
        String price = precio.getText().toString();
        sumarAlTotal(22,price.substring(2));
        seleccionado = true;
        lbl_cantidad = (TextView) findViewById(R.id.lbl_cantidad);
        herramientas.cantidad = Integer.parseInt(lbl_cantidad.getText().toString());
        calcularTotal(view);
    }
    public void radioSeleccionado12(View view){
        precio = (TextView)  findViewById(R.id.lbl_comboPrecio);
        String price = precio.getText().toString();
        sumarAlTotal(12,price.substring(2));
        seleccionado = true;
        lbl_cantidad = (TextView) findViewById(R.id.lbl_cantidad);
        herramientas.cantidad = Integer.parseInt(lbl_cantidad.getText().toString());
        calcularTotal(view);
    }
    public void radioSeleccionado20(View view){
        precio = (TextView)  findViewById(R.id.lbl_comboPrecio);
        String price = precio.getText().toString();
        sumarAlTotal(20,price.substring(2));
        seleccionado = true;
        lbl_cantidad = (TextView) findViewById(R.id.lbl_cantidad);
        herramientas.cantidad = Integer.parseInt(lbl_cantidad.getText().toString());
        calcularTotal(view);
    }
    public void radioSeleccionado67(View view){
        precio = (TextView)  findViewById(R.id.lbl_comboPrecio);
        String price = precio.getText().toString();
        sumarAlTotal(67,price.substring(2));
        seleccionado = true;
        lbl_cantidad = (TextView) findViewById(R.id.lbl_cantidad);
        herramientas.cantidad = Integer.parseInt(lbl_cantidad.getText().toString());
        calcularTotal(view);
    }
    public void radioSeleccionado36(View view){
        precio = (TextView)  findViewById(R.id.lbl_comboPrecio);
        String price = precio.getText().toString();
        sumarAlTotal(36,price.substring(2));
        seleccionado = true;
        lbl_cantidad = (TextView) findViewById(R.id.lbl_cantidad);
        herramientas.cantidad = Integer.parseInt(lbl_cantidad.getText().toString());
        calcularTotal(view);
    }

    public void sumarAlTotal(float precioExtra,String x){
        precioConComplemento = "L."+(precioExtra + Float.valueOf(x));
    }
    public void calcularTotal(View view){


        precio = (TextView)  findViewById(R.id.lbl_comboPrecio);
        String price = precio.getText().toString();
        total = (TextView) findViewById(R.id.lbl_total);

        if (seleccionado)
        {
            total.setText(herramientas.calcularTotal(view, String.valueOf(precioConComplemento)));
        }else{

            total.setText(herramientas.calcularTotal(view, price));
        }
    }
}