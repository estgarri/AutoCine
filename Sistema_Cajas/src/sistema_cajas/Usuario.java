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
public class Usuario {
    
    Menu menu = new Menu();
    
    private static String UserAdmin = "Admin";
    private static String PassAdmin = "123";
    private static Rol rol = Rol.Supervisor;
    
    public static String Nombre = "";
    public static String Apellidos = "";
    public static String User = "";
    private static String Pass = "";
    
    
    public void Registrar_Usuario()
    {
        Nombre = JOptionPane.showInputDialog(null,"Ingrese el nombre","Sistema Cajas",JOptionPane.INFORMATION_MESSAGE);
        Apellidos = JOptionPane.showInputDialog(null,"Ingrese los apellidos","Sistema Cajas",JOptionPane.INFORMATION_MESSAGE);
        User = JOptionPane.showInputDialog(null,"Ingrese el usuario","Sistema Cajas",JOptionPane.INFORMATION_MESSAGE);
        Pass = JOptionPane.showInputDialog(null,"Ingrese la contraseña","Sistema Cajas",JOptionPane.INFORMATION_MESSAGE);
        rol = Rol.Administrador;
        
        JOptionPane.showMessageDialog(null,"Usuario Registrado","Sistema Cajas",JOptionPane.INFORMATION_MESSAGE);
        
        Validar_Usuario();
    }
    
    public void Validar_Usuario()
    {
        boolean seguir = true;
        
        while (seguir)
        {
            JOptionPane.showMessageDialog(null,"Iniciar sesión","Sistema Cajas",JOptionPane.INFORMATION_MESSAGE);
            String Dato1 = JOptionPane.showInputDialog(null,"Ingrese el usuario","Sistema Cajas",JOptionPane.INFORMATION_MESSAGE);
            String Dato2 = JOptionPane.showInputDialog(null,"Ingrese la contraseña","Sistema Cajas",JOptionPane.INFORMATION_MESSAGE);
            
            if(Dato1.equals(UserAdmin) && Dato2.equals(PassAdmin))
            {
                JOptionPane.showMessageDialog(null,"Bienvenido al Sistema","Sistema Cajas",JOptionPane.INFORMATION_MESSAGE);
                seguir = false;
                
                switch(rol)
                {
                    case Administrador:
                        menu.Menu_Administrador();
                        break;
                     
                    case Supervisor:
                        menu.Menu_Supervisor();
                        break;
                       
                    case Cajero:
                        menu.Menu_Cajero();
                        break;
                     
                    case Asistente:
                        menu.Menu_Asistente();
                        break;
                        
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Ingreso el usuario o la contraseña de manera incorrecta","Sistema Cajas",JOptionPane.ERROR_MESSAGE);
                
                int salir = JOptionPane.showConfirmDialog(null,"¿Desea intentar de nuevo?","Mensaje",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
            
                if(salir == 1)
                {
                    JOptionPane.showMessageDialog(null,"Se va cerrar el sistema","Sistema Cajas",JOptionPane.INFORMATION_MESSAGE);
                    seguir = false;
                }
            }
        }
    }

    public static String getPass() {
        return Pass;
    }

    public static Rol getRol() {
        return rol;
    }
    
    
    
}
