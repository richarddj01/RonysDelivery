package com.example.ronysdelivery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.RadioButton;

public class PH_Pizza_Suprema extends AppCompatActivity {
    private String precioConComplemento;
    private boolean seleccionado;
    private TextView precio;
    private TextView total;
    private TextView lbl_cantidad,lbl_titulo,lbl_total,lbl_NombreCombo;
    private int cantidad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ph_pizza_suprema);
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

    public void radioSeleccionado69(View view){
        precio = (TextView)  findViewById(R.id.lbl_comboPrecio);
        String price = precio.getText().toString();
        sumarAlTotal(69,price.substring(2));
        seleccionado = true;
        lbl_cantidad = (TextView) findViewById(R.id.lbl_cantidad);
        herramientas.cantidad = Integer.parseInt(lbl_cantidad.getText().toString());
        calcularTotal(view);
    }
    public void radioSeleccionado79(View view){
        precio = (TextView)  findViewById(R.id.lbl_comboPrecio);
        String price = precio.getText().toString();
        sumarAlTotal(79,price.substring(2));
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
    public void InsertarPedido(View view)
    {
        lbl_titulo = (TextView) findViewById(R.id.lbl_titulo);
        lbl_cantidad = (TextView) findViewById(R.id.lbl_cantidad);
        precio = (TextView)  findViewById(R.id.lbl_comboPrecio);
        String correo;
        AdminSQLiteOpen Bd = new AdminSQLiteOpen(this, "RonysDelivery", null,1);//objeto clase
        SQLiteDatabase BasedeDatos = Bd.getWritableDatabase();//escritura BD

        // Restaurante = ob_codigo.getText().toString();//obtenemos el codigo ingresado en el teclado
        String NombreCombo = lbl_titulo.getText().toString();
        String Total = precio.getText().toString();
        String Cantidad = lbl_cantidad.getText().toString();
        //String NombreCom = lbl_NombreCombo.getText().toString();
        //String SubTotal = ob_campus.getText().toString();

        correo = herramientas.Correo();
        ContentValues registro = new ContentValues();
        //registro.put("PedCodigo",1);
        registro.put("Combo", NombreCombo);
        registro.put("PedCantidad", Integer.valueOf(Cantidad));
        registro.put("PedPrecio", Float.parseFloat(Total.substring(2)));
        registro.put("UsuCorreo", correo);

        //NombreCombo

        Toast.makeText(this,"DATOS GUARDADOS", Toast.LENGTH_SHORT).show();
        BasedeDatos.insert("Pedidos", null, registro);
    }
}