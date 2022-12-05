package com.example.ronysdelivery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PizzaHut extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_hut);
    }

    public void ph_HutBonelessFamiliar(View view) {
        Intent pagina = new Intent(this, PH_Hut_Boneless_Familiar.class);
        startActivity(pagina);
    }

    public void ph_MyBox(View view) {
        Intent pagina = new Intent(this, PH_My_Box.class);
        startActivity(pagina);
    }

    public void ph_PanPizzaPack(View view) {
        Intent pagina = new Intent(this, PH_Pan_Pizza_Pack.class);
        startActivity(pagina);
    }

    public void ph_Pizza4Estaciones(View view) {
        Intent pagina = new Intent(this, PH_Pizza_4_Estaciones.class);
        startActivity(pagina);
    }

    public void ph_PizzaPersonalDoble(View view) {
        Intent pagina = new Intent(this, PH_Pizza_Personal_Doble.class);
        startActivity(pagina);
    }

    public void ph_PizzaSuprema(View view) {
        Intent pagina = new Intent(this, PH_Pizza_Suprema.class);
        startActivity(pagina);
    }

    public void ph_TripleWowBox(View view) {
        Intent pagina = new Intent(this, PH_Triple_Wow_Box.class);
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