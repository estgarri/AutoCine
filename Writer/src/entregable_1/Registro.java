package entregable_1;

import javax.swing.JOptionPane;


public class Registro {
    
    public static String Nombre;
    public static String Apellidos;
    public static String sistema;
    public static int Cedula;
    public static int tipo;
    
    public void MostrarPersona()
    {
        if (tipo == 1)
        {
            sistema = "Carrier";
        }
        else
        {
            sistema = "Broker";
        }
            
        JOptionPane.showMessageDialog(null, "La información del usuario es: \n"+
                                            "Nombre Completo: " + Nombre + " " + Apellidos+"\n"+
                                            "Cédula: " + Cedula + "\n"+
                                            "Tipo de usuario: " + sistema);
    }
    
    public void SolicitarUsuario()
    {
        Nombre = JOptionPane.showInputDialog("Ingrese su Nombre: ");
        Apellidos = JOptionPane.showInputDialog("Ingrese sus Apellidos: ");
        Cedula = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su Cédula: "));
        tipo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tipo de usuario: \n" +
        "1. Digite '1' para Broker \n" +
        "2. Digite '2' para Carrier"));
    }
    
  
    
    
}
