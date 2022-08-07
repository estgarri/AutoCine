
package entregable_1;


public class Entregable_1 
{
    

    
    public static void main(String[] args) 
    {
       Registro registro= new Registro();
       Cotizacion cot = new Cotizacion();
       
       registro.SolicitarUsuario();
       registro.MostrarPersona();
       cot.cotizar();
    }
    
}
