import javax.swing.*;
import java.awt.*;

public class Ventas {

    public static String[] opciones = { "","1. Área de alimentos", "2. Área de artículos",
            "3. Área de medicamentos", "4. Área de graneles", "5. Carrito", "6. Salir"};

    public static String msg = ("1. Área de alimentos. \n" +
            "2. Área de artículos. \n" +
            "3. Área de medicamentos. \n" +
            "4. Área de graneles.\n" +
            "5. Carrito. \n" +
            "6. Salir.");



    static InicializarInventario inventario = new InicializarInventario();
    boolean seguir;


    public void venticas ()
    {
        System.out.println("Venticas");
        ImageIcon imagen = new ImageIcon("pet.png");
        seguir = true;


        while (seguir == true) {
            String res = (String) JOptionPane.showInputDialog(null, msg, "Sistema PetMarket - Venticas",
                    JOptionPane.PLAIN_MESSAGE, imagen, opciones, opciones[0]);
            if (res != null) {
                switch (res) {
                    case "1. Área de alimentos":
                        System.out.println("Área de alimentos");
                        areaAlimentos();

                        break;

                    case "2. Área de artículos":
                        System.out.println("Área de artículos");
                        areaArticulos();

                        break;

                    case "3. Área de medicamentos":
                        System.out.println("Área de medicamentos");
                        areaMedicamentos();

                        break;

                    case "4. Área de graneles":
                        System.out.println("Área de graneles");
                        areaGranel();

                        break;

                    case "5. Carrito":
                        System.out.println("Carrito - Venticas");
                        Cart.printCarrito();
                        break;

                    case "6. Salir":
                        System.out.println("Salir Venitcas");
                        int option = JOptionPane.showConfirmDialog(null,"Esta acción cancelará la orden, por favor confirme",
                                "Sistema PetMarket - Ventas", JOptionPane.YES_NO_OPTION);
                        if (option == JOptionPane.YES_OPTION) {
                            Cart.borrarCarrito();
                            seguir = false;
                        }
                        break;
                }
            } else {
                System.out.println("Cancel Venticas");
                JOptionPane.showMessageDialog(null, "Opción cancelada!!!", "Sistema PetMarket", JOptionPane.WARNING_MESSAGE);
                seguir = false;
            }
        }
    }

    public void areaAlimentos()
    {
        ImageIcon imagev = new ImageIcon("carrito.png");

        ////////////////////////
        JTextField field1 = new JTextField();
        JTextField field2 = new JTextField();

        ///////////////////////////

        int value1 = 0, verify = 0;
        String value2, value3, value4;
        boolean listo = true;

        ///////////////////////////

        Object[] ventas = {
                "Ingrese el nombre del producto: ", field2,
                "Ingrese la cantidad a comprar: ", field1
        };


        System.out.println("Área de alimentos - Ventas");
        //StringBuilder cadena = new StringBuilder();
        String cadena = "";

        for (int i = 0; i < inventario.alimentos.size(); i++) {
            //String codigoT = inventario.alimentos.get(i).getCodigo();
            String nombreT = inventario.alimentos.get(i).getNombre();
            String tipoT = inventario.alimentos.get(i).getTipoAnimal();
            double precioT = inventario.alimentos.get(i).getPrecio();
            int canT = inventario.alimentos.get(i).getCantidad();

            //cadena.append("Codigo: ").append(codigoT).append("     | Nombre: ").append(nombreT).append("     | Tipo: ").append(tipoT)
                    //.append("     | Precio: ").append(precioT).append("     | Cantidad: ").append(canT).append("\n");

            cadena += ("Nombre: " + nombreT + "     | Tipo: " + tipoT +
                    "     | Precio: " + precioT + "     | Cantidad en inventario: " + canT + "\n");

        }
        JOptionPane.showMessageDialog(null, cadena);

        boolean cont = true;
        //JOptionPane.showMessageDialog(null, "Se solicitarán los datos del usuario " + (i + 1));

        int option = JOptionPane.showConfirmDialog(null, ventas, "Sistema PetMarket - Agregar al carrito",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, imagev);

        if (option == JOptionPane.OK_OPTION) {
            value2 = field2.getText();

            try {
                value1 = Integer.parseInt(field1.getText());

            } catch (HeadlessException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error! Formato inválido para el número de cédula.",
                        "Sistema TicoCargas", JOptionPane.WARNING_MESSAGE);
                cont = false;
            }

            if (value1 == 0 || value2.equals("")) {
                JOptionPane.showMessageDialog(null, "Error! Información incompleta, por favor intente de nuevo.",
                        "Sistema TicoCargas", JOptionPane.WARNING_MESSAGE);
            } else {
                System.out.println(value2);
                Cart.addCartAl(value2, value1);
                }

            } else if (option == JOptionPane.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(null, "Regresando al menú de ventas!!!",
                    "Sistema PetMarket - Registro nuevo usuario", JOptionPane.WARNING_MESSAGE);
        }



        //Registro.registroCliente();


    }

    public void areaArticulos()
    {
        ImageIcon imagev = new ImageIcon("carrito.png");

        ////////////////////////
        JTextField field1 = new JTextField();
        JTextField field2 = new JTextField();

        ///////////////////////////

        int value1 = 0, verify = 0;
        String value2, value3, value4;
        boolean listo = true;

        ///////////////////////////

        Object[] ventas = {
                "Ingrese el nombre del producto: ", field2,
                "Ingrese la cantidad a comprar: ", field1
        };


        System.out.println("Área de alimentos - Ventas");
        //StringBuilder cadena = new StringBuilder();
        String cadena = "";

        for (int i = 0; i < inventario.articulos.size(); i++) {
            //String codigoT = inventario.alimentos.get(i).getCodigo();
            String nombreT = inventario.articulos.get(i).getNombre();
            String tipoT = inventario.articulos.get(i).getTipoAnimal();
            double precioT = inventario.articulos.get(i).getPrecio();
            int canT = inventario.articulos.get(i).getCantidad();

            //cadena.append("Codigo: ").append(codigoT).append("     | Nombre: ").append(nombreT).append("     | Tipo: ").append(tipoT)
            //.append("     | Precio: ").append(precioT).append("     | Cantidad: ").append(canT).append("\n");

            cadena += ("Nombre: " + nombreT + "     | Tipo: " + tipoT +
                    "     | Precio: " + precioT + "     | Cantidad en inventario: " + canT + "\n");

        }
        JOptionPane.showMessageDialog(null, cadena);

        boolean cont = true;
        //JOptionPane.showMessageDialog(null, "Se solicitarán los datos del usuario " + (i + 1));

        int option = JOptionPane.showConfirmDialog(null, ventas, "Sistema PetMarket - Agregar al carrito",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, imagev);

        if (option == JOptionPane.OK_OPTION) {
            value2 = field2.getText();

            try {
                value1 = Integer.parseInt(field1.getText());

            } catch (HeadlessException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error! Formato inválido.",
                        "Sistema TicoCargas", JOptionPane.WARNING_MESSAGE);
                cont = false;
            }

            if (value1 == 0 || value2.equals("") && cont == true) {
                JOptionPane.showMessageDialog(null, "Error! Información incompleta, por favor intente de nuevo.",
                        "Sistema TicoCargas", JOptionPane.WARNING_MESSAGE);
            } else {
                System.out.println(value2);
                Cart.addCartAr(value2, value1);
            }

        } else if (option == JOptionPane.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(null, "Regresando al menú de ventas!!!",
                    "Sistema PetMarket - Registro nuevo usuario", JOptionPane.WARNING_MESSAGE);
        }



        //Registro.registroCliente();


    }
    public void areaMedicamentos()
    {
        ImageIcon imagev = new ImageIcon("carrito.png");

        ////////////////////////
        JTextField field1 = new JTextField();
        JTextField field2 = new JTextField();

        ///////////////////////////

        int value1 = 0, verify = 0;
        String value2, value3, value4;
        boolean listo = true;

        ///////////////////////////

        Object[] ventas = {
                "Ingrese el nombre del producto: ", field2,
                "Ingrese la cantidad a comprar: ", field1
        };


        System.out.println("Área de medicamentos - Ventas");
        //StringBuilder cadena = new StringBuilder();
        String cadena = "";

        for (int i = 0; i < inventario.medicamentos.size(); i++) {
            //String codigoT = inventario.alimentos.get(i).getCodigo();
            String nombreT = inventario.medicamentos.get(i).getNombre();
            String tipoT = inventario.medicamentos.get(i).getTipoAnimal();
            double precioT = inventario.medicamentos.get(i).getPrecio();
            int canT = inventario.medicamentos.get(i).getCantidad();

            //cadena.append("Codigo: ").append(codigoT).append("     | Nombre: ").append(nombreT).append("     | Tipo: ").append(tipoT)
            //.append("     | Precio: ").append(precioT).append("     | Cantidad: ").append(canT).append("\n");

            cadena += ("Nombre: " + nombreT + "     | Tipo: " + tipoT +
                    "     | Precio: " + precioT + "     | Cantidad en inventario: " + canT + "\n");

        }
        JOptionPane.showMessageDialog(null, cadena);

        boolean cont = true;
        //JOptionPane.showMessageDialog(null, "Se solicitarán los datos del usuario " + (i + 1));

        int option = JOptionPane.showConfirmDialog(null, ventas, "Sistema PetMarket - Agregar al carrito",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, imagev);

        if (option == JOptionPane.OK_OPTION) {
            value2 = field2.getText();

            try {
                value1 = Integer.parseInt(field1.getText());

            } catch (HeadlessException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error! Formato inválido.",
                        "Sistema TicoCargas", JOptionPane.WARNING_MESSAGE);
                cont = false;
            }

            if (value1 == 0 || value2.equals("") && cont == true) {
                JOptionPane.showMessageDialog(null, "Error! Información incompleta, por favor intente de nuevo.",
                        "Sistema TicoCargas", JOptionPane.WARNING_MESSAGE);
            } else {
                System.out.println(value2);
                Cart.addCartMed(value2, value1);
            }

        } else if (option == JOptionPane.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(null, "Regresando al menú de ventas!!!",
                    "Sistema PetMarket - Registro nuevo usuario", JOptionPane.WARNING_MESSAGE);
        }



        //Registro.registroCliente();


    }

    public void areaGranel()
    {
        ImageIcon imagev = new ImageIcon("carrito.png");

        ////////////////////////
        JTextField field1 = new JTextField();
        JTextField field2 = new JTextField();

        ///////////////////////////

        double value1 = 0.0;
        String value2;
        boolean listo = true;

        ///////////////////////////

        Object[] ventas = {
                "Ingrese el nombre del producto: ", field2,
                "Ingrese la cantidad a comprar: ", field1
        };


        System.out.println("Área de medicamentos - Ventas");
        //StringBuilder cadena = new StringBuilder();
        String cadena = "";

        for (int i = 0; i < inventario.granel.size(); i++) {
            //String codigoT = inventario.alimentos.get(i).getCodigo();
            String nombreT = inventario.granel.get(i).getNombre();
            String tipoT = inventario.granel.get(i).getTipoAnimal();
            double precioT = inventario.granel.get(i).getPrecio();
            double canT = inventario.granel.get(i).getKilos();

            //cadena.append("Codigo: ").append(codigoT).append("     | Nombre: ").append(nombreT).append("     | Tipo: ").append(tipoT)
            //.append("     | Precio: ").append(precioT).append("     | Cantidad: ").append(canT).append("\n");

            cadena += ("Nombre: " + nombreT + "     | Tipo: " + tipoT +
                    "     | Precio: " + precioT + "     | Cantidad en inventario: " + canT + "\n");

        }
        JOptionPane.showMessageDialog(null, cadena);

        boolean cont = true;
        //JOptionPane.showMessageDialog(null, "Se solicitarán los datos del usuario " + (i + 1));

        int option = JOptionPane.showConfirmDialog(null, ventas, "Sistema PetMarket - Agregar al carrito",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, imagev);

        if (option == JOptionPane.OK_OPTION) {
            value2 = field2.getText();

            try {
                value1 = Double.parseDouble(field1.getText());

            } catch (HeadlessException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error! Formato inválido.",
                        "Sistema TicoCargas", JOptionPane.WARNING_MESSAGE);
                cont = false;
            }

            if (value1 == 0 || value2.equals("") && cont == true) {
                JOptionPane.showMessageDialog(null, "Error! Información incompleta, por favor intente de nuevo.",
                        "Sistema TicoCargas", JOptionPane.WARNING_MESSAGE);
            } else {
                System.out.println(value2);
                Cart.addCartGra(value2, value1);
            }

        } else if (option == JOptionPane.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(null, "Regresando al menú de ventas!!!",
                    "Sistema PetMarket - Registro nuevo usuario", JOptionPane.WARNING_MESSAGE);
        }



        //Registro.registroCliente();


    }

}
