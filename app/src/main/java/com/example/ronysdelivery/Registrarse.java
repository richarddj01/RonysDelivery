package com.example.ronysdelivery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Registrarse extends AppCompatActivity {

    private EditText ob_nombre, ob_telefono, ob_direccion, ob_correo, ob_contrasena, ob_confirmar_contrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        ob_nombre = (EditText) findViewById(R.id.txtNombreApellido);
        ob_telefono = (EditText) findViewById(R.id.txtTelefono);
        ob_direccion = (EditText) findViewById(R.id.txtDireccion);
        ob_correo = (EditText) findViewById(R.id.txtCorreo2);
        ob_contrasena = (EditText) findViewById(R.id.txtContrasena2);
        ob_confirmar_contrasena = (EditText) findViewById(R.id.txtConfirmarContrasena);
    }

    public void iniciarSesion(View view) {
        Intent pagina = new Intent(this, IniciarSesion.class);
        startActivity(pagina);
    }

    public void registrar(View view) {
        AdminSQLiteOpen admin = new AdminSQLiteOpen(this, "RonysDelivery", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String nombre = ob_nombre.getText().toString();
        String telefono = ob_telefono.getText().toString();
        String direccion = ob_direccion.getText().toString();
        String correo = ob_correo.getText().toString();
        String contrasena = ob_contrasena.getText().toString();
        String confirmarContrasena = ob_confirmar_contrasena.getText().toString();

        if (!nombre.isEmpty() && !telefono.isEmpty() && !direccion.isEmpty() && !correo.isEmpty() && !contrasena.isEmpty() && !confirmarContrasena.isEmpty()) {
            if (confirmarContrasena.contentEquals(contrasena)) {
                ContentValues cliente = new ContentValues();
                ContentValues usuario = new ContentValues();

                usuario.put("UsuCorreo", correo);
                usuario.put("UsuContrasena", contrasena);

                cliente.put("CliNombreApellido", nombre);
                cliente.put("CliTelefono", Integer.parseInt(telefono));
                cliente.put("CliDireccion", direccion);
                cliente.put("UsuCorreo", correo);

                BaseDeDatos.insert("Usuarios", null, usuario);
                long id = BaseDeDatos.insert("Clientes", null, cliente);
                BaseDeDatos.close();

                if (id > 0)
                    Toast.makeText(this, "REGISTRO CONFIRMADO", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(this, "ERROR AL REGISTRARSE", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "DEBE ESCRIBIR LA MISMA CONTRASEÑA EN AMBOS CAMPOS", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(this, "TODOS LOS CAMPOS DEBEN LLENARSE", Toast.LENGTH_SHORT).show();
        }
    }
}