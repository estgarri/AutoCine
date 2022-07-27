/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package july_5_1;

import javax.swing.JOptionPane;

/**
 *
 * @author estga
 */
public class facturacion 
{
    public static String nombre, direccion;
    public static double descuento = 0.25, efectivo = 0.0;
    public static int identificacion, telefono, desc;
    
    public void facturas(int apple1v, int apple2v, int apple3v, int samsungv, int huaweiv, int xiaomiv, double subtotal, double total, double impuesto)
    {
        
        desc = 0;
        efectivo = 0;
        nombre = JOptionPane.showInputDialog("Digite el nombre completo: ");        
        identificacion = Integer.parseInt(JOptionPane.showInputDialog("Digite el número de identificación: "));
        direccion = JOptionPane.showInputDialog("Digite la dirección exacta: ");
        telefono = Integer.parseInt(JOptionPane.showInputDialog("Digite el número de teléfono: "));
        desc = Integer.parseInt(JOptionPane.showInputDialog("Digite '1' para pagar en efectivo o '2' para tarjeta: "));        
        
        if (desc == 1)
        {
            efectivo =  subtotal * descuento;
            total = total - efectivo;
        }
        JOptionPane.showMessageDialog(null,"Factura a nombre de: "+ nombre + "\n" +
                            "Identificación: " + identificacion + "\n" +
                            "Dirección exacta: " + direccion + "\n" + 
                            "Número de teléfono: " + telefono + "\n" +
                            "\n" + 
                            "******************************************* \n" +
                            "\n" +
                            "Description | Cantidad          \n" +
                            "Apple 1         |   " + apple1v + "\n" + 
                            "Apple 2         |   " + apple2v + "\n" +
                            "Apple 3         |   " + apple3v + "\n" +
                            "Samsung     |   " + samsungv + "\n" +
                            "Huawei         |   " + huaweiv + "\n" +
                            "Xiaomi          |   " + xiaomiv + "\n" +
                            "************************************** \n" +
                            "Subtotal: " + subtotal + "\n" + 
                            "Impuesto: " + impuesto + "\n" +
                            "Descuento por PROMO: " + efectivo + "\n" +
                            "Total: " + total );
    }

}
