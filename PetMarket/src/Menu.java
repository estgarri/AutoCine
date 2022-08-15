import javax.swing.*;

public class Menu
{
    static Registro registro = new Registro();
    static UsuariosMenu usermenu = new UsuariosMenu();

    static Ventas sale = new Ventas();
    static InicializarInventario inventario = new InicializarInventario();
    public static String[] opciones = { "","1. Usuarios", "2. Inventario",
            "3. Ventas", "4. Modificar información de los clientes", "5. Salir"};

    public static String msg = ("1. Usuarios. \n" +
            "2. Inventario. \n" +
            "3. Ventas. \n" +
            "4. Modificar información de los clientes.\n" +
            "5. Salir.");

    public static ImageIcon imagen = new ImageIcon("pet.png");

    public static boolean seguir = true;
    public void menu() {

        System.out.println("Hello World");
        //ImageIcon imagen = new ImageIcon("pet.png");
        seguir = true;

        while (seguir == true) {
            String res = (String) JOptionPane.showInputDialog(null, msg, "Sistema PetMarket - Menú principal",
                    JOptionPane.PLAIN_MESSAGE, imagen, opciones, opciones[0]);
            if (res != null){
                switch (res) {
                    case "1. Usuarios":
                        System.out.println("Usuarios");
                        usermenu.usuariosMenu();
                        break;

                    case "2. Inventario":
                        System.out.println("Inventario");
                        inventario.inventarioMenu();
                        break;
                    case "3. Ventas":
                        int sigo;
                        System.out.println("Ventas");
                        int cual = 1;
                        sigo = Registro.registroCliente(cual);
                        if (sigo == 2)
                        {
                            sale.venticas();
                        }
                        break;

                    case "4. Modificar información de los clientes":
                        System.out.println("Clientes");
                        Registro.modifyCliente();
                        break;

                    case "5. Salir":
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
    public void menuVendedor() {

        System.out.println("menuVendedor");
        //ImageIcon imagen = new ImageIcon("pet.png");
        String[] opciones2 = { "","1. Ventas", "2. Modificar información de los clientes", "3. Salir"};

        String msg2 = ("1. Ventas. \n" +
                "2. Modificar información de los clientes. \n" +
                "3. Salir." );

        seguir = true;

        while (seguir == true) {
            String res = (String) JOptionPane.showInputDialog(null, msg2, "Sistema PetMarket - Menú principal",
                    JOptionPane.PLAIN_MESSAGE, imagen, opciones2, opciones2[0]);
            if (res != null){
                switch (res) {
                    case "1. Ventas":
                        System.out.println("Ventas Vendedor");
                        int sigo;
                        int cual = 1;
                        sigo = Registro.registroCliente(cual);
                        if (sigo == 2)
                        {
                            sale.venticas();
                        }
                        break;


                    case "2. Modificar información de los clientes":
                        System.out.println("Modificar información de los clientes");
                        Registro.modifyCliente();

                        break;

                    case "3. Salir":
                        System.out.println("Salir Vendedor");
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
