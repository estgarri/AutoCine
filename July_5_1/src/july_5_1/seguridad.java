/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package july_5_1;

import java.awt.HeadlessException;
//import javax.swing.Icon;
//import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author estga
 */
public class seguridad {    public static String user = "Cenfo", pwd = "TEC", usuario = "", contra = "";
    
    public static int opcion, sal = 3, seguir = 0;
    public static boolean seg = true;
    
    //Icon icono1 = new ImageIcon(getClass().getResource("/proyecto/imagen.png);
    
    //JOptionPane.showMessageDialog(null,"Por favor digite el número de la opción a escoger.",JOptionPane.INFORMATION_MESSAGE,icono1);
    
    

    public static void security() 
    {
        ventas ventas = new ventas();
        inventoryAdjustment ajuste = new inventoryAdjustment();
        
        usuario = JOptionPane.showInputDialog("Ingrese el usuario: ");
        contra = JOptionPane.showInputDialog("Ingrese la contraseña: ");  
        
        if (!usuario.equals(user) || !contra.equals(pwd))
        {
            seguir = 1;
            JOptionPane.showMessageDialog(null,"Login incorrecto!");
             
            
        }
        while (seg == true && seguir !=1) 
        {
            opcion = 0;
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tipo de usuario: \n" +
                "1. Digite '1' para ingresar al sistema de 'inventario'. \n" +
                "2. Digite '2' para ingrease al sistema de 'ventas'. \n" +
                "3. Digite '3' para 'salir' del sistema."));
            }
            catch (HeadlessException | NumberFormatException e)
            {
               JOptionPane.showMessageDialog(null,"Por favor digite el número de la opción a escoger."); 
            }
            
            switch (opcion)           
            {
                case 1:
                    ajuste.ingresarInventario();
                    break;
                    
                case 2:
                    ventas.ingresarVenta();
                    break;
                    
                case 3:
                    JOptionPane.showMessageDialog(null,"Saliendo del sistema.");
                    seg = false;
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
    
