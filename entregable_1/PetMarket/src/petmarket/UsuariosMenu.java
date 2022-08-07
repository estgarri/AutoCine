/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petmarket;


import javax.swing.*;

public class UsuariosMenu {

    static Registro registro = new Registro();
    public static String[] opciones = { "","1. Create new user", "2. Modify existing user's info",
            "3. Admin Cliente", "4. Exit"};

    public static String msg = ("1. Create new user. \n" +
            "2. Modify existing user's info. \n" +
            "3. Admin Cliente. \n" +
            "4. Exit.\n");

    public static boolean seguir = true;

    public void usuariosMenu() {

        System.out.println("User's Menu");
        ImageIcon imagens = new ImageIcon("user.png");
        seguir = true;

        while (seguir) {
            String res = (String) JOptionPane.showInputDialog(null, msg, "Sistema PetMarket - Menú de administración de cuentas",
                    JOptionPane.PLAIN_MESSAGE, imagens, opciones, opciones[0]);
            switch (res) {
                case "1. Create new user":
                    System.out.println("Create new user");
                    registro.regUsuario();
                    break;

                case "2. Modify existing user's info":
                    System.out.println("Modify existing user's info");
                    registro.modificarUsuario();
                    break;

                case "3. Admin Cliente":
                    System.out.println("Admin Cliente");

                    break;

                case "4. Exit":
                    System.out.println("Exit");
                    seguir = false;
                    break;
            }

        }
    }
}
