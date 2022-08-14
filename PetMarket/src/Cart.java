import java.util.ArrayList;

public class Cart {

    public static ArrayList<ClienteCarrito> clientCarri = new ArrayList<>();

    public static ArrayList<Carrito> carrito = new ArrayList<>();
    static int inventario = 0;

    public static void addCartAl(String nombre, int cantidad)
    {

        int cant = cantidad;
        for (int i = 0; i < InicializarInventario.alimentos.size(); i++)
        {
            if (InicializarInventario.alimentos.get(i).getNombre().equals(nombre))
            {
                inventario = InicializarInventario.alimentos.get(i).getCantidad();
                if (cant > inventario)
                {
                    System.out.println("ERROR!!" + inventario);
                }
                else{
                    System.out.println("Existe!!" + inventario);

                    inventario -= cant;

                    InicializarInventario.alimentos.get(i).setCantidad(inventario);

                    String articulos = InicializarInventario.alimentos.get(i).getNombre();

                    carrito.add(new Carrito(articulos, cant));

                    System.out.println("Carrito - " + articulos + " - " + cant + " - " +
                            InicializarInventario.alimentos.get(i).getCantidad());
                }
            }


        }
    }

    public static void addClienteCarrito(String Nombre, String Apellidos,String correo, int Cedula)
    {
        System.out.println("Cliente: " + Nombre + " - " + Apellidos + " - " + correo + " - " + Cedula);
        clientCarri.add(new ClienteCarrito(Nombre,Apellidos, correo, Cedula));
    }

    public static void printCarrito()
    {
        String cadena = "", cliente = "";

        cliente = ("Información Cliente: \n" +
                "___________________________ \n" +
                "Nombre Cliente: " + clientCarri.get(0).getNombre() + " " + clientCarri.get(0).getApellidos() + "\n" +
                "Cedula: " + clientCarri.get(0).getCedula() + "\n" +
                "Correo electrónico: " + clientCarri.get(0).getEmail());

        System.out.println(cliente);


    }
}
