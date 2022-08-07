import javax.swing.*;

public class Login {

    public static String user = "", pass = "";
    public static UserAdmin falcon = new UserAdmin();



    static Menu menu = new Menu();

    //static RoleMenu role = new RoleMenu();

    public void verification() {
        JTextField field1 = new JTextField();
        JTextField field2 = new JTextField();

        Object[] fields = {
                "Ingrese el usuario: ", field1,
                "Ingrese la contraseña: ", field2};

        ImageIcon image = new ImageIcon("ticoCargas.png");

        String value1 = "", value2 = "";


        int option = JOptionPane.showConfirmDialog(null, fields, "TicoCargas",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, image);
        JOptionPane.showMessageDialog(null, "Iniciando sesión", "TicoCargas", JOptionPane.INFORMATION_MESSAGE);


        value1 = field1.getText();
        value2 = field2.getText();

        user = falcon.getUserAdmin();
        pass = falcon.getPassAdmin();

        if (option == JOptionPane.OK_OPTION && value1.equals(user) && value2.equals(pass)) {
            JOptionPane.showMessageDialog(null, "Login successful.", "Sistema PetMarket", JOptionPane.INFORMATION_MESSAGE);
            menu.menu();
        } else {
            JOptionPane.showMessageDialog(null, "Login unSuccessful!!", "Sistema PetMarket", JOptionPane.WARNING_MESSAGE);

        }
    }

        public void terminarMenu ()
        {
            boolean seguir = true;
            String[] opciones = {"", "1. Login", "2. Shutdown TicoCargas system"};
            String msg = ("1. Login. \n" +
                    "2. Shutdown TicoCargas system. \n");
            ImageIcon imagen = new ImageIcon("ticoCargas.png");

            while (seguir) {
                String res = (String) JOptionPane.showInputDialog(null, msg, "Sistema TicoCargas",
                        JOptionPane.PLAIN_MESSAGE, imagen, opciones, opciones[0]);
                switch (res) {
                    case "1. Login":
                        System.out.println("Loading system....");
                        verification();
                        break;

                    case "2. Shutdown TicoCargas system":
                        System.out.println("Shutting down...");
                        seguir = false;
                        break;

                }
            }
        }

}