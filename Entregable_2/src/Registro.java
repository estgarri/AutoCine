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
        JTextField field6 = new JTextField();
        String[] opciones = {"", "Broker", "Carrier"};
        ImageIcon image = new ImageIcon("ticoCargas.png");
        String value2 = "", value3 = "", value4 = "", value5 = "";
        int value1;
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
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, image);

        if (option == JOptionPane.OK_OPTION) {
            value2 = field2.getText();
            value3 = field3.getText();
            value4 = field4.getText();
            value5 = field5.getText();


        }
        try {
            value1 = Integer.parseInt(field1.getText());
            value6 = Rol.valueOf((String)JOptionPane.showInputDialog(null, msg, "Pet's Market",
                    JOptionPane.PLAIN_MESSAGE, imagen, opciones, opciones[0]));
            usuarios.add(new Usuarios(value1, value2, value3, value6, value4, value5));
            System.out.println(value1 + value2 + value3 + value4 + value5 + value6);

        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error! La cantidad tiene formato inválido",
                    "Sistema PetMarket", JOptionPane.WARNING_MESSAGE);

        }


    }

}
