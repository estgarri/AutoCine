/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autocine;

import javax.swing.*;

/**
 *
 * @author estga
 */
public class AutoCine 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Initializar ini = new Initializar();
        //Disponible disponible = new Disponible();
        Menu menu = new Menu();
        //boolean seguir = true;
        //int seg =0;

        ini.Initializer();

        //while (seguir == true)
        //{

            //disponible.stalls();
            //disponible.reservar();
            //seg = Integer.parseInt(JOptionPane.showInputDialog("Digite 1 (si) - 2 (no): "));

            //if (seg == 2)
            //{
                //System.out.println(ini.cups[3][5]);
                //System.out.println(ini.cups[3][4]);
                //seguir = false;
                //break;
            //}
        //}
        menu.MenuDropDown();
    }
    
}
