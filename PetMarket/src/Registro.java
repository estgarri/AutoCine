


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

        while (seguir) {
            try {
                cantidadE = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de usuarios a registrar:"));
                seguir = false;
            } catch (HeadlessException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error!", "Sistema PetMarket", JOptionPane.WARNING_MESSAGE);
            }
        }


        for (int i = 0; i < cantidadE; i++)
        {
            boolean seguirT = true;
            JOptionPane.showMessageDialog(null, "Se solicitarán los datos del usuario " + (i + 1));


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
        String username = JOptionPane.showInputDialog("Ingrese el usuario a modificar:");
        int j = Arreglo2.size();
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
            switch (res) {
                case "1. Cambio de usuario":
                    System.out.println("Change Username");
                    String newUser = JOptionPane.showInputDialog("Ingrese el nuevo usuario:");
                    Arreglo2.get(i).setUsername(newUser);
                    System.out.println(Arreglo2.get(i).getUsername());
                    //String newUser = JOptionPane.showInputDialog("Ingrese el nuevo usuario:");
                    //Arreglo2[i].Username = newUser;
                    break;

                case "2. Cambio de contraseña":
                    System.out.println("Change Password");
                    String newPass = JOptionPane.showInputDialog("Ingrese la nueva contraseña:");
                    Arreglo2.get(i).setPassword(newPass);
                    //Arreglo2[i].Password = newPass;
                    break;

                case "3. Cambiar el nombre":
                    System.out.println("Change Name");
                    String newName = JOptionPane.showInputDialog("Ingrese el nombre:");
                    Arreglo2.get(i).setNombre(newName);
                    Arreglo.get(i).setNombre(newName);
                    System.out.println(Arreglo2.get(i).getNombre());
                    System.out.println(Arreglo.get(i).getNombre());
                    //Arreglo2[i].Nombre = newName;
                    //Arreglo[i].Nombre = newName;
                    break;

                case "4. Cambiar los apellidos":
                    System.out.println("Change LastName");
                    String newLastName = JOptionPane.showInputDialog("Ingrese los nuevos apellidos:");
                    Arreglo.get(i).setApellidos(newLastName);
                    System.out.println(Arreglo.get(i).getApellidos());
                    //Arreglo[i].Apellidos = newLastName;
                    break;

                case "5. Cambio de rol":
                    System.out.println("Change user's role");
                    Arreglo.get(i).setRol(Rol.valueOf((String) JOptionPane.showInputDialog(null, msg2, "Pet's Market",
                            JOptionPane.PLAIN_MESSAGE, imagen, opcionRol, opcionRol[0])));
                    //Arreglo[i].rol = Rol.valueOf((String) JOptionPane.showInputDialog(null, msg2, "Pet's Market",
                            //JOptionPane.PLAIN_MESSAGE, imagen, opcionRol, opcionRol[0]));
                    break;

                case "6. Eliminar cuenta":
                    System.out.println("Delete user's account");
                    String uss = Arreglo2.get(i).getUsername();
                    int input = JOptionPane.showConfirmDialog(null, "Por confirme la eliminación de esta cuenta: " + uss);
                    if (input == 0)
                    {
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
    }
}