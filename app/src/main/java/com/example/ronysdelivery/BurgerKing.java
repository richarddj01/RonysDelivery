package com.example.ronysdelivery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BurgerKing extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burger_king);
    }

    public void bk_whooperCombo(View view) {
        Intent pagina = new Intent(this, BK_WhopperCombo.class);
        startActivity(pagina);
    }

    public void bk_whooperTexanaCombo(View view) {
        Intent pagina = new Intent(this, BK_WhooperTexanaCombo.class);
        startActivity(pagina);
    }

    public void bk_rodeoBBQKing(View view) {
        Intent pagina = new Intent(this, BK_Rodeo_BBQ_King.class);
        startActivity(pagina);
    }

    public void bk_megaKing(View view) {
        Intent pagina = new Intent(this, BK_Mega_King.class);
        startActivity(pagina);
    }

    public void bk_kingPolloFrances(View view) {
        Intent pagina = new Intent(this, BK_King_de_Pollo_Frances.class);
        startActivity(pagina);
    }

    public void bk_kingPolloCombo(View view) {
        Intent pagina = new Intent(this, BK_King_de_Pollo_Combo.class);
        startActivity(pagina);
    }

    public void bk_comboParaTresJr(View view) {
        Intent pagina = new Intent(this, BK_Combo_para_Tres.class);
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