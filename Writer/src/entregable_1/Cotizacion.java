
package entregable_1;

import java.awt.HeadlessException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.io.*;

public class Cotizacion 
{
    public static String origen, destino, st;
    public static int cant;
    boolean seguir = true;
    
    
    
    public void cotizar() throws IOException
    {
        
        origen = JOptionPane.showInputDialog("Ingrese el origen de su carga: ");
        destino = JOptionPane.showInputDialog("Ingrese el destino de su carga: ");
        
       while (seguir = true){
            try {
                cant = Integer.parseInt(JOptionPane.showInputDialog("Cuántos containers requiere?: "));
                break;
            }
            catch (HeadlessException | NumberFormatException e){
                JOptionPane.showMessageDialog(null,"Error!");
            }           
       
       } 
       
        try (BufferedWriter cargas = new BufferedWriter(new FileWriter("orders.txt"))) 
        {
            cargas.write(origen + "," + destino);
            cargas.close();
        } catch (IOException ex) {
            Logger.getLogger(Cotizacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        File file = new File("orders.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            try {
                while ((st = br.readLine()) != null) {
                System.out.println(st);
                JOptionPane.showMessageDialog(null,st); 
                }   } catch (IOException ex) {
                Logger.getLogger(Cotizacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Cotizacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JOptionPane.showMessageDialog(null,"El origen de su carga es '" + origen + "', con destino a '" + destino + "'.");
        
        origen = JOptionPane.showInputDialog("Ingrese el origen de su carga 2: ");
        destino = JOptionPane.showInputDialog("Ingrese el destino de su carga 2: ");

        try (BufferedWriter cargas = new BufferedWriter(new FileWriter("orders.txt",true))) 
        {
            
            cargas.write("\n" + origen + "2 , 2" + destino);
            cargas.close();
        } catch (IOException ex) {
            Logger.getLogger(Cotizacion.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
    }
    
}

