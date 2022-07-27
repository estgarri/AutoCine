/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea_2;

import javax.swing.JOptionPane;

/**
 *
 * @author garciaes
 */
public class menu {
    
    public static int opcion, existe;
    public static boolean seguir = true;
    
    public static void menuOpcion()
    {
        //libroClub lc = new libroClub();
        //ventas sale = new ventas();
        
        while (seguir == true)
        {
            opcion = 0;
            opcion = Integer.parseInt(JOptionPane.showInputDialog("Escoja su opción:  \n" +
            "1. Digite '1' para verificar membresía. \n" + 
            "2. Digite '2' para ventas. \n" +
            "3. Digite '3' para imprimir reportes. \n" +
            "4. Digite '4 para salir del sistema."));
                
               switch (opcion)
               {
                   case 1:
                       existe = libroClub.miembros();
                       System.out.println(existe);
                       break;
                      
                   case 2:
                       ventas.categorias();
                       existe = 0;
                       break;
                       
                   case 3:
                       break;
                       
                   case 4:
                       JOptionPane.showMessageDialog(null, "Saliendo del sistema....");
                       seguir = false;
                       break;
                       
                   default:
                       JOptionPane.showMessageDialog(null, "Opción inválida.");
                       break;
               }
        }
    }
}
