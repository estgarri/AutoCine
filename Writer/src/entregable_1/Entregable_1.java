
package entregable_1;

import java.io.IOException;


public class Entregable_1 
{
    

    
    public static void main(String[] args) throws IOException 
    {
       Registro registro= new Registro();
       Cotizacion cot = new Cotizacion();
       
       registro.SolicitarUsuario();
       registro.MostrarPersona();
       cot.cotizar();
    }
    
}
