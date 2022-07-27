/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package july_5_1;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;

/**
 *
 * @author estga
 */
public class ventas {
    
    public static double iva = 0.13, desc = 0.25, subtotal = 0.0, total = 0.0, impuesto = 0.0;
    public static boolean segv = true;
    public static int opcion = 0, cantidad = 0, apple1v = 0, apple2v = 0, apple3v = 0, samsungv = 0, huaweiv = 0, xiaomiv = 0;
    
    inventario invent = new inventario();
    facturacion fact = new facturacion();
    
    public void ingresarVenta ()
    {
        //Inicializar todo en "zero" para evitar residuos de ingresos anteriores.
        segv = true;
        opcion = 0; cantidad = 0; apple1v = 0; apple2v = 0; apple3v = 0; samsungv = 0; huaweiv = 0; xiaomiv = 0; subtotal = 0.0; total = 0.0;
        
        JOptionPane.showMessageDialog(null,"Entró a la sección de ventas. ");     
        while (segv == true) 
        {
            opcion = 0;
            
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog("Inventario disponible para la venta: \n" +
                "1. Digite '1' para 'Apple 1', inventario actual: " + invent.apple1 + "\n" + 
                "2. Digite '2' para 'Apple 2', inventario actual: " + invent.apple2 + "\n" +
                "3. Digite '3' para 'Apple 3', inventario actual: " + invent.apple3 + "\n" +
                "4. Digite '4 para 'Samsung', inventario actual: " + invent.samsung + "\n" +
                "5. Digite '5' para 'Huawei', inventario actual: " + invent.huawei + "\n" +
                "6. Digite '6' para 'Xiaomi', inventario actual: " + invent.xiaomi + "\n" +
                "7. Digite '7' para imprimir factura y salir del sistema de ventas."));
            }
            catch (HeadlessException | NumberFormatException e)
            {
               JOptionPane.showMessageDialog(null,"Por favor digite el número de la opción a escoger."); 
            }
            switch (opcion)           
            {
                case 1:
                    cantidad = Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad de celulares 'Apple 1' para esta venta."));
                    apple1v += cantidad;
                    subtotal += 1000 * apple1v;
                    invent.reducir(opcion, cantidad);
                    break;
                    
                case 2:
                    cantidad = Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad de celulares 'Apple 2' para esta venta."));
                    apple2v += cantidad;
                    subtotal += 2000 * apple2v;
                    invent.reducir(opcion, cantidad);
                    break;
                    
                case 3:
                    cantidad = Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad de celulares 'Apple 3' para esta venta."));
                    apple3v += cantidad;
                    subtotal += 3000 * apple3v;
                    invent.reducir(opcion, cantidad);
                    break;
                
                case 4:
                    cantidad = Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad de celulares 'Samsung' para esta venta."));
                    samsungv += cantidad;
                    subtotal += 4000 * samsungv;
                    invent.reducir(opcion, cantidad);
                    break;
                
                case 5:
                    cantidad = Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad de celulares 'Huawei' para esta venta."));
                    huaweiv += cantidad;
                    subtotal += 5000 * huaweiv;
                    invent.reducir(opcion, cantidad);
                    break;
                    
                case 6:
                    cantidad = Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad de celulares 'Xiaomi' para esta venta."));
                    xiaomiv += cantidad;
                    subtotal += 6000 * xiaomiv;
                    invent.reducir(opcion, cantidad);
                    break;
                    
                case 7:
                    
                    impuesto = subtotal * iva;
                    total = subtotal + impuesto;                    
                    fact.facturas(apple1v, apple2v, apple3v, samsungv, huaweiv, xiaomiv, subtotal, total, impuesto);
                    segv = false;
                    break;                   
                    
                default:
                    if (opcion != 0)
                    {
                        JOptionPane.showMessageDialog(null,"Opción inválida!");
                    }
            }    

                
        }
            
    }
}
    

