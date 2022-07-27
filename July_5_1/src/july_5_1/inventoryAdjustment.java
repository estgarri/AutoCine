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
public class inventoryAdjustment 
{
    public static int opcion, cantidad;
    public static boolean segv = true;
    inventario invent = new inventario();
    
    public void ingresarInventario (){
        
        segv = true;        
        JOptionPane.showMessageDialog(null,"Entró a la sección de inventario. ");     
        while (segv == true) 
        {
            opcion = 0;
            cantidad = 0;
            
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog("El inventario disponible es el siguiente: \n" +
                "1. Celulares 'Apple 1' : " + invent.apple1 + "\n" + 
                "2. Celulares 'Apple 2': " + invent.apple2 + "\n" +
                "3. Celulares 'Apple 3': " + invent.apple3 + "\n" +
                "4. Celulares 'Samsung': " + invent.samsung + "\n" +
                "5. Celulares 'Huawei': " + invent.huawei + "\n" +
                "6. Celulares 'Xiaomi: " + invent.xiaomi  + "\n" + 
                "*********************************************************************************** \n" +
                "Ajuste de inventario, escoja una opción: \n" +
                "1. Digite '1' para ajustar el inventario disponible para los celulares 'Apple 1'.\n" + 
                "2. Digite '2' para ajustar el inventario disponible para los celulares 'Apple 2'.\n" +
                "3. Digite '3' para ajustar el inventario disponible para los celulares 'Apple 3'.\n" +
                "4. Digite '4 para ajustar el inventario disponible para los celulares 'Samsung'.\n" +
                "5. Digite '5' para ajustar el inventario disponible para los celulares 'Huawei'.\n" +
                "6. Digite '6' para ajustar el inventario disponible para los celulares 'Xiaomi'.\n" +
                "7. Digite '7' para salir."));
            }
            catch (HeadlessException | NumberFormatException e)
            {
               JOptionPane.showMessageDialog(null,"Por favor digite el número de la opción a escoger."); 
            }
            switch (opcion)           
            {
                case 1:
                    cantidad = Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad de celulares a agregar al inventario de 'Apple 1'."));
                    invent.aumentar(opcion, cantidad);
                    JOptionPane.showMessageDialog(null,"Nuevo inventario de celulares 'Apple 1' : " + invent.apple1);
                    break;
                    
                case 2:
                    cantidad = Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad de celulares a agregar al inventario de 'Apple 2'."));
                    invent.aumentar(opcion, cantidad);
                    JOptionPane.showMessageDialog(null,"Nuevo inventario de celulares 'Apple 2' : " + invent.apple2);
                    break;
                    
                case 3:
                    cantidad = Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad de celulares a agregar al inventario de 'Apple 3'."));
                    invent.aumentar(opcion, cantidad);
                    JOptionPane.showMessageDialog(null,"Nuevo inventario de celulares 'Apple 3' : " + invent.apple3);
                    break;
                
                case 4:
                    cantidad = Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad de celulares a agregar al inventario de 'Samsung'."));
                    invent.aumentar(opcion, cantidad);
                    JOptionPane.showMessageDialog(null,"Nuevo inventario de celulares 'Samsung' : " + invent.samsung);
                    break;
                
                case 5:
                    cantidad = Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad de celulares a agregar al inventario de 'Huawei'."));
                    invent.aumentar(opcion, cantidad);
                    JOptionPane.showMessageDialog(null,"Nuevo inventario de celulares 'Huawei' : " + invent.huawei);
                    break;
                    
                case 6:
                    cantidad = Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad de celulares a agregar al inventario de 'Xiaomi'."));
                    invent.aumentar(opcion, cantidad);
                    JOptionPane.showMessageDialog(null,"Nuevo inventario de celulares 'Xiaomi' : " + invent.xiaomi);
                    break;
                    
                case 7:
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
