/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package july_5_1;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;

/**
 *
 * @author estga
 */
public class verify {
    
    public static int identificacion, telefono, desc;
    
    public static int ident()
    {
        try{
            identificacion = Integer.parseInt(JOptionPane.showInputDialog("Digite el número de identificación: "));
        }
        catch (HeadlessException | NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null,"Por favor digite números para ingresar tu identificación.");
        }
        return identificacion;        
    }
    public static int telefono()
    {
        try{
            telefono = Integer.parseInt(JOptionPane.showInputDialog("Digite el número de teléfono: "));
        }
        catch (HeadlessException | NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null,"Por favor digite números para ingresar el TEL.");
        }
        return telefono;        
    }
    public static int descuento()
    {
        try{
            desc = Integer.parseInt(JOptionPane.showInputDialog("Digite '1' para pagar en efectivo o '2' para tarjeta: "));
        }
        catch (HeadlessException | NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null,"Por favor digite números para ingresar tu identificación.");
        }
        return desc;         
    }
}
