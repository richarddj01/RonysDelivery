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
        BaseDeDatos.execSQL("create table Productos(PrdCodigo INTEGER primary key autoincrement, PrdNombre text, PrdDescripcion text, PrdPrecio real)");
        BaseDeDatos.execSQL("create table Restaurantes(ResCodigo INTEGER primary key autoincrement, ResNombre text, ResDireccion text, ResTelefono int, ResCorreo text)");
        BaseDeDatos.execSQL("CREATE TABLE IF NOT EXISTS CombosEncabezado ( CmbCodigo	INTEGER NOT NULL, CmbNombre	TEXT, CmbDescripcion	TEXT, CmbPrecio	REAL, ResCodigo	INTEGER, FOREIGN KEY(ResCodigo) REFERENCES Restaurantes(ResCodigo), PRIMARY KEY(CmbCodigo)); ");
        BaseDeDatos.execSQL("create table CombosDetalle(CmbCodigo int primary key, PrdCodigo int, CmbCantidad int)");
        BaseDeDatos.execSQL("CREATE TABLE Pedidos (PedCodigo	INTEGER primary key autoincrement, Combo	TEXT , PedCantidad	INTEGER, PedPrecio	REAL, UsuCorreo TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase BaseDeDatos, int i, int i1) {

    }
}
