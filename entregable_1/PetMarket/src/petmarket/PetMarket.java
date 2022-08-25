/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petmarket;

public class PetMarket
{
    static Login menuLogin = new Login();
    static InicializarInventario ini = new InicializarInventario();
    public static void main(String[] args)
    {
        ini.inicializar();
        menuLogin.terminarMenu();
    }
} 