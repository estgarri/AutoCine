import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class InicializarInventario {


    public static ArrayList<Alimentos> alimentos = new ArrayList<>();

    public static ArrayList<Articulos> articulos = new ArrayList<>();

    public static ArrayList<Medicamentos> medicamentos = new ArrayList<>();

    public static ArrayList<Granel> granel = new ArrayList<>();

    public static boolean seguir = true;

    static int j = 0, addAl = 0;


    public static String[] opciones = { "","1. Consultas", "2. Actualizar Inventario (agregar)",
            "3. Actualizar Inventario (restar)", "4. Producto nuevo", "5. Salir"};

    public static String msg = ("1. Consultas. \n" +
            "2. Actualizar Inventario (agregar). \n" +
            "3. Actualizar Inventario (restar). \n" +
            "4. Producto nuevo. \n" +
            "5. Salir");

    public void inicializar()
    {
        String cadena = "";
        alimentos.add(new Alimentos("AL-COD-1" , "Cat_Food", "Felino", 1.25,5));
        alimentos.add(new Alimentos("AL-COD-2", "Dog_Food", "Canino", 2.50,5));
        alimentos.add(new Alimentos("AL-COD-3", "Bird_Food", "Aviario", 1.15,5));
        alimentos.add(new Alimentos("AL-COD-4", "Horse_Food", "Equino", 10.35,5));
        alimentos.add(new Alimentos("AL-COD-5", "COW_Food", "Bovino", 15.00,5));

        articulos.add(new Articulos("AR-COD-1", "Ratón de hule", "Felino", 4.25,5));
        articulos.add(new Articulos("AR-COD-2", "Bolita", "Canino", 4.50,5));
        articulos.add(new Articulos("AR-COD-3", "Bañera", "Aviario", 10.25,5));
        articulos.add(new Articulos("AR-COD-4", "Cepillo", "Equino", 15.50,5));
        articulos.add(new Articulos("AR-COD-5", "Campana", "Bovino", 25.00,5));

        medicamentos.add(new Medicamentos("MED-COD-1", "Gato con botas", "Felino", 3.35,5));
        medicamentos.add(new Medicamentos("MED-COD-2", "Dug", "Canino", 3.50,5));
        medicamentos.add(new Medicamentos("MED-COD-3", "Tweety", "Aviario", 3.25,5));
        medicamentos.add(new Medicamentos("MED-COD-4", "Seabiscuit", "Equino", 3.50,5));
        medicamentos.add(new Medicamentos("MED-COD-5", "Ferdinand", "Bovino", 12.25,5));

        granel.add(new Granel("GRA-COD-1", "Churu", "Felino", 13.35,5.0));
        granel.add(new Granel("GRA-COD-2", "Purina", "Canino", 13.50,5.0));
        granel.add(new Granel("GRA-COD-3", "Parakeet", "Aviario", 13.25,5.0));
        granel.add(new Granel("GRA-COD-4", "Royal Horse", "Equino", 23.50,5.0));
        granel.add(new Granel("GRA-COD-5", "Dieta Delta", "Bovino", 32.25,5.0));

        for (int i = 0; i < alimentos.size(); i++ )
        {
            String codigoT = alimentos.get(i).getCodigo();
            String nombreT = alimentos.get(i).getNombre();
            String tipoT = alimentos.get(i).getTipoAnimal();
            double precioT = alimentos.get(i).getPrecio();
            int canT = alimentos.get(i).getCantidad();

            cadena += ("Codigo: " + codigoT + "     | Nombre: " + nombreT + "     | Tipo: " + tipoT + "     | Precio: " + precioT + "     | Cantidad: " + canT + "\n");

        }
        //JOptionPane.showMessageDialog(null, cadena);
        System.out.println(cadena);
    }

    public void inventarioMenu()
    {
        System.out.println("Hello World - Inventario");
        ImageIcon imagen = new ImageIcon("pet.png");
        seguir = true;

        while (seguir == true) {
            String res = (String) JOptionPane.showInputDialog(null, msg, "Sistema PetMarket - Menú de Inventario",
                    JOptionPane.PLAIN_MESSAGE, imagen, opciones, opciones[0]);
            switch (res) {
                case "1. Consultas":
                    System.out.println("Consultas");
                    consultasInventario();
                    seguir = true;

                    break;

                case "2. Actualizar Inventario (agregar)":
                    System.out.println("Actualizar Inventario (agregar)");
                    agregarInventario();
                    seguir = true;
                    break;

                case "3. Actualizar Inventario (restar)":
                    System.out.println("Actualizar Inventario (restar)");
                    restarInventario();
                    seguir = true;
                    break;

                case "4. Producto nuevo":
                    System.out.println("Producto nuevo");
                    agregarProducto();
                    seguir = true;
                    break;


                case "5. Salir":
                    System.out.println("Salir Inventario");
                    seguir = false;
                    break;
            }

        }
    }

    public void consultasInventario()
    {
        String[] consultas = { "","1. Alimentos", "2. Artículos",
                "3. Medicamentos", "4. Granel", "5. Salir"};

        String msgC = ("1. Alimentos. \n" +
                "2. Artículos. \n" +
                "3. Medicamentos. \n" +
                "4. Granel. \n" +
                "5. Salir.\n");

        ImageIcon imagenC = new ImageIcon("pet.png");
        seguir = true;

        while (seguir == true) {
            String res = (String) JOptionPane.showInputDialog(null, msgC, "Sistema PetMarket - Consultas del Inventario",
                    JOptionPane.PLAIN_MESSAGE, imagenC, consultas, consultas[0]);
            String cadena = "";

            switch (res) {
                case "1. Alimentos":
                    System.out.println("Alimentos");
                    for (int i = 0; i < alimentos.size(); i++ )
                    {
                        String codigoT = alimentos.get(i).getCodigo();
                        String nombreT = alimentos.get(i).getNombre();
                        String tipoT = alimentos.get(i).getTipoAnimal();
                        double precioT = alimentos.get(i).getPrecio();
                        int canT = alimentos.get(i).getCantidad();

                        cadena += ("Codigo: " + codigoT + "     | Nombre: " + nombreT + "     | Tipo: " + tipoT +
                                "     | Precio: " + precioT + "     | Cantidad: " + canT + "\n");

                    }
                    JOptionPane.showMessageDialog(null, cadena);
                    break;

                case "2. Artículos":
                    System.out.println("Artículos");
                    for (int i = 0; i < articulos.size(); i++ )
                    {
                        String codigoT = articulos.get(i).getCodigo();
                        String nombreT = articulos.get(i).getNombre();
                        String tipoT = articulos.get(i).getTipoAnimal();
                        double precioT = articulos.get(i).getPrecio();
                        int canT = articulos.get(i).getCantidad();

                        cadena += ("Codigo: " + codigoT + "     | Nombre: " + nombreT + "     | Tipo: " + tipoT +
                                "     | Precio: " + precioT + "     | Cantidad: " + canT + "\n");

                    }
                    JOptionPane.showMessageDialog(null, cadena);
                    break;

                case "3. Medicamentos":
                    System.out.println("Medicamentos");
                    for (int i = 0; i < medicamentos.size(); i++ )
                    {
                        String codigoT = medicamentos.get(i).getCodigo();
                        String nombreT = medicamentos.get(i).getNombre();
                        String tipoT = medicamentos.get(i).getTipoAnimal();
                        double precioT = medicamentos.get(i).getPrecio();
                        int canT = medicamentos.get(i).getCantidad();

                        cadena += ("Codigo: " + codigoT + "     | Nombre: " + nombreT + "     | Tipo: " + tipoT +
                                "     | Precio: " + precioT + "     | Cantidad: " + canT + "\n");

                    }
                    JOptionPane.showMessageDialog(null, cadena);
                    break;

                case "4. Granel":
                    System.out.println("Granel");
                    for (int i = 0; i < granel.size(); i++ )
                    {
                        String codigoT = granel.get(i).getCodigo();
                        String nombreT = granel.get(i).getNombre();
                        String tipoT = granel.get(i).getTipoAnimal();
                        double precioT = granel.get(i).getPrecio();
                        double canT = granel.get(i).getKilos();

                        cadena += ("Codigo: " + codigoT + "     | Nombre: " + nombreT + "     | Tipo: " + tipoT +
                                "     | Precio: " + precioT + "     | Cantidad: " + canT + " kgs\n");

                    }
                    JOptionPane.showMessageDialog(null, cadena);
                    break;


                case "5. Salir":
                    System.out.println("Salir Consultas");
                    seguir = false;
                    break;
            }

        }
    }
    public void agregarInventario()
    {
        String[] consultas = { "","1. Alimentos", "2. Artículos",
                "3. Medicamentos", "4. Granel", "5. Salir"};

        String msgC = ("1. Alimentos. \n" +
                "2. Artículos. \n" +
                "3. Medicamentos. \n" +
                "4. Granel. \n" +
                "5. Salir.\n");

        ImageIcon imagenC = new ImageIcon("pet.png");
        boolean seguir = true, seguir2 = true;


        while (seguir == true) {
            String res = (String) JOptionPane.showInputDialog(null, msgC, "Sistema PetMarket - Agregar al Inventario",
                    JOptionPane.PLAIN_MESSAGE, imagenC, consultas, consultas[0]);

            switch (res) {
                case "1. Alimentos":
                    j = 0;
                    addAl = 0;
                    String codigoAl;

                    codigoAl = JOptionPane.showInputDialog("Digite el código de artículo para agregar inventario: ");
                    for (int i = 0; i < alimentos.size(); i++) {
                        String looking = alimentos.get(i).getCodigo();
                        if (looking.equals(codigoAl)) {
                            j = i;
                            break;
                        } else {
                            j = i + 100;
                        }
                    }
                    if ( j > alimentos.size())
                    {
                        JOptionPane.showMessageDialog(null, "Código inválido!!", null, JOptionPane.WARNING_MESSAGE);
                        break;
                    }


                    while (true) {
                        try {
                            addAl = Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad de artículos a agregar a " + codigoAl + ": "));
                            if (addAl > 0)
                            {
                                break;
                            }
                            else {
                                JOptionPane.showMessageDialog(null, "Número no puede ser negativo!", null, JOptionPane.WARNING_MESSAGE);
                            }
                            //break;
                        } catch (HeadlessException | NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Error!", null, JOptionPane.WARNING_MESSAGE);
                        }

                    }
                    int canTN = alimentos.get(j).getCantidad();
                    addAl += canTN;
                    alimentos.get(j).setCantidad(addAl);
                    String Alcod = alimentos.get(j).getCodigo();
                    String Alname = alimentos.get(j).getNombre();
                    int Alcant = alimentos.get(j).getCantidad();
                    JOptionPane.showMessageDialog(null, "El nuevo inventario de '" + Alcod + " " + Alname + "' es de: " + Alcant);

                    break;



//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                case "2. Artículos":
                    System.out.println("Artículos");
                    j = 0;
                    addAl = 0;
                    String codigoAr;

                    codigoAr = JOptionPane.showInputDialog("Digite el código de artículo para agregar inventario: ");
                    for (int i = 0; i < articulos.size(); i++)
                    {
                        String looking = articulos.get(i).getCodigo();
                        if (looking.equals(codigoAr)) {
                            j = i;
                            break;
                    } else
                    {
                    j = i + 100;
                    }
                    }
            if ( j > alimentos.size())
            {
                JOptionPane.showMessageDialog(null, "Código inválido!!", null, JOptionPane.WARNING_MESSAGE);
                break;
            }

                    while (true) {
                        try {
                            addAl = Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad de artículos a agregar a " + codigoAr + ": "));
                            if (addAl > 0)
                            {
                                break;
                            }
                            else {
                                JOptionPane.showMessageDialog(null, "Número no puede ser negativo!", null, JOptionPane.WARNING_MESSAGE);
                            }
                            //break;
                        } catch (HeadlessException | NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Error!", null, JOptionPane.WARNING_MESSAGE);
                        }

                    }
                    int canAr = alimentos.get(j).getCantidad();
                    addAl += canAr;
                    articulos.get(j).setCantidad(addAl);
                    String Arcod = articulos.get(j).getCodigo();
                    String Arname = articulos.get(j).getNombre();
                    int Arcant = articulos.get(j).getCantidad();
                    JOptionPane.showMessageDialog(null, "El nuevo inventario de '" + Arcod + " " + Arname + "' es de: " + Arcant);

                    break;

 /////////////////////////////////////////////////////////////////////////////////////

                case "3. Medicamentos":
                    System.out.println("Medicamentos");
                    j = 0;
                    addAl = 0;
                    String codigoM;

                    codigoM = JOptionPane.showInputDialog("Digite el código de artículo para agregar inventario: ");
                    for (int i = 0; i < medicamentos.size(); i++)
                    {
                        String looking = medicamentos.get(i).getCodigo();
                        if (looking.equals(codigoM)) {
                            j = i;
                            break;
                        } else
                        {
                            j = i + 100;
                        }
                    }
                    if ( j > medicamentos.size())
                    {
                        JOptionPane.showMessageDialog(null, "Código inválido!!", null, JOptionPane.WARNING_MESSAGE);
                        break;
                    }

                    while (true) {
                        try {
                            addAl = Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad de artículos a agregar a " + codigoM + ": "));
                            if (addAl > 0)
                            {
                                break;
                            }
                            else {
                                JOptionPane.showMessageDialog(null, "Número no puede ser negativo!", null, JOptionPane.WARNING_MESSAGE);
                            }
                            //break;
                        } catch (HeadlessException | NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Error!", null, JOptionPane.WARNING_MESSAGE);
                        }

                    }
                    int canM = medicamentos.get(j).getCantidad();
                    addAl += canM;
                    medicamentos.get(j).setCantidad(addAl);
                    String Mcod = medicamentos.get(j).getCodigo();
                    String Mname = medicamentos.get(j).getNombre();
                    int Mcant = medicamentos.get(j).getCantidad();
                    JOptionPane.showMessageDialog(null, "El nuevo inventario de '" + Mcod + " " + Mname + "' es de: " + Mcant);

                    break;


////////////////////////////////////////////////////////////////////////////////////////////

                case "4. Granel":
                    System.out.println("Granel");
                    j = 0;
                    double addG = 0.0;
                    String codigoG;

                    codigoG = JOptionPane.showInputDialog("Digite el código de artículo para agregar inventario: ");
                    for (int i = 0; i < granel.size(); i++)
                    {
                        String looking = granel.get(i).getCodigo();
                        if (looking.equals(codigoG)) {
                            j = i;
                            break;
                        } else
                        {
                            j = i + 100;
                        }
                    }
                    if ( j > granel.size())
                    {
                        JOptionPane.showMessageDialog(null, "Código inválido!!", null, JOptionPane.WARNING_MESSAGE);
                        break;
                    }

                    while (true) {
                        try {
                            addG = Double.parseDouble(JOptionPane.showInputDialog("Digite la cantidad de kilos a agregar a " + codigoG + ": "));
                            if (addG > 0)
                            {
                                break;
                            }
                            else {
                                JOptionPane.showMessageDialog(null, "Número no puede ser negativo!", null, JOptionPane.WARNING_MESSAGE);
                            }
                            //break;
                        } catch (HeadlessException | NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Error!", null, JOptionPane.WARNING_MESSAGE);
                        }

                    }
                    double canG = granel.get(j).getKilos();
                    addG += canG;
                    granel.get(j).setKilos(addG);
                    String Gcod = granel.get(j).getCodigo();
                    String Gname = granel.get(j).getNombre();
                    double Gcant = granel.get(j).getKilos();
                    JOptionPane.showMessageDialog(null, "El nuevo inventario de '" + Gcod + " " + Gname + "' es de: " + Gcant);
;
                    break;


                case "5. Salir":
                    System.out.println("Salir Consultas");
                    seguir = false;
                    break;
            }

        }
    }
    public void restarInventario()
    {
        String[] substract = { "","1. Alimentos", "2. Artículos",
                "3. Medicamentos", "4. Granel", "5. Salir"};

        String msgC = ("1. Alimentos. \n" +
                "2. Artículos. \n" +
                "3. Medicamentos. \n" +
                "4. Granel. \n" +
                "5. Salir.\n");

        ImageIcon imagenC = new ImageIcon("pet.png");
        boolean seguir = true, seguir2 = true;


        while (seguir == true) {
            String res = (String) JOptionPane.showInputDialog(null, msgC, "Sistema PetMarket - Restar al Inventario",
                    JOptionPane.PLAIN_MESSAGE, imagenC, substract, substract[0]);

            switch (res) {
                case "1. Alimentos":
                    j = 0;
                    addAl = 0;
                    String codigoAl;

                    codigoAl = JOptionPane.showInputDialog("Digite el código de artículo para restar inventario: ");
                    for (int i = 0; i < alimentos.size(); i++) {
                        String looking = alimentos.get(i).getCodigo();
                        if (looking.equals(codigoAl)) {
                            j = i;
                            break;
                        } else {
                            j = i + 100;
                        }
                    }
                    if ( j > alimentos.size())
                    {
                        JOptionPane.showMessageDialog(null, "Código inválido!!", null, JOptionPane.WARNING_MESSAGE);
                        break;
                    }


                    while (true) {
                        try {
                            addAl = Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad de artículos a restar a " + codigoAl + ": "));
                            if (addAl > 0)
                            {
                                break;
                            }
                            else {
                                JOptionPane.showMessageDialog(null, "Número no puede ser negativo!", null, JOptionPane.WARNING_MESSAGE);
                            }
                            //break;
                        } catch (HeadlessException | NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Error!", null, JOptionPane.WARNING_MESSAGE);
                        }

                    }
                    int canTN = alimentos.get(j).getCantidad();
                    canTN -= addAl;
                    if (canTN >= 0) {
                        alimentos.get(j).setCantidad(canTN);
                        String Alcod = alimentos.get(j).getCodigo();
                        String Alname = alimentos.get(j).getNombre();
                        int Alcant = alimentos.get(j).getCantidad();
                        JOptionPane.showMessageDialog(null, "El nuevo inventario de '" + Alcod + " " + Alname + "' es de: " + Alcant);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Error!, el inventario de " + codigoAl + " no puede ser negativo.",
                                null, JOptionPane.WARNING_MESSAGE);
                    }

                    break;



//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                case "2. Artículos":
                    System.out.println("Artículos");
                    j = 0;
                    addAl = 0;
                    String codigoAr;

                    codigoAr = JOptionPane.showInputDialog("Digite el código de artículo para restar inventario: ");
                    for (int i = 0; i < articulos.size(); i++)
                    {
                        String looking = articulos.get(i).getCodigo();
                        if (looking.equals(codigoAr)) {
                            j = i;
                            break;
                        } else
                        {
                            j = i + 100;
                        }
                    }
                    if ( j > articulos.size())
                    {
                        JOptionPane.showMessageDialog(null, "Código inválido!!", null, JOptionPane.WARNING_MESSAGE);
                        break;
                    }

                    while (true) {
                        try {
                            addAl = Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad de artículos a restar a " + codigoAr + ": "));
                            if (addAl > 0)
                            {
                                break;
                            }
                            else {
                                JOptionPane.showMessageDialog(null, "Número no puede ser negativo!", null, JOptionPane.WARNING_MESSAGE);
                            }
                            //break;
                        } catch (HeadlessException | NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Error!", null, JOptionPane.WARNING_MESSAGE);
                        }

                    }
                    int canAR = alimentos.get(j).getCantidad();
                    canAR -= addAl;
                    if (canAR >= 0) {
                        articulos.get(j).setCantidad(canAR);
                        String Arcod = articulos.get(j).getCodigo();
                        String Arname = articulos.get(j).getNombre();
                        int Arcant = articulos.get(j).getCantidad();
                        JOptionPane.showMessageDialog(null, "El nuevo inventario de '" + Arcod + " " + Arname + "' es de: " + Arcant);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Error!, el inventario de " + codigoAr + " no puede ser negativo.",
                                null, JOptionPane.WARNING_MESSAGE);
                    }

                    break;

                /////////////////////////////////////////////////////////////////////////////////////

                case "3. Medicamentos":
                    System.out.println("Medicamentos");
                    j = 0;
                    addAl = 0;
                    String codigoM;

                    codigoM = JOptionPane.showInputDialog("Digite el código de artículo para restar inventario: ");
                    for (int i = 0; i < medicamentos.size(); i++)
                    {
                        String looking = medicamentos.get(i).getCodigo();
                        if (looking.equals(codigoM)) {
                            j = i;
                            break;
                        } else
                        {
                            j = i + 100;
                        }
                    }
                    if ( j > medicamentos.size())
                    {
                        JOptionPane.showMessageDialog(null, "Código inválido!!", null, JOptionPane.WARNING_MESSAGE);
                        break;
                    }

                    while (true) {
                        try {
                            addAl = Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad de artículos a restar a " + codigoM + ": "));
                            if (addAl > 0)
                            {
                                break;
                            }
                            else {
                                JOptionPane.showMessageDialog(null, "Número no puede ser negativo!", null, JOptionPane.WARNING_MESSAGE);
                            }
                            //break;
                        } catch (HeadlessException | NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Error!", null, JOptionPane.WARNING_MESSAGE);
                        }

                    }
                    int canM = medicamentos.get(j).getCantidad();
                    canM -= addAl;
                    if (canM >= 0) {
                        medicamentos.get(j).setCantidad(canM);
                        String Mcod = medicamentos.get(j).getCodigo();
                        String Mname = medicamentos.get(j).getNombre();
                        int Mcant = medicamentos.get(j).getCantidad();
                        JOptionPane.showMessageDialog(null, "El nuevo inventario de '" + Mcod + " " + Mname + "' es de: " + Mcant);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Error!, el inventario de " + codigoM + " no puede ser negativo.",
                                null, JOptionPane.WARNING_MESSAGE);
                    }

                    break;


////////////////////////////////////////////////////////////////////////////////////////////

                case "4. Granel":
                    System.out.println("Granel");
                    j = 0;
                    double addG = 0.0;
                    String codigoG;

                    codigoG = JOptionPane.showInputDialog("Digite el código de artículo para restar inventario: ");
                    for (int i = 0; i < granel.size(); i++)
                    {
                        String looking = granel.get(i).getCodigo();
                        if (looking.equals(codigoG)) {
                            j = i;
                            break;
                        } else
                        {
                            j = i + 100;
                        }
                    }
                    if ( j > granel.size())
                    {
                        JOptionPane.showMessageDialog(null, "Código inválido!!", null, JOptionPane.WARNING_MESSAGE);
                        break;
                    }

                    while (true) {
                        try {
                            addG = Double.parseDouble(JOptionPane.showInputDialog("Digite la cantidad de kilos a restar a " + codigoG + ": "));
                            if (addG > 0)
                            {
                                break;
                            }
                            else {
                                JOptionPane.showMessageDialog(null, "Número no puede ser negativo!", null, JOptionPane.WARNING_MESSAGE);
                            }
                            //break;
                        } catch (HeadlessException | NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Error!", null, JOptionPane.WARNING_MESSAGE);
                        }

                    }
                    double canG = granel.get(j).getKilos();
                    canG -= addG;
                    if (canG >= 0) {
                        granel.get(j).setKilos(canG);
                        String Gcod = granel.get(j).getCodigo();
                        String Gname = granel.get(j).getNombre();
                        double Gcant = granel.get(j).getKilos();
                        JOptionPane.showMessageDialog(null, "El nuevo inventario de '" + Gcod + " " + Gname + "' es de: " + Gcant);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Error!, el inventario de " + codigoG + " no puede ser negativo.",
                                null, JOptionPane.WARNING_MESSAGE);
                    }

                    break;


                case "5. Salir":
                    System.out.println("Salir Consultas");
                    seguir = false;
                    break;
            }

        }
    }

    public void agregarProducto()
    {
        int  confirmado = 0;
        boolean seguirAP = true;
        JTextField field1 = new JTextField();
        JTextField field2 = new JTextField();
        JTextField field3 = new JTextField();
        JTextField field4 = new JTextField();
        //JTextField field5 = new JTextField();

        Object[] fields = {
                "Ingrese el nombre del nuevo producto: ", field1,
                "Ingrese el tipo de animal del nuevo producto: ", field2,
                "Ingrese el precio del nuevo producto: ", field3,
                "Ingrese la cantidad en unidades del nuevo producto: ", field4,

    };
        String[] addproducts = { "","1. Alimentos", "2. Artículos",
                "3. Medicamentos", "4. Granel", "5. Salir"};

        String msgAP = ("1. Alimentos. \n" +
                "2. Artículos. \n" +
                "3. Medicamentos. \n" +
                "4. Granel. \n" +
                "5. Salir.\n");

        ImageIcon imagenAP = new ImageIcon("pet.png");
        ImageIcon imagenAP2 = new ImageIcon("pet.png");
        seguir = true;



        while (seguir == true) {
            String res = (String) JOptionPane.showInputDialog(null, msgAP, "Sistema PetMarket - Agregar nuevos productos",
                    JOptionPane.PLAIN_MESSAGE, imagenAP, addproducts, addproducts[0]);
            String cadena = "", value1 = "", value2 = "";
            double value3 = 0.0;
            int value4 = 0;

            switch (res) {
                case "1. Alimentos":
                    value1 = "";
                    value2 = "";
                    value3 = 0.0;
                    value4 = 0;
                    System.out.println("Alimentos - nuevos productos");
                    //int alSize = alimentos.size();
                    while (seguirAP) {
                        confirmado = 0;
                        int option = JOptionPane.showConfirmDialog(null, fields, "Sistema PetMarket - Agregar nuevos productos (Alimentos)",
                                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, imagenAP2);

                        if (option == JOptionPane.OK_OPTION) {
                            value1 = field1.getText();
                            value2 = field2.getText();
                            try {
                                value3 = Double.parseDouble(field3.getText());
                                confirmado +=1;

                            } catch (HeadlessException | NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Error! El precio tiene formato inválido",
                                        "Sistema PetMarket", JOptionPane.WARNING_MESSAGE);
                                confirmado = 20;
                                break;
                            }

                            try {
                                value4 = Integer.parseInt(field4.getText());


                            } catch (HeadlessException | NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Error! La cantidad tiene formato inválido",
                                        "Sistema PetMarket", JOptionPane.WARNING_MESSAGE);
                                confirmado = 20;
                                break;
                            }

                        break;
                        } else
                        {
                            JOptionPane.showMessageDialog(null, "Cancelado");
                            break;
                        }
                    }
                    if (confirmado == 1)
                    {
                        System.out.println(" Seguimos" + confirmado);
                        int nuevoAl = alimentos.size() + 1;
                        String newAl = ("AL-COD-" + nuevoAl);
                        alimentos.add(new Alimentos(newAl, value1, value2, value3, value4));
                        JOptionPane.showMessageDialog(null, "Confirmado, " + newAl +
                                " | " + value1 + " | " + value2 + " | " + value3 + " | " + value4);
                    }
                    break;

                case "2. Artículos":
                    System.out.println("Artículos - nuevos productos");
                    //int arSize = articulos.size();
                    value1 = "";
                    value2 = "";
                    value3 = 0.0;
                    value4 = 0;

                    while (seguirAP) {
                        confirmado = 0;
                        int option = JOptionPane.showConfirmDialog(null, fields, "Sistema PetMarket - Agregar nuevos productos (Artículos)",
                                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, imagenAP2);

                        if (option == JOptionPane.OK_OPTION) {
                            value1 = field1.getText();
                            value2 = field2.getText();
                            try {
                                value3 = Double.parseDouble(field3.getText());
                                confirmado +=1;

                            } catch (HeadlessException | NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Error! El precio tiene formato inválido",
                                        "Sistema PetMarket", JOptionPane.WARNING_MESSAGE);
                                confirmado = 20;
                                break;
                            }

                            try {
                                value4 = Integer.parseInt(field4.getText());


                            } catch (HeadlessException | NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Error! La cantidad tiene formato inválido",
                                        "Sistema PetMarket", JOptionPane.WARNING_MESSAGE);
                                confirmado = 20;
                                break;
                            }

                            break;
                        } else
                        {
                            JOptionPane.showMessageDialog(null, "Cancelado");
                            break;
                        }
                    }
                    if (confirmado == 1)
                    {
                        System.out.println(" Seguimos" + confirmado);
                        int nuevoAl = articulos.size() + 1;
                        String newAl = ("AR-COD-" + nuevoAl);
                        articulos.add(new Articulos(newAl, value1, value2, value3, value4));
                        JOptionPane.showMessageDialog(null, "Confirmado, " + newAl +
                                " | " + value1 + " | " + value2 + " | " + value3 + " | " + value4);
                    }
                    break;

                case "3. Medicamentos":
                    System.out.println("Medicamentos - nuevos productos");
                    //int arSize = articulos.size();
                    value1 = "";
                    value2 = "";
                    value3 = 0.0;
                    value4 = 0;

                    while (seguirAP) {
                        confirmado = 0;
                        int option = JOptionPane.showConfirmDialog(null, fields, "Sistema PetMarket - Agregar nuevos productos (Medicamentos)",
                                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, imagenAP2);

                        if (option == JOptionPane.OK_OPTION) {
                            value1 = field1.getText();
                            value2 = field2.getText();
                            try {
                                value3 = Double.parseDouble(field3.getText());
                                confirmado +=1;

                            } catch (HeadlessException | NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Error! El precio tiene formato inválido",
                                        "Sistema PetMarket", JOptionPane.WARNING_MESSAGE);
                                confirmado = 20;
                                break;
                            }

                            try {
                                value4 = Integer.parseInt(field4.getText());


                            } catch (HeadlessException | NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Error! La cantidad tiene formato inválido",
                                        "Sistema PetMarket", JOptionPane.WARNING_MESSAGE);
                                confirmado = 20;
                                break;
                            }

                            break;
                        } else
                        {
                            JOptionPane.showMessageDialog(null, "Cancelado");
                            break;
                        }
                    }
                    if (confirmado == 1)
                    {
                        System.out.println(" Seguimos" + confirmado);
                        int nuevoM = medicamentos.size() + 1;
                        String newM = ("MED-COD-" + nuevoM);
                        medicamentos.add(new Medicamentos(newM, value1, value2, value3, value4));
                        JOptionPane.showMessageDialog(null, "Confirmado, " + newM +
                                " | " + value1 + " | " + value2 + " | " + value3 + " | " + value4);
                    }
                    break;

                case "4. Granel":
                    System.out.println("Granel - nuevos productos");
                    //int arSize = articulos.size();
                    value1 = "";
                    value2 = "";
                    value3 = 0.0;
                    double value5 = 0.0;

                    while (seguirAP) {
                        confirmado = 0;
                        int option = JOptionPane.showConfirmDialog(null, fields, "Sistema PetMarket - Agregar nuevos productos (Granel)",
                                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, imagenAP2);

                        if (option == JOptionPane.OK_OPTION) {
                            value1 = field1.getText();
                            value2 = field2.getText();
                            try {
                                value3 = Double.parseDouble(field3.getText());
                                confirmado +=1;

                            } catch (HeadlessException | NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Error! El precio tiene formato inválido",
                                        "Sistema PetMarket", JOptionPane.WARNING_MESSAGE);
                                confirmado = 20;
                                break;
                            }

                            try {
                                value5 = Double.parseDouble(field4.getText());


                            } catch (HeadlessException | NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Error! La cantidad tiene formato inválido",
                                        "Sistema PetMarket", JOptionPane.WARNING_MESSAGE);
                                confirmado = 20;
                                break;
                            }

                            break;
                        } else
                        {
                            JOptionPane.showMessageDialog(null, "Cancelado");
                            break;
                        }
                    }
                    if (confirmado == 1)
                    {
                        System.out.println(" Seguimos" + confirmado);
                        int nuevoG = granel.size() + 1;
                        String newG = ("GRA-COD-" + nuevoG);
                        granel.add(new Granel(newG, value1, value2, value3, value5));
                        JOptionPane.showMessageDialog(null, "Confirmado, " + newG +
                                " | " + value1 + " | " + value2 + " | " + value3 + " | " + value5);
                    }
                    break;


                case "5. Salir":
                    System.out.println("Salir Consultas");
                    seguir = false;
                    break;
            }

        }
         //AL-COD-001 concatenar el string, VAR = Array.length -> String = ("AL-COD-" + VAR+1); Esto es el nuevo código del producto a agregar.
    }
}
