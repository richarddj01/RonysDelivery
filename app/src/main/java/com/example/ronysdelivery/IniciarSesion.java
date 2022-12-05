package com.example.ronysdelivery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class IniciarSesion extends AppCompatActivity {

    private EditText ob_correo, ob_contrasena;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);

        ob_correo = (EditText) findViewById(R.id.txtCorreo2);
        ob_contrasena = (EditText) findViewById(R.id.txtContrasena2);
    }

    public void registrarse(View view) {
        Intent pagina = new Intent(this, Registrarse.class);
        startActivity(pagina);
    }

    public void consultarCredenciales(View view) {
        AdminSQLiteOpen admin = new AdminSQLiteOpen(this, "RonysDelivery", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String correo = ob_correo.getText().toString();
        String contrasena = ob_contrasena.getText().toString();

        if (!correo.isEmpty() && !contrasena.isEmpty()) {
            Cursor fila = BaseDeDatos.rawQuery("select UsuCorreo, UsuContrasena from Usuarios where UsuCorreo = '" + correo + "'", null);

            if (fila.moveToFirst()) {
                if (fila.getString(1).contentEquals(contrasena)) {
                    Intent pagina = new Intent(this, MainActivity.class);

                    //Codigo para mandar correo a registrar pedido:
                    Herramientas herramientas = new Herramientas();
                    herramientas.recibirCorreo(correo);
                    ////////////////////////////////

                    startActivity(pagina);
                }
                else {
                    Toast.makeText(this, "CONTRASEÑA INCORRECTA", Toast.LENGTH_SHORT).show();
                }
            }
            else {
                Toast.makeText(this, "CORREO ELECTRÓNICO NO ENCONTRADO", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(this, "TODOS LOS CAMPOS DEBEN LLENARSE", Toast.LENGTH_SHORT).show();
        }
    }

    public String retorno() {
        /*AdminSQLiteOpen admin = new AdminSQLiteOpen(this, "RonysDelivery", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();*/

        String correo = ob_correo.getText().toString();
        //Cursor datos = BaseDeDatos.rawQuery("select A.CliNombreApellido, A.CliTelefono, A.UsuCorreo, A.CliDireccion, B.UsuContrasena from Clientes A inner join Usuarios B on A.UsuCorreo = B.UsuCorreo where B.UsuCorreo = '" + correo + "'", null);

        /*List<String> perfil;
        perfil = new ArrayList<>();

        perfil.add(datos.getString(0));
        perfil.add(datos.getString(1));
        perfil.add(datos.getString(2));
        perfil.add(datos.getString(3));
        perfil.add(datos.getString(4));*/

        return correo;
    }
}