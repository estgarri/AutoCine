import javax.swing.*;

public class Menu {

    static Registro registro = new Registro();

    public void menu()
    {


    }

    public void menuAdmin()
    {
        String[] opciones = { "","1. Usuarios nuevos", "2. Modificar usuarios",
                "3. Eliminar usuario", "4. Consultas de ofertas", "5. Clientes", "6. Salir"};

        String msg = ("1. Usuarios nuevos. \n" +
                "2. Modificar usuarios. \n" +
                "3. Eliminar usuario. \n" +
                "4. Consultas de ofertas. \n" +
                "5. Clientes.\n" +
                "6. Salir.");

        boolean seguir = true;

        ImageIcon image = new ImageIcon("ticoCargas.png");

        System.out.println("menuAdmin");

        while (seguir == true) {
            String res = (String) JOptionPane.showInputDialog(null, msg, "Sistema TicoCargas - Menú Admin",
                    JOptionPane.PLAIN_MESSAGE, image, opciones, opciones[0]);
            switch (res) {
                case "1. Usuarios nuevos":
                    System.out.println("Usuarios nuevos");
                    registro.nuevoRegistro();

                    break;

                case "2. Modificar usuarios":
                    System.out.println("Modificar usuarios");

                    break;

                case "3. Eliminar usuario":
                    System.out.println("Eliminar usuario");

                    break;

                case "4. Consultas de ofertas":
                    System.out.println("Consultas de ofertas");

                    break;

                case "5. Clientes":
                    System.out.println("Clientes");

                    break;

                case "6. Salir":
                    System.out.println("Salir");
                    seguir = false;
                    break;
            }

        }


    }
}
