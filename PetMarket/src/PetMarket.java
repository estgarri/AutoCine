

public class PetMarket
{
    static Login menuLogin = new Login();
    static InicializarInventario ini = new InicializarInventario();
    public static void main(String[] args)
    {
        ini.inicializar();
        menuLogin.terminarMenu();

    }

}
