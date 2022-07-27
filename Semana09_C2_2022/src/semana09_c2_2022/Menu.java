/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semana09_c2_2022;

import javax.swing.JOptionPane;

/**
 *
 * @author RCastroMendez
 */
public class Menu {
    
    
    
    public void Menu_Principal()
    
    {
        boolean seguir = true;
        
        while(seguir)
        {
            int opc = Integer.parseInt(JOptionPane.showInputDialog(null,"Seleccione la opcion: \n"+
                                                                        "1. Mostrar Usuario \n"+
                                                                        "2. Salir del Sistema","Bienvenido",JOptionPane.INFORMATION_MESSAGE));
            switch(opc)
            {
                case 1:
                Mostrar_Usuario();
                break;
                
                case 2:
                seguir = false;
                break;
                
                
                    
            }
        }
    }
    
    public void Mostrar_Usuario()
    {
        Usuario miusuario = new Usuario();
        JOptionPane.showMessageDialog(null, "La información del usuario es: \n"+
                                            "Nombre: " + miusuario.Nombre + "\n"+
                                            "Apellidos: " + miusuario.Apellidos + "\n"+
                                            "Usuario: " + miusuario.User + "\n"+
                                            "Contraseña: " + miusuario.getPass()+"\n"+
                                            "Rol: " + miusuario.getRol());
        
    }
    
}
