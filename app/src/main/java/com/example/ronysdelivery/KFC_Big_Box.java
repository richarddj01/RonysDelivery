package com.example.ronysdelivery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class KFC_Big_Box extends AppCompatActivity {
    private RadioButton Crb1,Crb2,Crb3,Rprb1,Rprb2,Rprb3,Csrb1,Csrb2,Csrb3,Brb1,Brb2,Brb3,Brb4;
    private TextView lbl_cantidad;
    private int cantidad;
    private TextView precio;
    private TextView total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kfc_big_box);

        Crb1 = findViewById(R.id.rb_pureDePapa);
        Crb2 =findViewById(R.id.rb_ensalada);
        Crb3 = findViewById(R.id.rb_papaIndividual);
        Rprb1 = findViewById(R.id.rb_piezaCrispy);
        Rprb2 =findViewById(R.id.rb_piezaOriginal);
        Rprb3 =findViewById(R.id.rb_piezaPicante);
        Csrb1 =findViewById(R.id.rb_papaIndividual2);
        Csrb2 =findViewById(R.id.rb_pureDePapa2);
        Csrb3 =findViewById(R.id.rb_ensalada2);
        Brb1=findViewById(R.id.rb_mirinda);
        Brb2=findViewById(R.id.rb_7up);
        Brb3=findViewById(R.id.rb_pepsi);
        Brb4=findViewById(R.id.rb_Agua);
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
}