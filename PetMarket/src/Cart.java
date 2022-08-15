import java.util.ArrayList;

public class Cart {

    public static ArrayList<ClienteCarrito> clientCarri = new ArrayList<>();

    public static ArrayList<Carrito> carrito = new ArrayList<>();
    static int inventario = 0;

    public static void addCartAl(String nombre, int cantidad)
    {

        int cant = cantidad;
        boolean test = true;
        for (int i = 0; i < InicializarInventario.alimentos.size(); i++)
        {
            if (InicializarInventario.alimentos.get(i).getNombre().equals(nombre))
            {
                inventario = InicializarInventario.alimentos.get(i).getCantidad();
                if (cant > inventario)
                {
                    System.out.println("ERROR!!" + inventario);
                    test = false;
                }
                else{
                    System.out.println("Existe!!" + inventario);
                    for (Carrito value : carrito) {
                        if (value.getArticulos().equals(nombre)) {
                        int temp = value.getCantidad();
                        temp += cant;
                        value.setCantidad(temp);
                        inventario -= cant;
                        InicializarInventario.alimentos.get(i).setCantidad(inventario);
                        test = false;
                    }
                }
            }


                if (test == true)
                {
                inventario -= cant;

                InicializarInventario.alimentos.get(i).setCantidad(inventario);

                String articulos = InicializarInventario.alimentos.get(i).getNombre();

                double precio = InicializarInventario.alimentos.get(i).getPrecio();

                double kg = 0.0;
                carrito.add(new Carrito(articulos, cant, precio, kg));
                System.out.println("Carrito - " + articulos + " - " + cant + " - " +
                        InicializarInventario.alimentos.get(i).getCantidad() + " - " + precio);
                }
            }

        }
    }

    public static void addCartAr(String nombre, int cantidad)
    {

        int cant = cantidad;
        boolean test = true;
        for (int i = 0; i < InicializarInventario.articulos.size(); i++)
        {
            if (InicializarInventario.articulos.get(i).getNombre().equals(nombre))
            {
                inventario = InicializarInventario.articulos.get(i).getCantidad();
                if (cant > inventario)
                {
                    System.out.println("ERROR!!" + inventario);
                    test = false;
                }
                else {
                    System.out.println("Existe!!" + inventario);
                    for (Carrito value : carrito) {
                        if (value.getArticulos().equals(nombre)) {
                            int temp = value.getCantidad();
                            temp += cant;
                            value.setCantidad(temp);
                            inventario -= cant;
                            InicializarInventario.articulos.get(i).setCantidad(inventario);
                            test = false;
                        }
                    }
                }



                    if (test == true)
                    {
                        inventario -= cant;

                        InicializarInventario.articulos.get(i).setCantidad(inventario);

                        String articulos = InicializarInventario.articulos.get(i).getNombre();

                        double precio = InicializarInventario.articulos.get(i).getPrecio();

                        double kg = 0.0;

                        carrito.add(new Carrito(articulos, cant, precio, kg));
                        System.out.println("Carrito - " + articulos + " - " + cant + " - " +
                                InicializarInventario.articulos.get(i).getCantidad() + " - " + precio);
                    }
            }
        }
    }

    public static void addCartMed(String nombre, int cantidad)
    {

        int cant = cantidad;
        boolean test = true;
        for (int i = 0; i < InicializarInventario.medicamentos.size(); i++)
        {
            if (InicializarInventario.medicamentos.get(i).getNombre().equals(nombre))
            {
                inventario = InicializarInventario.medicamentos.get(i).getCantidad();
                if (cant > inventario)
                {
                    System.out.println("ERROR!!" + inventario);
                    test = false;
                }
                else {
                    System.out.println("Existe!!" + inventario);
                    for (Carrito value : carrito) {
                        if (value.getArticulos().equals(nombre)) {
                            int temp = value.getCantidad();
                            temp += cant;
                            value.setCantidad(temp);
                            inventario -= cant;
                            InicializarInventario.medicamentos.get(i).setCantidad(inventario);
                            test = false;
                        }
                    }
                }



                if (test == true)
                {
                    inventario -= cant;

                    InicializarInventario.medicamentos.get(i).setCantidad(inventario);

                    String articulos = InicializarInventario.medicamentos.get(i).getNombre();

                    double precio = InicializarInventario.medicamentos.get(i).getPrecio();

                    double kg = 0.0;

                    carrito.add(new Carrito(articulos, cant, precio, kg));
                    System.out.println("Carrito - " + articulos + " - " + cant + " - " +
                            InicializarInventario.medicamentos.get(i).getCantidad() + " - " + precio);
                }
            }
        }
    }

    public static void addCartGra(String nombre, double cantidad)
    {

        double cant = cantidad, inventario;
        boolean test = true;
        for (int i = 0; i < InicializarInventario.granel.size(); i++)
        {
            if (InicializarInventario.granel.get(i).getNombre().equals(nombre))
            {
                inventario = InicializarInventario.granel.get(i).getKilos();
                if (cant > inventario)
                {
                    System.out.println("ERROR!!" + inventario);
                    test = false;
                }
                else {
                    System.out.println("Existe!!" + inventario);
                    for (Carrito value : carrito) {
                        if (value.getArticulos().equals(nombre)) {
                            double temp = value.getKg();
                            temp += cant;
                            value.setKg(temp);
                            inventario -= cant;
                            InicializarInventario.granel.get(i).setKilos(inventario);
                            test = false;
                        }
                    }
                }



                if (test == true)
                {
                    inventario -= cant;

                    InicializarInventario.granel.get(i).setKilos(inventario);

                    String articulos = InicializarInventario.granel.get(i).getNombre();

                    double precio = InicializarInventario.granel.get(i).getPrecio();

                    int testy =0;

                    carrito.add(new Carrito(articulos, testy, precio, cant));
                    System.out.println("Carrito - " + articulos + " - " + cant + " - " +
                            InicializarInventario.medicamentos.get(i).getCantidad() + " - " + precio);
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
        double subtotal2 = 0.0;

        cliente = ("Información Cliente: \n" +
                "__________________________________ \n" +
                "Nombre Cliente: " + clientCarri.get(0).getNombre() + " " + clientCarri.get(0).getApellidos() + "\n" +
                "Cedula: " + clientCarri.get(0).getCedula() + "\n" +
                "Correo electrónico: " + clientCarri.get(0).getEmail() + "\n" + "\n" + "\n" +
                "Compra Realizada \n" +
                "__________________________________ \n" +
                "Articulo      Cantidad      Subtotal \n");
        
        for (int i = 0; i < carrito.size(); i++)
        {
            double precio = carrito.get(i).getPrecio();
            if (carrito.get(i).getKg() == 0.0) {
                double cant = carrito.get(i).getCantidad();
                double subtotal = (precio * cant);
                subtotal2 += subtotal;
                cadena += (carrito.get(i).getArticulos() + "        " + carrito.get(i).getCantidad() + "            " + subtotal + "\n");
            }
            else {
                double cant = carrito.get(i).getKg();
                double subtotal = (precio * cant);
                subtotal2 += subtotal;
                cadena += (carrito.get(i).getArticulos() + "        " + carrito.get(i).getKg() + "            " + subtotal + "\n");
            }
        }
        double iva = subtotal2 * 0.13;
        double total = subtotal2 + iva;
        String imprimir = ("IVA Aplicado:                 " + iva + "\n" +
                "Total facturado:              " + total);

        System.out.println(cliente + cadena + imprimir);

    }

    public static void borrarCarrito()
    {
        carrito.clear();
        clientCarri.clear();
        if (carrito.isEmpty() || clientCarri.isEmpty())
        {
            System.out.println("Barrido!! - NADA!!");
        }
    }
}
