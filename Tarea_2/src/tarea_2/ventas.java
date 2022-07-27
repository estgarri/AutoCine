/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea_2;

import javax.swing.JOptionPane;

/**
 *
 * @author garciaes
 */
public class ventas {
    
    
    
    public static boolean seguir = true;    
    public static int entretenimiento = 6000, jardineria = 6500, gastronomia = 7000, emprendimiento = 7500, 
                                        rompe1 = 12000, rompe15 = 12500, rompe2 = 13000, rompe2001 = 13500,
                                        libClub = 0, noLibClub = 0, optionv = 0, entrei = 0, jardi = 0, 
                                        gastri = 0, empri = 0, rompi1 = 0, rompi15 = 0, rompi2 = 0, 
                                        rompi2001 = 0, totalLibros = 0, totalRompe = 0,
                                        i, j, k, l, m, n, o, p;
    
    public static double subtotal, total, ventasTotales;
    
    public static void categorias()
    {
        seguir = true;
        //menu verificar = new menu();
        while (seguir == true)
        {
            optionv = 0;
            optionv = Integer.parseInt(JOptionPane.showInputDialog("Escoja su opción:  \n" +
            "1. Digite '1' para libros de 'entretenimiento'. \n" + 
            "2. Digite '2' para libros de 'jardinería'. \n" +
            "3. Digite '3' para libros de 'gastronomía'. \n" +
            "4. Digite '4 para libros de 'emprendimiento'. \n" +
            "5. Digite '5' para rompecabezas de '500 a 1000'. \n" +
            "6. Digite '6' para rompecabezas de '1001 a 1500'. \n" +
            "7. Digite '7' rompecabezas de '1501 a 2000'. \n" +
            "8. Digite '8' rompecabezas de '2001 o más'. \n" +
            "9. Digite 9 para terminar la venta."));
                
                switch (optionv)
                {
                    case 1:
                        i = Integer.parseInt(JOptionPane.showInputDialog("Digite el número de libros a comprar: "));
                        entrei += i;
                        subtotal = entretenimiento * i;
                        //System.out.println("Venta: " + entretenimiento);
                        break;
                    
                    case 2:
                        break;
                    
                    case 3:
                        break;
                    
                    case 4:
                        break;
                        
                    case 5:
                        break;
                        
                    case 6:
                        break;

                    case 7:
                        break;
                        
                    case 8:
                        break;
                        
                    case 9:
                        if (menu.existe == 0)
                        {
                            total = subtotal;
                            ventasTotales += total;                            
                            seguir = false;                            
                            break; 
                        }
                        else
                        {
                            total = subtotal * 0.85;
                            ventasTotales += total;
                            seguir = false;
                            break;
                        }
                                             
                           
                    default:
                        break;

                }                       
        }
        System.out.println("Es venta es de: " + total);
        System.out.println("Ventas totales: " + ventasTotales + " Libros: " + entrei);
    }
             
}


