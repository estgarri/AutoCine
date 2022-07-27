
import javax.swing.JOptionPane;

public class Tarea_1_Esteban_Garcia_Rivera 
{

    public static void main(String[] args) 
    {
        double salarioMensual;
        double salarioPendiente;
        int tiempoLaborado = 2;
        double vacaciones;
        double aguinaldo;
        double preaviso;
        double cesantia;
        double liquidacion;
        
        salarioMensual = Integer.parseInt(JOptionPane.showInputDialog("Por favor ingrese el salario mensual: "));
        
        salarioPendiente = salarioMensual;
        
        vacaciones = (salarioMensual / 30 * 14);
        
        aguinaldo = (salarioMensual * 1 / 12);
        
        preaviso = (salarioMensual);
        
        cesantia = (salarioMensual / 30 * 20 * tiempoLaborado);
        
        liquidacion = (salarioPendiente + vacaciones + aguinaldo + preaviso + cesantia);
        
        JOptionPane.showMessageDialog(null,"El monto a pagar por concepto de liquidación es: ₡" + liquidacion);
        
 
    }
    
}
