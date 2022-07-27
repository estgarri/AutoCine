/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arreglos;

import javax.swing.JOptionPane;

 

public class Notas 
{
    public int cNotas;
    public int notas[];
   
    public void ingresarNotas()
    {
        String cadena = "";
        cNotas =  Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de notas que desea ingresar: "));
        int[] nota = new int[cNotas];
        
        for (int i = 0; i < nota.length; i++ )
        {
            nota[i] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nota del estudiante # " + (i+1) + " :"));
        }
        notas = nota;
        //for (int i = 0; i < notas.length; i++)
        //{
           // cadena += ("La nota del estudiante # " + (i+1) + " es " + notas[i] + "\n");
        //}
        //JOptionPane.showMessageDialog(null, cadena);
    }
    
    public void consultarNotas()
    {
        String cadena = "";
        for (int i = 0; i < notas.length; i++)
        {
            cadena += ("La nota del estudiante # " + (i+1) + " es " + notas[i] + "\n");
        }
           JOptionPane.showMessageDialog(null, cadena); 
        }
}
