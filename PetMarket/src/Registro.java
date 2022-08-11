


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Registro {

    public static int cantidadE = 0;

    public static ArrayList<Usuarios> Arreglo = new ArrayList<>();
    public static ArrayList<RegisterLogin> Arreglo2 = new ArrayList<>();

    static Menu menu = new Menu();


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
                        JOptionPane.showMessageDialog(null, "Menú del Vendedor!!", "Sistema PetMarket", JOptionPane.INFORMATION_MESSAGE);
                        //menu.menuVendedor();
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
        if (username != null)
        {
            j = Arreglo2.size();
            int k = 0;
            for (int i=0; i < Arreglo2.size(); i++ )
            {
                String findUser = Arreglo2.get(i).getUsername();
                if(username.equals(findUser))
                {
                    System.out.println("Modificando");
                    modificarMenu(i);
                    break;
                }
                k = i + 2;
            }
            if (k > j)
            {
                JOptionPane.showMessageDialog(null, "Error! - Usuario no es válido.", "Sistema PetMarket", JOptionPane.WARNING_MESSAGE);
            }
        }
        else
        {
            System.out.println("Shutting down...");
            JOptionPane.showMessageDialog(null, "Cerrando...", "Sistema PetMarket", JOptionPane.WARNING_MESSAGE);
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
}