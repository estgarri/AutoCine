/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_cajas;

import javax.swing.JOptionPane;

/**
 *
 * @author RCastroMendez
 */

public class Menu {
    static Usuario user = new Usuario();
    
    public void Menu_Administrador()
    
    {
        boolean seguir = true;
        
        while(seguir)
        {
            int opc = Integer.parseInt(JOptionPane.showInputDialog(null,"Seleccione la opcion: \n"+
                                                                        "1. Registrar Usuario \n"+
                                                                        "2. Salir del Sistema","Bienvenido",JOptionPane.INFORMATION_MESSAGE));
            switch(opc)
            {
                case 1:
               
                break;
                
                case 2:
                seguir = false;
                break;
                
                
                    
            }
        }
    }
    
    public void Menu_Supervisor()
    
    {
        boolean seguir = true;
        
        while(seguir)
        {
            int opc = Integer.parseInt(JOptionPane.showInputDialog(null,"Seleccione la opcion: \n"+
                                                                        "1. Registrar Usuario \n"+
                                                                        "2. Retiros de Dinero \n"+
                                                                        "3. Deposito de Dinero \n"+
                                                                        "4. Boveda \n"+
                                                                        "5. Informe arqueo de cajas \n"+
                                                                        "6. Salir del Sistema","Bienvenido",JOptionPane.INFORMATION_MESSAGE));
            switch(opc)
            {
                case 1:
                    user.Registrar_Usuario();
               
                break;
                
                case 2:
                
                break;
                
                case 3:
               
                break;
                
                case 4:
                
                break;
                
                case 5:
               
                break;
                
                case 6:
                seguir = false;
                break;
                
                
                    
            }
        }
    }
    
    public void Menu_Cajero()
    
    {
        boolean seguir = true;
        
        while(seguir)
        {
            int opc = Integer.parseInt(JOptionPane.showInputDialog(null,"Seleccione la opcion: \n"+
                                                                        "1. Retiros de Dinero \n"+
                                                                        "2. Deposito de Dinero \n"+
                                                                        "3. Informe arqueo de cajas \n"+
                                                                        "4. Salir del Sistema","Bienvenido",JOptionPane.INFORMATION_MESSAGE));
            switch(opc)
            {
                case 1:
               
                break;
                
                case 2:
                
                break;
                
                case 3:
               
                break;
                
                case 4:
                seguir = false;
                break;
                
                               
                
                    
            }
        }
    }
    
    public void Menu_Asistente()
    {
        boolean seguir = true;
        
        while(seguir)
        {
            int opc = Integer.parseInt(JOptionPane.showInputDialog(null,"Seleccione la opcion: \n"+
                                                                        "1. Boveda \n"+
                                                                        "2. Informe arqueo de cajas \n"+
                                                                        "3. Salir del Sistema","Bienvenido",JOptionPane.INFORMATION_MESSAGE));
            switch(opc)
            {
                case 1:
               
                break;
                
                case 2:
                
                break;
                
                case 3:
                 seguir = false;
                break;
                
                
                
                               
                
                    
            }
        }
    }
    
}
