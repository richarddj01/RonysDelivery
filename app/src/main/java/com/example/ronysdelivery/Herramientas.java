package com.example.ronysdelivery;

import android.view.View;
import android.widget.TextView;

public class Herramientas {
    private TextView lbl_cantidad;
    private int cantidad;

    public String productoAumentar(View view,String cant){
        cantidad = Integer.parseInt(cant);
        cantidad +=1;
        cant = String.valueOf(cantidad);
        return cant;
    }
    public String productoDisminuir(View view, String cant){
        cantidad = Integer.parseInt(cant);
        if(cantidad>1){
            cantidad -=1;
            cant = String.valueOf(cantidad);
            return cant;
        }
        else{
            return "";
        }
    }
    public String calcularTotal(View view, String price){
        price = price.substring(2);
        float prec = Float.parseFloat(price);
        float total = cantidad *prec;
        String Total = String.valueOf(total);
        Total = "Lempiras."+Total ;
        return Total;
    }
}
