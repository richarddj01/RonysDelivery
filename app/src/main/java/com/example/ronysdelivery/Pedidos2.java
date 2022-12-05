package com.example.ronysdelivery;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

public class Pedidos2 extends AppCompatActivity {

    private TextView cancelarPedido,lbl_cantidad,lbl_restaurante,lbl_total,lbl_NombreCombo, subtotal, serv_entrega, isv, total,lbl_titulo,precio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedidos2);

        cancelarPedido = (TextView) findViewById(R.id.lbl_CancelarPedido);

        cancelarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancelarPedido();
            }
        });

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
        subtotal.setText(String.valueOf(Float.parseFloat(datos.get(1).substring(2))*Float.parseFloat(datos.get(0))));
        isv.setText("L."+String.valueOf(Float.parseFloat(datos.get(1).substring(2))*0.15));
        total.setText("L."+String.valueOf(Float.parseFloat(datos.get(1).substring(2))*Float.parseFloat(datos.get(0))+Float.parseFloat(serv_entrega.getText().toString().substring(2))+Float.parseFloat(isv.getText().toString().substring(2))));
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

    }
    public void InsertarPedido(View view)
    {
        Herramientas herramientas = new Herramientas();
        lbl_cantidad = (TextView) findViewById(R.id.lbl_Cantidad);
        lbl_restaurante = (TextView) findViewById(R.id.lbl_Restaurante);
        lbl_NombreCombo = (TextView) findViewById(R.id.lbl_NombreCombo);
        lbl_total = (TextView) findViewById(R.id.lbl_TotalPedido);
        String correo;
        AdminSQLiteOpen Bd = new AdminSQLiteOpen(this, "RonysDelivery", null,1);//objeto clase
        SQLiteDatabase BasedeDatos = Bd.getWritableDatabase();//escritura BD

        // Restaurante = ob_codigo.getText().toString();//obtenemos el codigo ingresado en el teclado
        String NombreCombo = lbl_NombreCombo.getText().toString();
        String Total = lbl_total.getText().toString();
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
        java.util.Date fecha = new Date();
        registro.put("Fecha",String.valueOf(fecha));
        registro.put("Restaurante",lbl_restaurante.getText().toString());

        //NombreCombo

        //Toast.makeText(this,"DATOS GUARDADOS", Toast.LENGTH_SHORT).show();
        BasedeDatos.insert("Pedidos", null, registro);
        confirmarPedido();
    }
    private void confirmarPedido (){

        lbl_cantidad = (TextView) findViewById(R.id.lbl_Cantidad);
        lbl_restaurante = (TextView) findViewById(R.id.lbl_Restaurante);
        lbl_NombreCombo = (TextView) findViewById(R.id.lbl_NombreCombo);
        lbl_total = (TextView) findViewById(R.id.lbl_TotalPedido);
        subtotal = (TextView) findViewById(R.id.lbl_subtotal2);
        serv_entrega = (TextView) findViewById(R.id.lbl_servicioEntrega2);
        isv = (TextView) findViewById(R.id.lbl_isv2);
        total = (TextView) findViewById(R.id.lbl_total2);

        double cargo=12,totalfinal,numero;

        Button comfirmarPedido;

        new AlertDialog.Builder(this)
                .setTitle("Mensaje de Confirmación")
                .setMessage("¡Su pedido se ha completado con Exito!, ")
                .setMessage("¿Desea realizar otro Pedido?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialogInterface, int i) {

                        lbl_total.setText("L.0");
                        isv.setText("L.0");
                        serv_entrega.setText("L.0");
                        subtotal.setText("L.0");
                        total.setText("L.00.00");
                        lbl_NombreCombo.setText("Nombre Combo");
                        lbl_cantidad.setText("1");
                        lbl_restaurante.setText("RESTAURANT");

                        startActivity(new Intent(Pedidos2.this, MainActivity.class));
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialogInterface, int i) {

                        lbl_total.setText("L.0");
                        isv.setText("L.0");
                        serv_entrega.setText("L.0");
                        subtotal.setText("L.0");
                        total.setText("L.00.00");
                        lbl_NombreCombo.setText("Nombre Combo");
                        lbl_cantidad.setText("1");
                        lbl_restaurante.setText("RESTAURANT");

                        Log.d("Mensaje", "Se cancelo la acción");

                        startActivity(new Intent(Pedidos2.this, IniciarSesion.class));
                    }
                })
                .show();
    }

    private void cancelarPedido()
    {
        lbl_cantidad = (TextView) findViewById(R.id.lbl_Cantidad);
        lbl_restaurante = (TextView) findViewById(R.id.lbl_Restaurante);
        lbl_NombreCombo = (TextView) findViewById(R.id.lbl_NombreCombo);
        lbl_total = (TextView) findViewById(R.id.lbl_TotalPedido);
        subtotal = (TextView) findViewById(R.id.lbl_subtotal2);
        serv_entrega = (TextView) findViewById(R.id.lbl_servicioEntrega2);
        isv = (TextView) findViewById(R.id.lbl_isv2);
        total = (TextView) findViewById(R.id.lbl_total2);

        new AlertDialog.Builder(this)
                .setTitle("Mensaje de Advertencia")
                .setMessage("¿Esta seguro que desea Cancelar el Pedido?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialogInterface, int i) {

                        total.setText("L.0");
                        isv.setText("L.0");
                        serv_entrega.setText("L.0");
                        subtotal.setText("L.0");
                        total.setText("L.00.00");
                        lbl_NombreCombo.setText("Nombre Combo");
                        lbl_cantidad.setText("1");
                        lbl_restaurante.setText("RESTAURANT");

                        startActivity(new Intent(Pedidos2.this, MainActivity.class));
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.d("Mensaje", "Se cancelo la acción");
                    }
                })
              .show();
    }
}