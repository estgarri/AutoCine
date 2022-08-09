import javax.swing.*;

public class Menu {

    static Registro registro = new Registro();

    public void menu() {


    }

    public void menuAdmin() {
        String[] opciones = {"", "1. Usuarios nuevos", "2. Modificar usuarios",
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

            if (res != null){
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
            else
            {
                System.out.println("Cerrando sessión - Menú Admin...");
                JOptionPane.showInputDialog(null, "Cerrando sessión - Menú Admin...");
                seguir = false;
            }

        }
    }

    public void menuBrokerCarrier(String Value1) {
        Rol rol = null;
        for (int i = 0; i < Registro.usuarios.size(); i++) {
            if (Value1.equals(Registro.usuarios.get(i).getUsername())) {
                rol = Registro.usuarios.get(i).getRol();
                if (rol.equals(Rol.Broker)) {
                    broker();
                } else {
                    carrier();
                }
            }

        }
    }

    public void broker() {
        System.out.println("Broker's menu");

        String[] opciones = {"", "1. Ofertas aceptadas", "2. Cotizar",
                "3. Aceptar o rechazar cotizaciones", "4. Salir"};

        String msg = ("1. Ofertas aceptadas. \n" +
                "2. Cotizar. \n" +
                "3. Aceptar o rechazar cotizaciones. \n" +
                "4. Salir.");

        boolean seguir = true;

        ImageIcon image = new ImageIcon("ticoCargas.png");

        while (seguir == true) {
            String res = (String) JOptionPane.showInputDialog(null, msg, "Sistema TicoCargas - Menú Broker",
                    JOptionPane.PLAIN_MESSAGE, image, opciones, opciones[0]);
            if (res != null){
                switch (res) {
                    case "1. Ofertas aceptadas":
                        System.out.println("Ofertas aceptadas");

                        break;

                    case "2. Cotizar":
                        System.out.println("Cotizar");

                        break;

                    case "3. Aceptar o rechazar cotizaciones":
                        System.out.println("Aceptar o rechazar cotizaciones");

                        break;

                    case "4. Salir":
                        System.out.println("Salir");
                        seguir = false;
                        break;

                }
            }
            else{
                System.out.println("Cancel");
                seguir = false;
            }
        }
    }

    public void carrier() {
        System.out.println("Carrier's menu");

        String[] opciones = {"", "1. Ofertas aceptadas", "2. Ofertas pendientes",
                "3. Cotizar", "4. Salir"};

        String msg = ("1. Ofertas aceptadas. \n" +
                "2. Ofertas pendientes. \n" +
                "3. Cotizar. \n" +
                "4. Salir.");

        boolean seguir = true;

        ImageIcon image = new ImageIcon("ticoCargas.png");
    }
}




