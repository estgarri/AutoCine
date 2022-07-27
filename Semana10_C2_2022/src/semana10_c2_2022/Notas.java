
package semana10_c2_2022;

import javax.swing.*;


public class Notas {
    
    
    public static int Notas [];
    
    public void Ingresar_Cantidad_Notas()
    {
        int CNotas = Integer.parseInt(JOptionPane.showInputDialog("Indique la cantidad de notas a registrar: "));
        
        Notas = new int[CNotas];
        
    }
    
    public void Ingresar_Notas()
    {
        for (int i =0; i<Notas.length; i++)
        {
            Notas[i] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la Nota del Estudiante #" + (i+1)));
        }
    }
    
    public void Consultar_Notas()
    {
        String Cadena="";
        
         for (int i =0; i<Notas.length; i++)
        {
            Cadena += "La Nota del Estudiante # " + (i+1) +" es " + Notas[i] + "\n";
        }
         
        JOptionPane.showMessageDialog(null, Cadena);
    }
    
     public void Consultar_Nota_Especifica()
    {
        String Cadena="";
        int contador = 0;
        
        int ConsultarN = Integer.parseInt(JOptionPane.showInputDialog("Indique la nota a consultar: "));
        
         for (int i =0; i<Notas.length; i++)
        {
            if(ConsultarN == Notas[i])
            {
               Cadena += "La Nota del Estudiante # " + (i+1) +" es " + Notas[i] + "\n"; 
            }
            else
            {
                ++contador;
            }
            
        }
         
         if (contador == Notas.length)
         {
             JOptionPane.showMessageDialog(null, "La nota consultada no se encuentra registrada");
         }
         else
         {
             JOptionPane.showMessageDialog(null, "La nota consultada se encuentra en los siguientes campos: \n" + Cadena);
         }
         
        
    }
    
}
