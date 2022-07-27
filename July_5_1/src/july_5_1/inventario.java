/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package july_5_1;

/**
 *
 * @author estga
 */
public class inventario {
    
    public static int apple1 = 5, apple2 = 5, apple3 = 5, samsung = 5, huawei = 5, xiaomi = 5, test = 0, cant =0;
    
    /**
     *
     * @param opcion
     * @param cantidad
     */
    public void reducir(int opcion, int cantidad)
    {
        
        //System.out.println("HOLA");
        cant = cantidad;
        test = opcion;
        
        switch (test)
        {
            case 1:
                apple1 -= cant;
                break;
                
            case 2:
                apple2 -= cant;
                break;
            
            case 3:
                apple3 -= cant;
                break;
            
            case 4:
                samsung -= cant;
                break;
                
            case 5:
                huawei -= cant;
                break;
                
            case 6:
                xiaomi -= cant;
                break;
        }    
    }
    
    public void aumentar(int opcion, int cantidad)
    {
        cant = cantidad;
        test = opcion;
        switch (test)
        {
            case 1:
                apple1 += cant;
                break;
                
            case 2:
                apple2 += cant;
                break;
            
            case 3:
                apple3 += cant;
                break;
            
            case 4:
                samsung += cant;
                break;
                
            case 5:
                huawei += cant;
                break;
                
            case 6:
                xiaomi += cant;
                break;
        }
    }
}
