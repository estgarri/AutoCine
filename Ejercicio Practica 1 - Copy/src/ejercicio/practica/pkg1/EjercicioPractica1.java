sala

package ejercicio.practica.pkg1;
/*
import java.util.Scanner;
*/
import javax.swing.JOptionPane;


public class EjercicioPractica1 
{

    
    public static void main(String[] args) 
    {
        String Nombre;
        int Cedula;
        int Edad;
        String Direccion;
        String CursoM;
        /*
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Ingrese su nombre: ");
        Nombre = entrada.nextLine();
        
        System.out.println("Ingrese la cédula: ");
        Cedula = Integer.parseInt(entrada.nextLine());
        
        System.out.println("Ingrese la edad: ");
        Edad = Integer.parseInt(entrada.nextLine());
        
        System.out.println("Ingrese su dirección: ");
        Direccion = entrada.nextLine();
        
        System.out.println("Ingrese el curso matriculado: ");
        CursoM = entrada.nextLine();
        
        System.out.println("Los datos registrados del usuario son: \n" + 
                            "Nombre: " + Nombre + "\n" +
                            "Cédula: " + Cedula + "\n" +
                            "Edad: " + Edad + "\n" +
                            "Dirección: " + Direccion + "\n" +
                            "Curso Matriculado: " + CursoM);
        */
        
        Nombre = JOptionPane.showInputDialog("Indique su nombre: ");
        Cedula = Integer.parseInt(JOptionPane.showInputDialog("Indique su cédula: "));
        Edad = Integer.parseInt(JOptionPane.showInputDialog("Indique su edad: "));
        Direccion = JOptionPane.showInputDialog("Indique su direccion: ");
        CursoM = JOptionPane.showInputDialog("Indique el curso matriculado: ");
        
        "(null,"Los datos registrados del usuario son: \n" + 
                            "Nombre: " + Nombre + "\n" +
                            "Cédula: " + Cedula + "\n" +
                            "Edad: " + Edad + "\n" +
                            "Dirección: " + Direccion + "\n" +
                            "Curso Matriculado: " + CursoM);
        
    }
    
}
