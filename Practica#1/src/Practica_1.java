
import javax.swing.JOptionPane;


public class Practica_1 
{
    
    public static void main(String[] args) 
    {
        double salarioBruto;
        double deducciones;
        double salarioNeto;
        String nombre;
        nombre = JOptionPane.showInputDialog("Indique su nombre: ");
        salarioBruto = Integer.parseInt(JOptionPane.showInputDialog("Indique su salario mensual: "));
        
        deducciones = salarioBruto * 0.0934;
        salarioNeto = salarioBruto - deducciones;
        
        JOptionPane.showMessageDialog(null,"Estimado " + nombre + ", el salario de este mes se desglosa de la siguiente manera: \n" +
                                      "Salario bruto: " + salarioBruto + "\n" +
                                      "Deducciones: " + deducciones + "\n" +
                                      "Salario neto : " + salarioNeto);
        
         
    }
    
}
