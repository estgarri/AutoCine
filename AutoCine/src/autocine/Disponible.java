package autocine;

import javax.swing.*;
import java.util.Arrays;

public class Disponible
{
    String[][] cupos = new String[4][6];
    public static String cadena = "", cadena2 = "", placa = "";
    public static int fila =0, columna =0, sn = 0;
    Initializar ini = new Initializar();
    public void stalls()
    {

        //Initializar ini = new Initializar();
        cupos = ini.cups;
        cadena = "";
        cadena2 = "";
        //System.out.println("Disponible");
        //System.out.println(Arrays.deepToString(this.cupos));

        for (int f = 0; f < cupos.length; f++)
        {
            for (int c = 0; c < cupos[0].length; c++)
            {
                if (!cupos[f][c].equals("D"))
                {
                    //cadena += ("Ocupado - Fila: " + (f + 1) + " Stall número: " + (c + 1) + " está " + cupos[f][c] + "\n");
                    cadena += ("Ocupado - Fila: " + (f + 1) + " Stall: " + (c + 1) + " está ocupado por carro placa:" + cupos[f][c] + "\n");
                }
                else{
                    cadena2 += ("Fila: " + (f + 1) + " Stall: " + (c + 1) + " está disponilbe. \n");
                }

            }
            
        }
        //System.out.println(cadena);
    }
    public void reservar()
    {
        ImageIcon reserv = new ImageIcon("reserva.png");
        placa = "";
        fila = 0;
        columna = 0;


        System.out.println(cadena2);
        JOptionPane.showMessageDialog(null,cadena2, "Reservaciones",JOptionPane.INFORMATION_MESSAGE,reserv);
        //System.out.println(cadena);

        fila = Integer.parseInt(JOptionPane.showInputDialog("Digite la fila: "));
        columna = Integer.parseInt(JOptionPane.showInputDialog("Digite la columna: "));
        placa = JOptionPane.showInputDialog("Digite la placa: ");

        if (ini.cups[fila - 1][columna - 1].equals("D"))
        {
            sn = JOptionPane.showConfirmDialog(null,"Campo a reservar es 'Fila': " + fila + " 'Stall' : " + columna);

            if (sn == 0)
            {
                ini.cups[fila - 1][columna - 1] = placa;
                JOptionPane.showMessageDialog(null, "Reservación confirmada, 'Fila': " + fila + " 'Stall' : " + columna);
                ini.cups = cupos;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Reservación cancelada");
            }

        }
        else
        {
            JOptionPane.showMessageDialog(null, "Stall se encuentra ocupado.");
        }

        //ini.cups[fila - 1][columna - 1] = placa;
        //ini.cups = cupos;
        //System.out.println("Reservar ************************");
        //System.out.println(Arrays.deepToString(this.cupos));

    }
    public void modificar()
    {
        cupos = ini.cups;
        placa = JOptionPane.showInputDialog("Para modificar una reservación existente, por fave digite la placa: ");
        for (int f = 0; f < cupos.length; f++)
        {
            for (int c = 0; c < cupos[0].length; c++)
            {
                if (cupos[f][c].equals(placa))
                {
                    JOptionPane.showMessageDialog(null, "Existe");
                    ini.cups[f][c] = ("D");
                    stalls();
                    reservar();
                    cupos = ini.cups;
                    JOptionPane.showMessageDialog(null, "Su nueva reservación ha sido confirmada");
                    placa = "0";
                }

            }

        }

    }
    public void cancelar()
    {
        cupos = ini.cups;
        placa = JOptionPane.showInputDialog("Para cancelar una reservación existente, por fave digite la placa: ");
        for (int f = 0; f < cupos.length; f++)
        {
            for (int c = 0; c < cupos[0].length; c++)
            {
                if (cupos[f][c].equals(placa))
                {
                    JOptionPane.showMessageDialog(null, "Existe");
                    ini.cups[f][c] = ("D");
                    cupos = ini.cups;
                    JOptionPane.showMessageDialog(null, "La cancelación ha sido confirmada");
                    placa = "0";
                }

            }

        }

    }
}
