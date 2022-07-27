import javax.swing.*;

public class Login
{
    public static String user = "", pass = "";
    public static UsuarioAdmin falcon = new UsuarioAdmin();
    static Registro falcon2 = new Registro();


    static Menu menu = new Menu();

    //static RoleMenu role = new RoleMenu();

    public void verification()
    {
        JOptionPane.showMessageDialog(null,"Iniciar sesión","Sistema PetMarket",JOptionPane.INFORMATION_MESSAGE);
        String Dato1 = JOptionPane.showInputDialog(null,"Ingrese el usuario","Sistema PetMarket",JOptionPane.INFORMATION_MESSAGE);
        String Dato2 = JOptionPane.showInputDialog(null,"Ingrese la contraseña","Sistema PetMarket",JOptionPane.INFORMATION_MESSAGE);

        user = falcon.getUserAdmin();
        pass = falcon.getPassAdmin();

        if (Dato1.equals(user) && Dato2.equals(pass))
        {
            JOptionPane.showMessageDialog(null, "Login successful.", "Sistema PetMarket", JOptionPane.INFORMATION_MESSAGE);
            menu.menu();
        }
        else
        {
            //pass = falcon2.getPassword(Dato1);
            pass = falcon2.buscarPWD(Dato1,Dato2);
            if (pass.equals("existe"))
            {
                JOptionPane.showMessageDialog(null, "Login successful!!", "Sistema PetMarket", JOptionPane.WARNING_MESSAGE);
                 //role.Role(Dato1);
                 falcon2.getRol(Dato1);
            }
            else {
                JOptionPane.showMessageDialog(null, "Login unSuccessful!!", "Sistema PetMarket", JOptionPane.INFORMATION_MESSAGE);
            }
            //JOptionPane.showMessageDialog(null, "Login unsuccessful!!", "Sistema PetMarket", JOptionPane.WARNING_MESSAGE);
        }

    }

    public void terminarMenu()
    {
       boolean seguir = true;
       String[] opciones = { "","1. Login", "2. Shutdown Pet's Market system"};
       String msg = ("1. Login. \n" +
                "2. Shutdown Pet's Market system. \n");
       ImageIcon imagen = new ImageIcon("pet.png");

       while (seguir) {
           String res = (String) JOptionPane.showInputDialog(null, msg, "Sistema PetMarket",
                   JOptionPane.PLAIN_MESSAGE, imagen, opciones, opciones[0]);
           switch (res) {
               case "1. Login":
                   System.out.println("Loading system....");
                   verification();
                   break;

               case "2. Shutdown Pet's Market system":
                   System.out.println("Shutting down...");
                   seguir = false;
                   break;

           }
       }
    }
}
