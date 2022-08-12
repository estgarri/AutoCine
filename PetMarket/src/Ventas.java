import javax.swing.*;

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


                        break;

                    case "3. Área de medicamentos":
                        System.out.println("Área de medicamentos");

                        break;

                    case "4. Área de graneles":
                        System.out.println("Área de graneles");

                        break;

                    case "5. Carrito":
                        System.out.println("Carrito - Venticas");

                        break;

                    case "6. Salir":
                        System.out.println("Salir Venitcas");
                        seguir = false;
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
        System.out.println("Área de alimentos - Ventas");
        StringBuilder cadena = new StringBuilder();

        for (int i = 0; i < inventario.alimentos.size(); i++) {
            String codigoT = inventario.alimentos.get(i).getCodigo();
            String nombreT = inventario.alimentos.get(i).getNombre();
            String tipoT = inventario.alimentos.get(i).getTipoAnimal();
            double precioT = inventario.alimentos.get(i).getPrecio();
            int canT = inventario.alimentos.get(i).getCantidad();

            cadena.append("Codigo: ").append(codigoT).append("     | Nombre: ").append(nombreT).append("     | Tipo: ").append(tipoT)
                    .append("     | Precio: ").append(precioT).append("     | Cantidad: ").append(canT).append("\n");

            /* cadena += ("Codigo: " + codigoT + "     | Nombre: " + nombreT + "     | Tipo: " + tipoT +
                                    "     | Precio: " + precioT + "     | Cantidad: " + canT + "\n"); */

        }
        JOptionPane.showMessageDialog(null, cadena.toString());

        Registro.registroCliente();


    }

}
