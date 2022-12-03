package com.example.ronysdelivery;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpen extends SQLiteOpenHelper {
    public AdminSQLiteOpen(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase BaseDeDatos) {
        BaseDeDatos.execSQL("CREATE TABLE Usuarios (UsuCorreo TEXT NOT NULL, UsuContrasena TEXT NOT NULL, PRIMARY KEY(UsuCorreo));");
        BaseDeDatos.execSQL("CREATE TABLE Clientes (CliCodigo INTEGER PRIMARY KEY AUTOINCREMENT, CliNombreApellido TEXT NOT NULL, CliTelefono INTEGER NOT NULL, CliDireccion TEXT NOT NULL, UsuCorreo TEXT NOT NULL, FOREIGN KEY(UsuCorreo) REFERENCES Usuarios(UsuCorreo));");
        /*BaseDeDatos.execSQL("create table Clientes(CliCodigo int primary key autoincrement, CliNombreApellido text, CliTelefono int, CliDireccion text, UsuCorreo text)");
        BaseDeDatos.execSQL("create table Usuarios(UsuCorreo text primary key, UsuContrasena text)");
        BaseDeDatos.execSQL("create table Productos(PrdCodigo int primary key autoincrement, PrdNombre text, PrdDescripcion text, PrdPrecio real)");
        BaseDeDatos.execSQL("create table Restaurantes(ResCodigo int primary key autoincrement, ResNombre text, ResDireccion text, ResTelefono int, ResCorreo text)");
        BaseDeDatos.execSQL("create table CombosEncabezado(CmbCodigo int primary key, CmbNombre text, CmbDescripcion text, CmbPrecio real, ResCodigo int)");
        BaseDeDatos.execSQL("create table PedidosEncabezado(PedCodigo int primary key, ResCodigo int, CliCodigo int, PedFechaHora text, PedDescripcion text)");
        BaseDeDatos.execSQL("create table CombosDetalle(CmbCodigo int primary key, PrdCodigo int primary key, CmbCantidad int)");
        BaseDeDatos.execSQL("create table PedidosDetalle(PedCodigo int primary key, CmbCodigo int primary key, PedCantidad int, PedPrecio real)");*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase BaseDeDatos, int i, int i1) {

    }
}
