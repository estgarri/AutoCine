/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplojoptionpane;

import javax.swing.JOptionPane;

/**
 *
 * @author estga
 */
public class EjemploJoptionPane {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String Nombre;
        Nombre = JOptionPane.showInputDialog("Indique su nombre: ");
        JOptionPane.showMessageDialog(null,"El nombre es: \n" + Nombre);
        // TODO code application logic here
    }
    
}
