


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Registro {

    public static int cantidadE = 0;

    public static ArrayList<Usuarios> Arreglo = new ArrayList<>();
    public static ArrayList<RegisterLogin> Arreglo2 = new ArrayList<>();

    public static ArrayList<Clientes> customer = new ArrayList<>();

    static Menu menu = new Menu();

    static Object[] clientesCambio;


    public static String[] opciones = {"", "Gerente", "Vendedor"};
    public static String msg = ("Escoja el rol del nuevo usuario: \n" +
            "1. Gerente \n" +
            "2. Vendedor");



    public void regUsuario() {
        boolean seguir = true;
        ImageIcon imagen = new ImageIcon("Roles.png");
        int cedula = 0;

        ////////////////////////
        JTextField field1 = new JTextField();
        JTextField field2 = new JTextField();
        JTextField field3 = new JTextField();
        JTextField field4 = new JTextField();
        JTextField field5 = new JTextField();
        ///////////////////////////
        String value2, value3, value4, value5;
        int value1 = 0, z = 0;
        Rol value6 = null;
        /////////////////////////////////
        Object[] fields = {
                "Ingrese la cédula: ", field1,
                "Ingrese el nombre: ", field2,
                "Ingrese los apellidos: ", field3,
                "Ingrese usuario: ", field4,
                "Ingrese la contraseña para el nuevo usuario: ", field5,
        };
        ////////////////////////////////////////
        /*
        while (seguir) {
            try {
                cantidadE = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de usuarios a registrar:"));
                seguir = false;
            } catch (HeadlessException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error!", "Sistema PetMarket", JOptionPane.WARNING_MESSAGE);
            }
        }

         */


        //for (int i = 0; i < cantidadE; i++) {

            boolean cont = true;
            //JOptionPane.showMessageDialog(null, "Se solicitarán los datos del usuario " + (i + 1));

            int option = JOptionPane.showConfirmDialog(null, fields, "Sistema PetMarket - Registro de usuario nuevo",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, imagen);

            if (option == JOptionPane.OK_OPTION) {
                value2 = field2.getText();
                value3 = field3.getText();
                value4 = field4.getText();
                value5 = field5.getText();

                try {
                    value1 = Integer.parseInt(field1.getText());

                } catch (HeadlessException | NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Error! Formato inválido para el número de cédula.",
                            "Sistema TicoCargas", JOptionPane.WARNING_MESSAGE);
                }

                if (value1 == 0 || value2.equals("") || value3.equals("") || value4.equals("") || value5.equals("")) {
                    JOptionPane.showMessageDialog(null, "Error! Información incompleta, por favor intente de nuevo.",
                            "Sistema TicoCargas", JOptionPane.WARNING_MESSAGE);
                } else {
                    System.out.println(value6);

                    try {
                        value6 = Rol.valueOf((String) JOptionPane.showInputDialog(null, msg, "Sistema PetMarket",
                                JOptionPane.PLAIN_MESSAGE, imagen, opciones, opciones[0]));
                    } catch (NullPointerException e) {
                        JOptionPane.showMessageDialog(null, "Opción cancelada!!!", "Sistema PetMarket - Registro de usuario",
                                JOptionPane.WARNING_MESSAGE);
                        z = 1;
                    } finally {
                        if (z == 1) {
                            cont = false;
                        }
                    }
                    if (cont == true)
                    {
                        if (value6.equals(Rol.Gerente) || value6.equals(Rol.Vendedor)){
                            //usuarios.add(new Usuarios(value1, value2, value3, value6, value4, value5));
                            Arreglo.add(new Usuarios(value1, value2, value3, value6));
                            Arreglo2.add(new RegisterLogin(value4, value5, value2));

                            System.out.println(value1 + " " + value2 + " " + value3 + " " + value4 + " " + value5 + " " + value6);
                        }
                        else {
                            JOptionPane.showMessageDialog(null,"Error! Cancelando registro",
                                    "Sistema PetMarket - Rol del nuevo usuario", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    else {
                        System.out.println("Cancel in Rol Menu");
                    }
                }
            }
            else if (option == JOptionPane.CANCEL_OPTION) {
                JOptionPane.showMessageDialog(null, "Cancelando registro!!!",
                        "Sistema PetMarket - Registro nuevo usuario", JOptionPane.WARNING_MESSAGE);
            }




/*
            while (seguirT) {
                try {
                    cedula = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cédula:"));
                    seguirT = false;
                } catch (HeadlessException | NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Error!", "Sistema PetMarket", JOptionPane.WARNING_MESSAGE);
                }
            }
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre:");
            String apellidos = JOptionPane.showInputDialog("Ingrese los apellidos:");

            Rol rol = Rol.valueOf((String) JOptionPane.showInputDialog(null, msg, "Pet's Market",
                    JOptionPane.PLAIN_MESSAGE, imagen, opciones, opciones[0]));

            Arreglo.add(new Usuarios(cedula, nombre, apellidos, rol));

            String username = JOptionPane.showInputDialog("Ingrese el usuario:");
            String password = JOptionPane.showInputDialog("Ingrese la constraseña:");

            Arreglo2.add(new RegisterLogin(username, password, nombre));
            System.out.println("Adding");

        }

 */


    }
    public void getRol(String puser) {
        Rol rol = null;
        String user = "", user2 = "", user3 = "";


        for (int i = 0; i < Arreglo.size(); i++ )
        {


            user2 = Arreglo2.get(i).getUsername();

            if (puser.equals(user2))
            {
                user = Arreglo.get(i).getNombre();
                user3 = Arreglo2.get(i).getNombre();

                if (user.equals(user3))
                {
                    rol = Arreglo.get(i).getRol();
                    if (rol.equals(Rol.Gerente))
                    {
                        menu.menu();
                    }
                    else
                    {
                        System.out.println("Menú del Vendedor!!");
                        //JOptionPane.showMessageDialog(null, "Menú del Vendedor!!", "Sistema PetMarket", JOptionPane.INFORMATION_MESSAGE);
                        menu.menuVendedor();
                    }
                }
            }
        }
    }

    public String buscarPWD(String Dato1, String Dato2)
    {


        for (int i=0; i < Arreglo2.size(); i++ )
        {
            String test = Arreglo2.get(i).getUsername();
            String test2 = Arreglo2.get(i).getPassword();
            if (Dato1.equals(test) && Dato2.equals(test2))
            {
                return "existe";
            }
            System.out.println(test + " , " + test2);
        }
        return "no";

    }

    public void modificarUsuario() {
        int j = 0;
        String username = JOptionPane.showInputDialog("Ingrese el usuario a modificar:");
        if (username != null) {
            j = Arreglo2.size();
            int k = 0;
            for (int i = 0; i < Arreglo2.size(); i++) {
                String findUser = Arreglo2.get(i).getUsername();
                if (username.equals(findUser)) {
                    System.out.println("Modificando");
                    modificarMenu(i);
                    break;
                }
                k = i + 2;
            }
            if (k > j) {
                JOptionPane.showMessageDialog(null, "Error! - Usuario no es válido.", "Sistema PetMarket", JOptionPane.WARNING_MESSAGE);
            } else {
                System.out.println("Shutting down...");
                JOptionPane.showMessageDialog(null, "Cerrando...", "Sistema PetMarket", JOptionPane.WARNING_MESSAGE);
            }
        }
    }


    public void modificarMenu(int i) {

        //Registro registro = new Registro();
        String[] opcionRol = {"", "Gerente", "Vendedor"};
        String msg2 = ("Escoja el nuevo rol del suario: \n" +
                "1. Gerente \n" +
                "2. Vendedor");

        ImageIcon imagen = new ImageIcon("Roles.png");

        String[] opciones = {"", "1. Cambio de usuario", "2. Cambio de contraseña",
                "3. Cambiar el nombre", "4. Cambiar los apellidos","5. Cambio de rol","6. Eliminar cuenta","7. Salir"};

        String msg = ("1. Cambio de usuario. \n" +
                "2. Cambio de contraseña. \n" +
                "3. Cambiar el nombre. \n" +
                "4. Cambiar los apellidos. \n" +
                "5. Cambio de rol. \n" +
                "6. Eliminar cuenta. \n" +
                "7. Exit.\n");

        boolean seguir = true;

        System.out.println("modificarMenu()");
        ImageIcon imagens = new ImageIcon("account.png");
        seguir = true;

        while (seguir) {
            String res = (String) JOptionPane.showInputDialog(null, msg, "Sistema PetMarket - Modificación de usuarios",
                    JOptionPane.PLAIN_MESSAGE, imagens, opciones, opciones[0]);
            if (res != null) {
                switch (res) {
                    case "1. Cambio de usuario":
                        System.out.println("Change Username");
                        String newUser = JOptionPane.showInputDialog("Ingrese el nuevo usuario:");
                        if (newUser != null) {
                            Arreglo2.get(i).setUsername(newUser);
                            System.out.println(Arreglo2.get(i).getUsername());
                        }
                        else{
                            System.out.println("Username cancelled");
                            JOptionPane.showMessageDialog(null, "Cambio de usuario cancelado!!",
                                    "Sistema PetMarket - Cambio de usuario", JOptionPane.WARNING_MESSAGE);
                        }
                        //String newUser = JOptionPane.showInputDialog("Ingrese el nuevo usuario:");
                        //Arreglo2[i].Username = newUser;
                        break;

                    case "2. Cambio de contraseña":
                        System.out.println("Change Password");
                        String newPass = JOptionPane.showInputDialog("Ingrese la nueva contraseña:");
                        if (newPass != null) {
                            Arreglo2.get(i).setPassword(newPass);
                        }
                        else{
                            System.out.println("Password cancelled");
                            JOptionPane.showMessageDialog(null, "Cambio de contraseña cancelada!!",
                                    "Sistema PetMarket - Cambio de contraseña", JOptionPane.WARNING_MESSAGE);
                        }
                        //Arreglo2[i].Password = newPass;
                        break;

                    case "3. Cambiar el nombre":
                        System.out.println("Change Name");
                        String newName = JOptionPane.showInputDialog("Ingrese el nombre:");
                        if (newName != null) {
                            Arreglo2.get(i).setNombre(newName);
                            Arreglo.get(i).setNombre(newName);
                            System.out.println(Arreglo2.get(i).getNombre());
                            System.out.println(Arreglo.get(i).getNombre());
                        }
                        else{
                            System.out.println("Change Name");
                            JOptionPane.showMessageDialog(null, "Cambio de nombre cancelado!!",
                                    "Sistema PetMarket - Cambio de nombre", JOptionPane.WARNING_MESSAGE);
                        }
                        //Arreglo2[i].Nombre = newName;
                        //Arreglo[i].Nombre = newName;
                        break;

                    case "4. Cambiar los apellidos":
                        System.out.println("Change LastName");
                        String newLastName = JOptionPane.showInputDialog("Ingrese los nuevos apellidos:");
                        if (newLastName != null) {
                            Arreglo.get(i).setApellidos(newLastName);
                            System.out.println(Arreglo.get(i).getApellidos());
                        }
                        else{
                            System.out.println("Change LastName");
                            JOptionPane.showMessageDialog(null, "Cambio de apellidos cancelado!!",
                                    "Sistema PetMarket - Cambio de apellidos", JOptionPane.WARNING_MESSAGE);
                        }
                        //Arreglo[i].Apellidos = newLastName;
                        break;

                    case "5. Cambio de rol":
                        System.out.println("Change user's role");
                        try {
                            Arreglo.get(i).setRol(Rol.valueOf((String) JOptionPane.showInputDialog(null, msg2, "Pet's Market",
                                    JOptionPane.PLAIN_MESSAGE, imagen, opcionRol, opcionRol[0])));

                        } catch (NullPointerException e) {
                            JOptionPane.showMessageDialog(null, "Opción cancelada!!!", "Sistema PetMarket - Cambio del rol del usuario",
                                    JOptionPane.WARNING_MESSAGE);
                            System.out.println("Cancelled user's role");                        }

                        break;

                    case "6. Eliminar cuenta":
                        System.out.println("Delete user's account");
                        String uss = Arreglo2.get(i).getUsername();
                        int input = JOptionPane.showConfirmDialog(null, "Por confirme la eliminación de esta cuenta: " + uss);
                        if (input == 0) {
                            Arreglo.remove(i);
                            Arreglo2.remove(i);
                            JOptionPane.showMessageDialog(null, "La cuenta del usuario " + uss + " ha sido eliminado.");
                            seguir = false;
                        }

                        break;

                    case "7. Salir":
                        System.out.println("Exit");
                        seguir = false;
                        break;
                }
            }
            else{
                System.out.println("Cerrando menú - Modificación de usuarios");
                JOptionPane.showMessageDialog(null, "Cerrando menú - Modificación de usuarios",
                        "Sistema PetMarket - Modificación de usuarios", JOptionPane.WARNING_MESSAGE);
                seguir = false;
            }

        }
    }

    public static int registroCliente(int cual)
    {
        ImageIcon image2 = new ImageIcon("Roles.png");

        ////////////////////////
        JTextField field1 = new JTextField();
        JTextField field2 = new JTextField();
        JTextField field3 = new JTextField();
        JTextField field4 = new JTextField();

        ///////////////////////////

        int value1 = 0, verify = 0;
        String value2, value3, value4;
        boolean listo = true;

        ///////////////////////////

        Object[] clientes = {
                "Ingrese el nombre: ", field2,
                "Ingrese los apellidos: ", field3,
                "Ingrese correo electrónico: ", field4,
        };
        if (cual == 1) {
            JOptionPane.showMessageDialog(null, "Para el inicio de cualquier venta, el cliente debe estar registrado debidamente, en la siguiente  \n" +
                            "ventana se verificará si el cliente está registrado por medio de la cédula de identidad. ",
                    "Sistema PetMarket - Ventas", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Para el inicio de cualquier venta, el cliente debe estar registrado debidamente, en la siguiente  \n" +
                    "ventana se procederá al registro del cliente");
        }
            try {
                value1 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de cédula del cliente: "));
                for (int i = 0; i < customer.size(); i++)
                {
                    verify = customer.get(i).getCed();
                    if (value1 == verify) {
                        String nom = customer.get(i).getNom();
                        String apell = customer.get(i).getApell();
                        String correo = customer.get(i).getEmail();

                        JOptionPane.showMessageDialog(null, "Cliente: " + customer.get(i).getNom() + " " + customer.get(i).getApell() + "\n" +
                                "Cédula: " + customer.get(i).getCed() + "\n" +
                                "Correo electrónico: " + customer.get(i).getEmail(), "Cliente está registrado", JOptionPane.INFORMATION_MESSAGE);

                        Cart.addClienteCarrito(nom, apell, correo, value1);

                        listo = false;

                    }

                    }

        } catch (HeadlessException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error! Formato inválido para el número de cédula.",
                        "Sistema PetMarket", JOptionPane.WARNING_MESSAGE);
                listo = false;
                return 0;
        }

            if ( listo == true) {

                if (cual == 1) {
                    JOptionPane.showMessageDialog(null, "El cliente no se encuentra registrado, se procederá a la ventana de registro de clientes.");

                }
                int option = JOptionPane.showConfirmDialog(null, clientes, "Sistema PetMarket - Registro de clientes",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, image2);

                if (option == JOptionPane.OK_OPTION) {
                    value2 = field2.getText();
                    value3 = field3.getText();
                    value4 = field4.getText();

                    if (value1 == 0 || value2.equals("") || value3.equals("") || value4.equals("")) {
                        JOptionPane.showMessageDialog(null, "Error! Información incompleta, por favor intente de nuevo.",
                                "Sistema TicoCargas", JOptionPane.WARNING_MESSAGE);
                        return 0;
                    } else {
                        customer.add(new Clientes(value1, value2, value3, value4));
                        Cart.addClienteCarrito(value2, value3, value4, value1);
                        int z = customer.size();
                        --z;
                        JOptionPane.showMessageDialog(null, "Cliente: " + customer.get(z).getNom() + " " + customer.get(z).getApell() + "\n" +
                                "Cédula: " + customer.get(z).getCed() + "\n" +
                                "Correo electrónico: " + customer.get(z).getEmail());
                    }
                } else if (option == JOptionPane.CANCEL_OPTION) {
                    JOptionPane.showMessageDialog(null, "Cancelando registro del cliente!!!",
                            "Sistema PetMarket - Registro nuevo usuario", JOptionPane.WARNING_MESSAGE);
                    return 0;
                }

            }

        return 2;
    }

    public static void modifyCliente()
    {
        ImageIcon image2 = new ImageIcon("Roles.png");

        ////////////////////////
        JTextField field1 = new JTextField();
        JTextField field2 = new JTextField();
        JTextField field3 = new JTextField();
        JTextField field4 = new JTextField();

        ///////////////////////////

        String nom, apell, correo;
        /*static Object[] clientesCambio = {
                nom + "Cambio de nombre: ", field1,
                "Cambio de apellidos: ", field2,
                "Cambio de correo electrónico: ", field3,
        };*/

        int value1 = 0, verify = 0;

        boolean listo = true, reg = true;

        String value2 = "1", value3 = "1", value4 = "1";

        if ( listo == true) {
            try {
                value1 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de cédula del cliente: "));
                for (int i = 0; i < customer.size(); i++) {
                    verify = customer.get(i).getCed();
                    if (value1 == verify) {
                        reg= false;
                        nom = customer.get(i).getNom();
                        apell = customer.get(i).getApell();
                        correo = customer.get(i).getEmail();
                            clientesCambio = new Object[]{
                                "Nombre actual ("+ nom +")" + " Cambio de nombre: ", field2,
                                "Apellidos actuales ("+ apell +")" + " Cambio de apellidos: ", field3,
                                "Correo electrónical actual ("+ correo +")" + " Cambio de correo electrónico: ", field4,
                        };

                        int option = JOptionPane.showConfirmDialog(null, clientesCambio, "Sistema PetMarket - Registro de clientes",
                                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, image2);

                        if (option == JOptionPane.OK_OPTION) {
                            value2 = field2.getText();
                            value3 = field3.getText();
                            value4 = field4.getText();

                            int go = 0;

                            if (!value2.equals(""))
                            {
                                customer.get(i).setNom(value2);
                                go = 1;
                            }

                            if (!value3.equals(""))
                            {
                                customer.get(i).setApell(value3);
                                go = 1;
                            }

                            if (!value4.equals(""))
                            {
                                customer.get(i).setEmail(value4);
                                go = 1;
                            }
                            value2 = "1"; value3 = "1"; value4 = "1";

                            if (go == 1){
                                JOptionPane.showMessageDialog(null,"Cambios registrados exitosamente.");
                            }
                            else {
                                JOptionPane.showMessageDialog(null,"No hubo cambios.");
                            }

                        } else if (option == JOptionPane.CANCEL_OPTION) {
                        JOptionPane.showMessageDialog(null, "Cancelando registro del cliente!!!",
                                "Sistema PetMarket - Registro nuevo usuario", JOptionPane.WARNING_MESSAGE);
                        reg = false;
                        }

                    }
                }

            } catch (HeadlessException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error! Formato inválido para el número de cédula.",
                        "Sistema PetMarket", JOptionPane.WARNING_MESSAGE);
                listo = false;
            }
        }
        if (reg == true){
            JOptionPane.showMessageDialog(null, "Cliente no está registrado.");
            int option2 = JOptionPane.showConfirmDialog(null,"Cliente no está registrado, desea registrar al cliente?",
                    "Sistema PetMarket - Resgistro Clientes", JOptionPane.YES_NO_OPTION);

            if (option2 == JOptionPane.YES_OPTION)
            {
                int cual = 2;
                registroCliente(cual);
                JOptionPane.showMessageDialog(null,"Saliendo de la sección de registro de clientes");
            } else{
                JOptionPane.showMessageDialog(null,"Saliendo de la sección de registro de clientes");
            }

        }



    }
}
