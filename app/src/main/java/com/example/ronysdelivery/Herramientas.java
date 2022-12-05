package com.example.ronysdelivery;

import android.view.View;
import android.widget.TextView;

public class Herramientas {
    private TextView lbl_cantidad;
    public int cantidad;
    public static String correo;

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
        Total = "L."+Total ;
        return Total;
    }
    public void recibirCorreo(String mail){
        correo = mail;
    }
    public String Correo(){
        return correo;
    }
}
