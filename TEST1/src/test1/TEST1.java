/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class TEST1 
{
    static BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException
    {
        String Nombre;
        int Edad = 46;
        
        Nombre = entrada.readLine();
        
        System.out.println("El nombre del usuario es: " + Nombre);
        System.out.println("La edad del usuario es: " + Edad);
        
        Scanner entrada2 = new Scanner(System.in);
        
        System.out.println("Indique su nombre: ");
        Nombre = entrada2.nextLine();
        
        
        
        
    }
    
}
