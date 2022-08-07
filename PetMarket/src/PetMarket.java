

public class PetMarket
{
    static Login menuLogin = new Login();
    static InicializarInventario ini = new InicializarInventario();
    //static Registro registro = new Registro();
    public static void main(String[] args)
    {
        ini.inicializar();
        menuLogin.terminarMenu();
        //registro.regUsuario();
        //registro.ingresarUsuario();
        //registro.consultarRegistro();
        //menuLogin.verification();
    }

}
