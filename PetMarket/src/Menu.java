import javax.swing.*;

public class Menu
{
    static Registro registro = new Registro();
    static UsuariosMenu usermenu = new UsuariosMenu();
    static InicializarInventario inventario = new InicializarInventario();
    public static String[] opciones = { "","1. Usuarios", "2. Inventario",
            "3. Ventas", "4. Facturas", "5. Clientes", "6. Salir"};

    public static String msg = ("1. Usuarios. \n" +
            "2. Inventario. \n" +
            "3. Ventas. \n" +
            "4. Facturas. \n" +
            "5. Clientes.\n" +
            "6. Salir.");

    public static boolean seguir = true;
    public void menu() {

        System.out.println("Hello World");
        ImageIcon imagen = new ImageIcon("pet.png");
        seguir = true;

        while (seguir == true) {
            String res = (String) JOptionPane.showInputDialog(null, msg, "Sistema PetMarket - Menú principal",
                    JOptionPane.PLAIN_MESSAGE, imagen, opciones, opciones[0]);
            if (res != null){
                switch (res) {
                    case "1. Usuarios":
                        System.out.println("Usuarios");
                        //registro.regUsuario();
                        //registro.ingresarUsuario();
                        usermenu.usuariosMenu();
                        break;

                    case "2. Inventario":
                        System.out.println("Inventario");
                        inventario.inventarioMenu();

                        break;

                    case "3. Ventas":
                        System.out.println("Ventas");

                        break;

                    case "4. Facturas":
                        System.out.println("Facturas");

                        break;

                    case "5. Clientes":
                        System.out.println("Clientes");
                        //registro.consultarRegistro();
                        break;

                    case "6. Salir":
                        System.out.println("Salir");
                        seguir = false;
                        break;
                }
            }
            else{
                System.out.println("Cancel Hello World");
                JOptionPane.showMessageDialog(null, "Opción cancelada!!!", "Sistema PetMarket", JOptionPane.WARNING_MESSAGE);
                seguir = false;
            }

        }
    }
}
