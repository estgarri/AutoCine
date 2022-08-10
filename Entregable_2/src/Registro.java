import com.sun.deploy.security.SelectableSecurityManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Registro {

    public static ArrayList<Usuarios> usuarios = new ArrayList<>();


    public void nuevoRegistro()
    {
        JTextField field1 = new JTextField();
        JTextField field2 = new JTextField();
        JTextField field3 = new JTextField();
        JTextField field4 = new JTextField();
        JTextField field5 = new JTextField();
        //JTextField field6 = new JTextField();
        String[] opciones = {"","Broker", "Carrier"};

        ImageIcon image = new ImageIcon("ticoCargas.png");
        String value2, value3, value4, value5;
        int value1 = 0;
        Rol value6 = null;
        ImageIcon imagen = new ImageIcon("ticoCargas.png");

        String msg = ("Escoja el rol del nuevo usuario: \n" +
                "1. Broker \n" +
                "2. Carrier");


        Object[] fields = {
                "Ingrese la cédula: ", field1,
                "Ingrese el nombre: ", field2,
                "Ingrese los apellidos: ", field3,
                "Ingrese usuario: ", field4,
                "Ingrese la contraseña para el nuevo usuario: ", field5,
        };



        int option = JOptionPane.showConfirmDialog(null, fields, "Sistema TicoCArgas - Registro nuevo usuario",
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
                        "Sistema PetMarket", JOptionPane.WARNING_MESSAGE);
            }

            if (value1 == 0 || value2.equals("") || value3.equals("") || value4.equals("") || value5.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Error! Información incompleta, por favor intente de nuevo.",
                        "Sistema TicoCargas", JOptionPane.WARNING_MESSAGE);
            }
            else {
                System.out.println(value6);
                //value6 = Rol.valueOf((String)JOptionPane.showInputDialog(null, msg, "Pet's Market",
                        //JOptionPane.PLAIN_MESSAGE, imagen, opciones, opciones[0]));

                int test = JOptionPane.showConfirmDialog(null, "Es el nuevo usuario 'Broker?'", "Sistema TicoCargas - Rol", JOptionPane.YES_NO_OPTION);

                if (test == JOptionPane.YES_OPTION)
                {
                    value6 = Rol.Broker;
                }
                else if (test == JOptionPane.NO_OPTION)
                {
                    JOptionPane.showMessageDialog(null,"El usuario será asignado a Carrier.", "Systema TicoCargas - Rol", JOptionPane.INFORMATION_MESSAGE);
                    value6 = Rol.Carrier;
                }
                else
                {
                    value6 = null;
                }

                if (value6.equals(Rol.Broker) || value6.equals(Rol.Carrier)){
                    usuarios.add(new Usuarios(value1, value2, value3, value6, value4, value5));
                    System.out.println(value1 + value2 + value3 + value4 + value5 + value6);
                }
                else {
                    JOptionPane.showMessageDialog(null,"Error! Cancelando registro",
                            "Sistema PetMarket - Rol del nuevo usuario", JOptionPane.WARNING_MESSAGE);
                }
            }

        }
        else if (option == JOptionPane.CANCEL_OPTION)
        {
            JOptionPane.showMessageDialog(null, "Cancelando registro!!!", "Sistema TicoCArgas - Registro nuevo usuario", JOptionPane.WARNING_MESSAGE);

        }

    }

    public int login(String value1, String value2)
    {
        for (int i =0; i < usuarios.size(); i++)
        {
            String user = usuarios.get(i).getUsername();
            String pass = usuarios.get(i).getPassword();
            if (value1.equals(user) && value2.equals(pass))
            {
                return 1;
            }
        }
        return 0;
    }

    public void newRegistro()
    {
        JFrame userObj = new JFrame();



    }

}
