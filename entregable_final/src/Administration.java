import javax.swing.*;
import java.awt.*;

public class Administration {


    public static void modificarUsuarios()
    {
        {
            ImageIcon image2 = new ImageIcon("Roles.png");

            ////////////////////////
            JTextField field1 = new JTextField();
            JTextField field2 = new JTextField();
            JTextField field3 = new JTextField();
            JTextField field4 = new JPasswordField();

            ///////////////////////////

            String nom, apell, correo;

            int value1 = 0, verify = 0;

            boolean listo = true, reg = true;

            String value2 = "1", value3 = "1", value4 = "1";

            if ( listo == true) {
                try {
                    value1 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de cédula del cliente: "));
                    for (int i = 0; i < Registro.usuarios.size(); i++) {
                        verify = Registro.usuarios.get(i).getCedula();
                        if (value1 == verify) {
                            reg= false;
                            nom = Registro.usuarios.get(i).getNombre();
                            apell = Registro.usuarios.get(i).getApellidos();
                            correo = Registro.usuarios.get(i).getPassword();
                            Object[] clientesCambio = new Object[]{
                                    "Nombre actual (" + nom + ")" + " Cambio de nombre: ", field2,
                                    "Apellidos actuales (" + apell + ")" + " Cambio de apellidos: ", field3,
                                    "Contraseña actual (" + correo + ")" + " Cambio de la contraseña: ", field4,
                            };

                            int option = JOptionPane.showConfirmDialog(null, clientesCambio, "Sistema TicoCargas - Registro de clientes",
                                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, image2);

                            if (option == JOptionPane.OK_OPTION) {
                                value2 = field2.getText();
                                value3 = field3.getText();
                                value4 = field4.getText();

                                int go = 0;

                                if (!value2.equals(""))
                                {
                                    Registro.usuarios.get(i).setNombre(value2);
                                    go = 1;
                                }

                                if (!value3.equals(""))
                                {
                                    Registro.usuarios.get(i).setApellidos(value3);
                                    go = 1;
                                }

                                if (!value4.equals(""))
                                {
                                    Registro.usuarios.get(i).setPassword(value4);
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
                                        "Sistema TicoCargas - Administración de cuentas", JOptionPane.WARNING_MESSAGE);
                                reg = false;
                            }

                        }
                    }

                } catch (HeadlessException | NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Error! Formato inválido para el número de cédula.",
                            "Sistema TicoCargas", JOptionPane.WARNING_MESSAGE);
                    listo = false;
                }
            }
            if (reg == true){
                JOptionPane.showMessageDialog(null, "Cliente no está registrado.");
                int option2 = JOptionPane.showConfirmDialog(null,"Cliente no está registrado, desea registrar al cliente?",
                        "Sistema TicoCargas - Resgistro", JOptionPane.YES_NO_OPTION);

                if (option2 == JOptionPane.YES_OPTION)
                {
                    Registro.nuevoRegistro();
                } else{
                    JOptionPane.showMessageDialog(null,"Exit, modificación de cuentas");
                }

            }

        }

    }

    public static void eliminarUsuario()
    {

    }
}
