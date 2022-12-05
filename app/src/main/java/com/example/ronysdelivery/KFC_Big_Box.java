package com.example.ronysdelivery;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.renderscript.ScriptIntrinsicYuvToRGB;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class KFC_Big_Box extends AppCompatActivity {
    private RadioButton Crb1,Crb2,Crb3,Rprb1,Rprb2,Rprb3,Csrb1,Csrb2,Csrb3,Brb1,Brb2,Brb3,Brb4;
    private TextView lbl_cantidad,lbl_titulo,lbl_total,lbl_NombreCombo;
    private int cantidad;
    private TextView precio;
    private TextView total;
    private TextView txtPrueba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kfc_big_box);

        txtPrueba = (TextView) findViewById(R.id.txtprueba);
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
    public void radioBig_Box() {
        if (Crb1.isChecked() == true) {
            Crb2.setEnabled(false);
            Crb3.setEnabled(false);
        }
        if (Crb2.isChecked() == true) {
            Crb1.setEnabled(false);
            Crb3.setEnabled(false);
        }
        if (Crb3.isChecked() == true) {
            Crb1.setEnabled(false);
            Crb2.setEnabled(false);
        }
        if (Brb1.isChecked() == true) {
            Brb2.setEnabled(false);
            Brb3.setEnabled(false);
            Brb4.setEnabled(false);
        }
        if (Brb2.isChecked() == true) {
            Brb1.setEnabled(false);
            Brb3.setEnabled(false);
            Brb4.setEnabled(false);
        }
        if (Brb3.isChecked() == true) {
            Brb1.setEnabled(false);
            Brb2.setEnabled(false);
            Brb4.setEnabled(false);
        }
        if (Brb4.isChecked() == true) {
            Brb1.setEnabled(false);
            Brb2.setEnabled(false);
            Brb3.setEnabled(false);
        }

    }


    Herramientas herramientas = new Herramientas();

    public void productoAumentar(View view){
        lbl_cantidad = (TextView) findViewById(R.id.lbl_cantidad);
        String cant = lbl_cantidad.getText().toString();
        cant = herramientas.productoAumentar(view, cant);
        lbl_cantidad.setText(cant);
        //Calcular el total
        calcularTotal(view);
    }
    public void productoDisminuir(View view){
        lbl_cantidad = (TextView) findViewById(R.id.lbl_cantidad);
        String cant = lbl_cantidad.getText().toString();
        cant = herramientas.productoDisminuir(view, cant);
        if(cant!=""){
            lbl_cantidad.setText(cant);
        }

        //Calcular el total
        calcularTotal(view);
    }
    public void calcularTotal(View view){
        precio = (TextView)  findViewById(R.id.lbl_comboPrecio);
        String price = precio.getText().toString();
        total = (TextView) findViewById(R.id.lbl_total);
        total.setText(herramientas.calcularTotal(view, price));
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

    public void Buscar(View view)
    {
        AdminSQLiteOpen admin = new AdminSQLiteOpen(this, "RonysDelivery", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        //String correo = ob_correo.getText().toString();
        //String contrasena = ob_contrasena.getText().toString();

            Cursor fila = BaseDeDatos.rawQuery("select CliNombreApellido from Clientes where CliCodigo = 1", null);

            if (fila.moveToFirst()) {
                txtPrueba.setText(fila.getString(0));
            }
            /*
            if (fila.moveToFirst()) {
                if (.contentEquals(contrasena)) {
                    Intent pagina = new Intent(this, MainActivity.class);
                    startActivity(pagina);
                }
                else {
                    Toast.makeText(this, "CONTRASEÑA INCORRECTA", Toast.LENGTH_SHORT).show();
                }
            }
            else {
                Toast.makeText(this, "CORREO ELECTRÓNICO NO ENCONTRADO", Toast.LENGTH_SHORT).show();
            }
            */

    }
}