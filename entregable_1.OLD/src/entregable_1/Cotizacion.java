
package entregable_1;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;

public class Cotizacion 
{
    public static String origen, destino;
    public static int cant;
    boolean seguir = true;
    
    public void cotizar()
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
        
        
        
        
        JOptionPane.showMessageDialog(null,"El origen de su carga es '" + origen + "', con destino a '" + destino + "'.");
    }
    
}
