import javax.swing.*;
import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cart {

    public static ArrayList<ClienteCarrito> clientCarri = new ArrayList<>();

    public static ArrayList<Carrito> carrito = new ArrayList<>();
    static int inventario = 0;

    public static void addCartAl(String nombre, int cantidad)
    {

        int cant = cantidad, vamos = 0;
        boolean test = true;
        for (int i = 0; i < InicializarInventario.alimentos.size(); i++)
        {
            if (InicializarInventario.alimentos.get(i).getNombre().equals(nombre))
            {
                inventario = InicializarInventario.alimentos.get(i).getCantidad();
                if (cant > inventario)
                {
                    System.out.println("ERROR!!" + inventario);
                    JOptionPane.showMessageDialog(null, "Error!!, el inventario disponible es: " + inventario,
                            "Sistema TicoCargas", JOptionPane.WARNING_MESSAGE);
                    vamos = 1;
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
                        vamos = 1;
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
                vamos = 1;
                }
            }

        }
        if (vamos == 0)
        {
            JOptionPane.showMessageDialog(null, "Error! Nombre de producto.",
                    "Sistema TicoCargas", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void addCartAr(String nombre, int cantidad)
    {

        int cant = cantidad, vamos = 0;
        boolean test = true;
        for (int i = 0; i < InicializarInventario.articulos.size(); i++)
        {
            if (InicializarInventario.articulos.get(i).getNombre().equals(nombre))
            {
                inventario = InicializarInventario.articulos.get(i).getCantidad();
                if (cant > inventario)
                {
                    System.out.println("ERROR!!" + inventario);
                    JOptionPane.showMessageDialog(null, "Error!!, el inventario disponible es: " + inventario,
                            "Sistema TicoCargas", JOptionPane.WARNING_MESSAGE);
                    vamos = 1;
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
                            vamos = 1;
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
                        vamos = 1;
                    }
            }
        }
        if (vamos == 0)
        {
            JOptionPane.showMessageDialog(null, "Error! Nombre de producto.",
                    "Sistema TicoCargas", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void addCartMed(String nombre, int cantidad)
    {

        int cant = cantidad, vamos = 0;
        boolean test = true;
        for (int i = 0; i < InicializarInventario.medicamentos.size(); i++)
        {
            if (InicializarInventario.medicamentos.get(i).getNombre().equals(nombre))
            {
                inventario = InicializarInventario.medicamentos.get(i).getCantidad();
                if (cant > inventario)
                {
                    System.out.println("ERROR!!" + inventario);
                    JOptionPane.showMessageDialog(null, "Error!!, el inventario disponible es: " + inventario,
                            "Sistema TicoCargas", JOptionPane.WARNING_MESSAGE);
                    vamos = 1;
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
                            vamos = 1;
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
                    vamos = 1;
                }
            }
        }
        if (vamos == 0)
        {
            JOptionPane.showMessageDialog(null, "Error! Nombre de producto.",
                    "Sistema TicoCargas", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void addCartGra(String nombre, double cantidad)
    {

        double cant = cantidad, inventario, vamos = 0;
        boolean test = true;
        for (int i = 0; i < InicializarInventario.granel.size(); i++)
        {
            if (InicializarInventario.granel.get(i).getNombre().equals(nombre))
            {
                inventario = InicializarInventario.granel.get(i).getKilos();
                if (cant > inventario)
                {
                    System.out.println("ERROR!!" + inventario);
                    JOptionPane.showMessageDialog(null, "Error!!, el inventario disponible es: " + inventario + " kgs",
                            "Sistema TicoCargas", JOptionPane.WARNING_MESSAGE);
                    vamos = 1;
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
                            vamos = 1;
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
                            InicializarInventario.granel.get(i).getKilos() + " - " + precio);
                    vamos = 1;
                }
            }
        }
        if (vamos == 0)
        {
            JOptionPane.showMessageDialog(null, "Error! Nombre de producto.",
                    "Sistema TicoCargas", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void addClienteCarrito(String Nombre, String Apellidos,String correo, int Cedula)
    {
        System.out.println("Cliente: " + Nombre + " - " + Apellidos + " - " + correo + " - " + Cedula);
        clientCarri.add(new ClienteCarrito(Nombre,Apellidos, correo, Cedula));
    }

    public static int printCarrito()
    {
        DecimalFormat df = new DecimalFormat("0.00");
        String cadena = "", cliente = "", test= "";
        double subtotal2 = 0.0;

        cliente = ("\n" +
                "\n" +
                "\n" +
                "Información Cliente: \n" +
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
                String strtemp = carrito.get(i).getArticulos();
                test = (String) strtemp.subSequence(0,5);
                //cadena += (carrito.get(i).getArticulos() + "        " + carrito.get(i).getCantidad() + "            " + subtotal + "\n");
                cadena += (test + "          " + carrito.get(i).getCantidad() + "            " + df.format(subtotal) + "\n");
            }
            else {
                double cant = carrito.get(i).getKg();
                double subtotal = (precio * cant);
                subtotal2 += subtotal;
                cadena += (carrito.get(i).getArticulos() + "         " + carrito.get(i).getKg() + "             " + df.format(subtotal) + "\n");
            }
        }
        double iva = subtotal2 * 0.13;
        double total = subtotal2 + iva;
        String imprimir = ("__________________________________________\n" +
                "IVA Aplicado:                 " + df.format(iva) + "\n" +
                "Total facturado:              " + df.format(total) +
                "\n" + "\n");

        System.out.println(cliente + cadena + imprimir);

        String printing = cliente + cadena + imprimir;

        JOptionPane.showMessageDialog(null, printing,"Sistema TicoCargas - Carrito de compras", JOptionPane.WARNING_MESSAGE);

        int option = JOptionPane.showConfirmDialog(null,"Click yes for checkout or no to continue shopping. \n" + "\n" + printing,
                "Sistema PetMarket - Checkout", JOptionPane.YES_NO_OPTION);

        if (option == JOptionPane.YES_OPTION)
        {
            File file = new File("orders.txt");
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                try {
                    String st;
                    while ((st = br.readLine()) != null) {
                        System.out.println(st);
                        //JOptionPane.showMessageDialog(null,st);
                    }   } catch (IOException ex) {
                    Logger.getLogger(Cart.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Cart.class.getName()).log(Level.SEVERE, null, ex);
            }
            try (BufferedWriter cargas = new BufferedWriter(new FileWriter("orders.txt",true)))
            {

                cargas.write("\n" + printing);
                borrarCarrito();
                return 1;
            } catch (IOException ex) {
                Logger.getLogger(Cart.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0;

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
