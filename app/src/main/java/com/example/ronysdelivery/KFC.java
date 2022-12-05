package com.example.ronysdelivery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class KFC extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kfc);
    }

    public void kfc_BigBox(View view) {
        Intent pagina = new Intent(this, KFC_Big_Box.class);
        startActivity(pagina);
    }

    public void kfc_BigBox2(View view) {
        Intent pagina = new Intent(this, KFC_Big_Box_2.class);
        startActivity(pagina);
    }

    public void kfc_ComboKentaco(View view) {
        Intent pagina = new Intent(this, KFC_Combo_Kentaco.class);
        startActivity(pagina);
    }

    public void kfc_KPack(View view) {
        Intent pagina = new Intent(this, KFC_K_Pack.class);
        startActivity(pagina);
    }

    public void kfc_MegaKFC(View view) {
        Intent pagina = new Intent(this, KFC_Mega_KFC.class);
        startActivity(pagina);
    }

    public void kfc_PakeAhorres(View view) {
        Intent pagina = new Intent(this, KFC_Pake_Ahorres.class);
        startActivity(pagina);
    }

    public void kfc_TrioKentucky(View view) {
        Intent pagina = new Intent(this, KFC_Trio_Kentucky.class);
        startActivity(pagina);
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
        Intent pagina = new Intent(this, Pedidos2.class);
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
}