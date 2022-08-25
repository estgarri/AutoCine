import javax.swing.*;
import java.awt.*;

public class Menu {

    static Registro registro = new Registro();

    public void menu() {


    }

    public void menuAdmin() {
        String[] opciones = {"", "1. Usuarios nuevos", "2. Modificar usuarios",
                "3. Eliminar usuario", "4. Salir"};

        String msg = ("1. Usuarios nuevos. \n" +
                "2. Modificar usuarios. \n" +
                "3. Eliminar usuario. \n" +
                "4. Salir.");

        boolean seguir = true;

        ImageIcon image = new ImageIcon("ticoCargas.png");
        ImageIcon image3 = new ImageIcon("under.png");

        System.out.println("menuAdmin");

        while (seguir == true) {
            String res = (String) JOptionPane.showInputDialog(null, msg, "Sistema TicoCargas - Menú Admin",
                    JOptionPane.PLAIN_MESSAGE, image, opciones, opciones[0]);

            if (res != null){
                switch (res) {
                    case "1. Usuarios nuevos":
                        System.out.println("Usuarios nuevos");
                        Registro.nuevoRegistro();
                        break;

                    case "2. Modificar usuarios":
                        System.out.println("Modificar usuarios");
                        Administration.modificarUsuarios();

                        break;

                    case "3. Eliminar usuario":
                        System.out.println("Eliminar usuario");
                        //eliminarCuenta();
                        JOptionPane.showMessageDialog(null, "Under construction", "Sistema TicoCargas", JOptionPane.PLAIN_MESSAGE, image3);
                        break;


                    case "4. Salir":
                        System.out.println("Salir");
                        seguir = false;
                        break;
                }
            }
            else
            {
                System.out.println("Cerrando sessión - Menú Admin...");
                JOptionPane.showMessageDialog(null, "Cerrando sessión - Menú Admin...");
                seguir = false;
            }

        }
    }

    public void menuBrokerCarrier(String Value1) {
        Rol rol = null;
        for (int i = 0; i < Registro.usuarios.size(); i++) {
            if (Value1.equals(Registro.usuarios.get(i).getUsername())) {
                rol = Registro.usuarios.get(i).getRol();
                int id = Registro.usuarios.get(i).getCedula();
                if (rol.equals(Rol.Broker)) {
                    broker(id);
                } else {
                    carrier(id);
                }
            }

        }
    }

    public void broker(int id) {
        System.out.println("Broker's menu");

        String[] opciones = {"", "1. Consultas", "2. Cotizar",
                "3. Aceptar o rechazar cotizaciones", "4. Salir"};

        String msg = ("1. Consultas. \n" +
                "2. Cotizar. \n" +
                "3. Aceptar o rechazar ofertas. \n" +
                "4. Salir.");

        boolean seguir = true;

        ImageIcon image = new ImageIcon("ticoCargas.png");

        while (seguir == true) {
            String res = (String) JOptionPane.showInputDialog(null, msg, "Sistema TicoCargas - Menú Broker",
                    JOptionPane.PLAIN_MESSAGE, image, opciones, opciones[0]);
            if (res != null){
                switch (res) {
                    case "1. Consultas":
                        System.out.println("Consultas");
                        //Broker.consultasPendientes(id);
                        consultasBroker(id);
                        break;

                    case "2. Cotizar":
                        System.out.println("Cotizar");
                        Broker.cotizar(id);
                        break;

                    case "3. Aceptar o rechazar ofertas":
                        System.out.println("Aceptar o rechazar cotizaciones");
                        Broker.aceptarRechazar(id);
                        break;

                    case "4. Salir":
                        System.out.println("Salir");
                        seguir = false;
                        break;

                }
            }
            else{
                System.out.println("Cancel Menú Broker");
                JOptionPane.showMessageDialog(null, "Opción cancelada!!!", "Sistema TicoCArgas - Menú Broker", JOptionPane.WARNING_MESSAGE);
                seguir = false;
            }
        }
    }

    public void carrier(int id) {
        System.out.println("Carrier's menu");

        String[] opciones = {"", "1. Ofertas aceptadas", "2. Ofertas pendientes",
                "3. Presentar oferta", "4. Salir"};

        String msg = ("1. Ofertas aceptadas. \n" +
                "2. Ofertas pendientes. \n" +
                "3. Presentar oferta. \n" +
                "4. Salir.");

        boolean seguir = true;

        ImageIcon image = new ImageIcon("ticoCargas.png");
        while (seguir == true) {
            String res = (String) JOptionPane.showInputDialog(null, msg, "Sistema TicoCargas - Carrier Broker",
                    JOptionPane.PLAIN_MESSAGE, image, opciones, opciones[0]);
            if (res != null){
                switch (res) {
                    case "1. Ofertas aceptadas":
                        System.out.println("Carrier Ofertas aceptadas");
                        Carrier.ofertasAceptadasC(id);
                        JOptionPane.showMessageDialog(null, "Reporte(s) descargado(s), 'Root directory'.");
                        break;

                    case "2. Ofertas pendientes":
                        System.out.println("Carrier Ofertas pendientes");
                        Carrier.ofertasPendientes(id);
                        break;

                    case "3. Presentar oferta":
                        System.out.println("Presentar oferta");
                        Carrier.presentarOferta(id);

                        break;

                    case "4. Salir":
                        System.out.println("Salir");
                        seguir = false;
                        break;

                }
            }
            else{
                System.out.println("Cancel Menú Broker");
                JOptionPane.showMessageDialog(null, "Opción cancelada!!!", "Sistema TicoCArgas - Menú Broker", JOptionPane.WARNING_MESSAGE);
                seguir = false;
            }
        }
    }

    public void consultasBroker(int id){
        System.out.println("consultasBroker");

        String[] opciones = {"", "1. Ofertas pendientes", "2. Ofertas aceptadas", "3. Salir"};

        String msg = ("1. Ofertas pendientes. \n" +
                "2. Ofertas aceptadas. \n" +
                "3. Salir.");

        boolean seguir = true;

        ImageIcon image = new ImageIcon("ticoCargas.png");

        while (seguir == true) {
            String res = (String) JOptionPane.showInputDialog(null, msg, "Sistema TicoCargas - Menú Broker",
                    JOptionPane.PLAIN_MESSAGE, image, opciones, opciones[0]);
            if (res != null){
                switch (res) {
                    case "1. Ofertas pendientes":
                        System.out.println("Consultas - Ofertas pendientes");
                        Broker.consultasPendientes(id);
                        break;

                    case "2. Ofertas aceptadas":
                        System.out.println("Consultas - Ofertas aceptadas");
                        Broker.ofertasAceptadas(id);
                        JOptionPane.showMessageDialog(null, "Reporte(s) descargado(s), 'Root directory'.");
                        break;

                    case "3. Salir":
                        System.out.println("Salir");
                        seguir = false;
                        break;

                }
            }
            else{
                System.out.println("Cancel Consultas");
                JOptionPane.showMessageDialog(null, "Opción cancelada!!!", "Sistema TicoCArgas - Menú de consultas", JOptionPane.WARNING_MESSAGE);
                seguir = false;
            }
        }
    }

    public void eliminarCuenta()
    {
        ImageIcon image2 = new ImageIcon("Roles.png");

        ////////////////////////
        JTextField field1 = new JTextField();
        JTextField field2 = new JTextField();
        JTextField field3 = new JTextField();
        JTextField field4 = new JTextField();

        ///////////////////////////

        Rol rol = null;

        int value1 = 0, id = 0;

        boolean listo = true;


        if ( listo == true){

            String cedula = JOptionPane.showInputDialog("Ingrese el número de cédula del usuario al cual desea eliminar cuenta: ");

            if (cedula != null) {

                try {
                    value1 = Integer.parseInt(cedula);

                    for (int i = 0; i < Registro.usuarios.size(); i++)
                    {
                        if (value1 == Registro.usuarios.get(i).getCedula() )
                        {

                            String user = Registro.usuarios.get(i).getUsername();
                            id = Registro.usuarios.get(i).getCedula();
                            int input = JOptionPane.showConfirmDialog(null, "Por confirme la eliminación de esta cuenta: " + user);

                            if (input == 0)
                            {
                                rol = Registro.usuarios.get(i).getRol();
                                if (rol.equals(Rol.Broker))
                                {
                                    for (int j = 0; j < Broker.ordenesCotB.size(); j++)
                                    {
                                        int cotB = Broker.ordenesCotB.get(j).getIDB();
                                        if (id == cotB)
                                        {
                                            Broker.ordenesCotB.remove(j);
                                            --j;

                                        }
                                    }
                                    Registro.usuarios.remove(i);
                                    JOptionPane.showMessageDialog(null, "Usuario " + user + " eliminado");

                                } else if (rol.equals(Rol.Carrier)) {
                                    for (int j = 0; j < Broker.tempB.size(); j++)
                                    {
                                        int cotC = Broker.tempB.get(j).getIDC();
                                        if (id == cotC)
                                        {
                                            Broker.tempB.remove(j);
                                            --j;
                                        }
                                    }
                                    Registro.usuarios.remove(i);
                                    JOptionPane.showMessageDialog(null, "Usuario " + user + " eliminado");
                                }
                            }
                        }
                    }

                } catch (HeadlessException | NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Error! Formato inválido para el número de cédula.",
                            "Sistema TicoCargas", JOptionPane.WARNING_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(null,"Cancelando, no se ha desabilitado ninguna cuenta de usuario.");
            }

        }



    }

}




