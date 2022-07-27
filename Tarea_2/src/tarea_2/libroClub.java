
package tarea_2;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;


public class libroClub {
    
    public static ArrayList<String> members = new ArrayList<>(Arrays.asList("Esteban", "Robert", "Gabo", "Amanda"));
    public static String words;
    
    
    public static int miembros()
    {
        words = JOptionPane.showInputDialog("Digite el usuario a verificar: ");
        //System.out.println(words);
        for (String i : members)
        {  
          //System.out.println("i" + i);
          if (words.equals(i))
          {
              JOptionPane.showMessageDialog(null, "El usuario '" + words + "' tiene membresía.");
              return 1;
              
          }
       
        }
        JOptionPane.showMessageDialog(null, "Usuario no tiene membresía.");
        return 0;  
    }
    
}
