
package semana11_c2_2022;

import javax.swing.JOptionPane;

public class Registro_Estudiante {
    
    public Estudiante Arreglo [];
    
    public void Registrar_Cantidad_Estudiantes()
    {
        int cantidadE = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de estudiante a registrar:"));
        
        Arreglo = new Estudiante[cantidadE];
    }
    
    public void Ingresar_Estudiantes()
    {
        for(int i=0; i<Arreglo.length; i++)
        {
            JOptionPane.showMessageDialog(null, "Se solicitarán los datos del estudiante "+(i+1));
            
            int cedula = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cédula:"));
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre:");
            String apellidos = JOptionPane.showInputDialog("Ingrese los apellidos:");
            int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad:"));
            
            Arreglo[i] = new Estudiante(cedula,nombre,apellidos,edad);
            
            
        }
    }
    
   public void Consultar_Registro()
   { 
       String Cadena = "";
       
       for(int i=0; i<Arreglo.length; i++)
        {
            Cadena += "Estudiante # "+(i+1)+"\n"+
                      "Nombre Completo: "+Arreglo[i].Nombre + " " + Arreglo[i].Apellidos +"\n"+
                      "Cédula: " + Arreglo[i].Cedula + "\n"+
                      "Edad: "+ Arreglo[i].Edad + "\n"+
                      "----------------------------------------------- \n";
        }
       
       JOptionPane.showMessageDialog(null, Cadena);
   }
    
}
