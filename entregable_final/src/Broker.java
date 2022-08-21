import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Broker {

    public static ArrayList<Orden> ordenesCotB = new ArrayList<>();
    public static ArrayList<Orden> tempB = new ArrayList<>();


    public static void cotizar(int id)
    {
        ImageIcon image = new ImageIcon("provincias.png");

        ////////////////////////
        JTextField field1 = new JTextField();
        JTextField field2 = new JTextField();
        JTextField field3 = new JTextField();
        JTextField field4 = new JTextField();

        ///////////////////////////

        String[] opcionBC = {"", "San_Jose", "Heredia", "Cartago", "Alajuela", "Puntarenas", "Limon", "Guanacaste"};
        String[] opcionBC2 = {"","San_Jose", "Heredia", "Cartago", "Alajuela", "Puntarenas", "Limon", "Guanacaste"};

        String msg = ("Escoja el origen de la carga: \n" +
                "1. San_Jose \n" +
                "2. Heredia \n" +
                "3. Cartago \n" +
                "4. Alajuela \n" +
                "5. Puntarenas \n" +
                "6. Limon \n" +
                "7. Guanacaste");

        String msg2 = ("Escoja el destino de la carga: \n" +
                "1. San_Jose \n" +
                "2. Heredia \n" +
                "3. Cartago \n" +
                "4. Alajuela \n" +
                "5. Puntarenas \n" +
                "6. Limon \n" +
                "7. Guanacaste");


        //String[] value1;
        Provincias value1 = null, value2 = null;

        int value3 = 0;

        boolean cont= true;


        int option = JOptionPane.showConfirmDialog(null,"Sección de cotizaciones, desea registrar una cotización? \n" + "\n",
                "Sistema TicoCargas - Borker - Cotizaciones", JOptionPane.YES_NO_OPTION);

        if (option == JOptionPane.YES_OPTION)
        {
            System.out.println("Pedir Cotizacion");

            try {
                value1 = Provincias.valueOf((String) JOptionPane.showInputDialog(null, msg, "Sistema TicoCargas - Origen",
                        JOptionPane.PLAIN_MESSAGE, image, opcionBC, opcionBC[0]));
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "Opción cancelada!!!", "Sistema TicoCargas - Origen",
                        JOptionPane.WARNING_MESSAGE);
            }
            try {
                value2 = Provincias.valueOf((String) JOptionPane.showInputDialog(null, msg2, "Sistema TicoCargas - Destino",
                        JOptionPane.PLAIN_MESSAGE, image, opcionBC, opcionBC[0]));
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "Opción cancelada!!!", "Sistema TicoCargas - Destino",
                        JOptionPane.WARNING_MESSAGE);
            }
            String test = JOptionPane.showInputDialog(null, "Digite el número de containers");
            if (test == null)
            {
                JOptionPane.showMessageDialog(null, "Oferta cancelada.",
                        "Sistema TicoCargas", JOptionPane.WARNING_MESSAGE);
            } else
            {

                try {
                    value3 = Integer.parseInt(test);
                } catch (NullPointerException e) {
                    JOptionPane.showMessageDialog(null, "Cotización cancelada!!!", "Sistema TicoCargas - Containers",
                            JOptionPane.WARNING_MESSAGE);
                }
                if (value3 != 0) {
                /*try {
                    option2 = Integer.parseInt(field3.getText());

                    value3 = option2;

                }catch (HeadlessException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error! Cantidad de container debe ser un número entero.",
                        "Sistema PetMarket", JOptionPane.WARNING_MESSAGE);
                cont = false;
                }*/

                    if (cont == true) {
                        for (int i = 0; i < Registro.usuarios.size(); i++) {
                            if (id == Registro.usuarios.get(i).getCedula()) {
                                String nomB = Registro.usuarios.get(i).getNombre();
                                String apellB = Registro.usuarios.get(i).getApellidos();
                                int iDB = Registro.usuarios.get(i).getCedula();
                                Status status = Status.Pending;
                                String nombreC = "", apellidosC = "";
                                int iDC = 0;
                                Double oferta = 0.0;
                                int ordenID = ordenesCotB.size() + 1;
                                int ofertaID = tempB.size() + 1;
                                ordenesCotB.add(new Orden(value1, value2, value3, nomB, apellB, iDB,
                                        nombreC, apellidosC, iDC, oferta, status, ordenID, ofertaID));
                                tempB.add(new Orden(value1, value2, value3, nomB, apellB, iDB,
                                        nombreC, apellidosC, iDC, oferta, status, ordenID, ofertaID));
                                String prov1 = String.valueOf(value1);
                                String prov2 = String.valueOf(value2);
                                String cadena = (prov1 + " " + prov2 + " " + value3 + " " + nomB + " " + apellB + " " + iDB +
                                        " " + nombreC + " " + apellidosC + " " + iDC + " " + oferta + " " + status + " " + ordenID);

                                System.out.println(cadena);
                            }
                        }
                    }
                }
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Opción cancelada!!!", "Sistema TicoCargas - Cotizaciones",
                    JOptionPane.WARNING_MESSAGE);
        }
    }


    public static void aceptarRechazar(int id)
    {
        System.out.println("Aceptar - Rechazar");

        ////////////////////////////////////////////////////////////////////////////////////////
        //Collections.sort(tempB);

        for (Orden t : tempB)
        {
            System.out.println("ACA!!" + t);
        }
        //////////////////////////////////////////////////////////////////////////////////////

        String cadena = "", cadena2 = "", cadena3 ="";
        String nomC = "", apellC ="";
        int iDC = 0;
        int k = 0, l = 0, orderOld = 0, orden = 0;
        String value1 = null, value2 = null;
        ImageIcon image = new ImageIcon("accept-deny.png");
        ImageIcon image2 = new ImageIcon("containerTruck.png");
        String[] status = {"", "Aceptada", "Rechazada"};
        boolean seguir = true;

        /* for (int i = 0; i < tempB.size(); i++) {
            if (tempB.get(i).getStatus().equals(Status.Pending) && id == tempB.get(i).getIDB()) {
                String origen2 = String.valueOf(tempB.get(i).getOrigen());
                String destino2 = String.valueOf(tempB.get(i).getDestino());
                int order2 = tempB.get(i).getOrdenID();
                int containers2 = tempB.get(i).getContainers();
                double oferta2 = tempB.get(i).getOferta();


                if (l == 0 || order2 == orderOld)
                {
                    l++;
                    orderOld = order2;
                    cadena3 = ("---------------------------------------------------\n" +
                            "Número de cotización: " + order2 + "               \n" +
                            "---------------------------------------------------\n" +
                            "Origen de la carga: " + origen2 + "               \n" +
                            "Destino de la carga: " + destino2 + "               \n" +
                            "Cantidad de containers: " + containers2 + "\n" +
                            "--------------------------------------------------- \n" +
                            "Oferta es de: $ " + oferta2 + "\n" +
                            "---------------------------------------------------\n");
                }
                else{
                    System.out.println("Para la cotización '" + orderOld + "' , tiene " + l + " cotizaciones las cuales son las siguientes: \n"
                            + cadena3);
                    l = 0;
                }
            }
        } */

        try {
            orden = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el número de la oferta: "));

        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error! Formato inválido para el número de oferta.",
                    "Sistema TicoCargas", JOptionPane.WARNING_MESSAGE);
            seguir = false;
        }

        if (seguir == true) {
            for (int i = 0; i < tempB.size(); i++) {
                if (tempB.get(i).getStatus().equals(Status.Pending) && id == tempB.get(i).getIDB() && tempB.get(i).getOferta() != 0 && orden == tempB.get(i).getOfertaID())
                {
                    String origen = String.valueOf(tempB.get(i).getOrigen());
                    String destino = String.valueOf(tempB.get(i).getDestino());
                    int order = tempB.get(i).getOrdenID();
                    int containers = tempB.get(i).getContainers();
                    double oferta = tempB.get(i).getOferta();
                    nomC = tempB.get(i).getNombreC();
                    apellC = tempB.get(i).getApellidosC();
                    iDC = tempB.get(i).getIDC();

                    cadena = ("---------------------------------------------------\n" +
                            "Número de cotización: " + order + "               \n" +
                            "---------------------------------------------------\n" +
                            "Origen de la carga: " + origen + "               \n" +
                            "Destino de la carga: " + destino + "               \n" +
                            "Cantidad de containers: " + containers + "\n" +
                            "--------------------------------------------------- \n" +
                            "Oferta es de: $ " + oferta + "\n" +
                            "---------------------------------------------------\n");

                    System.out.println(cadena);

                    try {
                        value1 = String.valueOf(Status.valueOf((String) JOptionPane.showInputDialog(null, cadena, "Sistema TicoCargas - Aceptar/Rechazar",
                                JOptionPane.PLAIN_MESSAGE, image, status, status[0])));
                    } catch (NullPointerException e) {
                        JOptionPane.showMessageDialog(null, "Opción cancelada!!!", "Sistema TicoCargas - Origen",
                                JOptionPane.WARNING_MESSAGE);
                    }

                /*cadena = ("Número de cotización: " + order + "\n" +
                        "Origen de la carga: " + origen + "\n" +
                        "Destino de la carga: " + destino + "\n" +
                        "Cantidad de containers: " + containers + "\n" +
                        "New Status: " + value1);

                System.out.println("New " + cadena); */

                    for (int j = 0; j < ordenesCotB.size(); j++) {
                        if (order == ordenesCotB.get(j).getOrdenID()) {
                            k = j;
                            break;
                        }
                    }

                    switch (value1) {

                        case "Aceptada":
                            ordenesCotB.get(k).setIDC(iDC);
                            ordenesCotB.get(k).setNombreC(nomC);
                            ordenesCotB.get(k).setApellidosC(apellC);
                            ordenesCotB.get(k).setOferta(oferta);
                            ordenesCotB.get(k).setStatus(Status.Aceptada);
                            int oftID = tempB.get(i).getOfertaID();
                            ordenesCotB.get(k).setOfertaID(oftID);
                            tempB.get(i).setStatus(Status.Aceptada);

                            for (int m = 0; m < ordenesCotB.size(); m++) {

                                if (order == ordenesCotB.get(m).getOrdenID()) {
                                    int prntOderID = ordenesCotB.get(m).getOrdenID();
                                    String prnt = String.valueOf(ordenesCotB.get(m).getStatus());
                                    String prntNomC = ordenesCotB.get(m).getNombreC();
                                    String prntApellC = ordenesCotB.get(m).getApellidosC();
                                    double prntOferta = ordenesCotB.get(m).getOferta();

                                    cadena2 = ("Número de cotización: " + prntOderID + "\n" +
                                            "El nombre del proveedor: " + prntNomC + " " + prntApellC + "\n" +
                                            "Monto de la oferta aceptada: " + prntOferta + "\n" +
                                            "Número de oferta: " + oftID + "\n" +
                                            "Status de la oferta confirmada: " + prnt);

                                    JOptionPane.showMessageDialog(null, cadena2, "Confirmación de la orden", JOptionPane.INFORMATION_MESSAGE, image2);

                                }
                                for (int n = 0; n < tempB.size(); n++)
                                {
                                    if (order == tempB.get(n).getOrdenID() && tempB.get(n).getStatus().equals(Status.Pending))
                                    {
                                        tempB.get(n).setStatus(Status.Rechazada);
                                        break;
                                    }
                                }
                            }
                            for (Orden t : tempB)
                            {
                                System.out.println("Final!!" + t);
                            }


                            break;

                        case "Rechazada":
                            tempB.get(i).setStatus(Status.Rechazada);
                            break;

                    }

                }
            }
        }

        //valueChangedMain(id);
    }

   /*public static void valueChangedMain(int id) {

        for (int i = 0; i < ordenesCotB.size(); i++)
        {
            if (ordenesCotB.get(i).getStatus().equals(Status.Pending) && id == ordenesCotB.get(i).getIDB())
            {
                Provincias origen = ordenesCotB.get(i).getOrigen();
                Provincias destino = ordenesCotB.get(i).getDestino();
                int contianers = ordenesCotB.get(i).getContainers();
                String nomB = ordenesCotB.get(i).getNombreB();
                String apellB = ordenesCotB.get(i).getApellidosB();
                int iDB = ordenesCotB.get(i).getIDB();
                String nomC = ordenesCotB.get(i).getNombreC();
                String apellC = ordenesCotB.get(i).getApellidosC();
                int iDC = ordenesCotB.get(i).getIDC();
                double oferta = ordenesCotB.get(i).getOferta();
                Status status = ordenesCotB.get(i).getStatus();
                int ordenID = ordenesCotB.get(i).getOrdenID();

                tempB.add(new Orden(origen, destino, contianers, nomB, apellB, iDB,
                        nomC, apellC, iDC,  oferta, status, ordenID));
            }
        }

        int size = tempB.size();
        JFrame f = new JFrame("TicoCargas");
        String data[][]= new String[size][4];
        String column[]={"Order ID","Origin","Destino","Oferta"};

        for (int i = 0; i < tempB.size(); i++)
        {
            for (int j = 0; j < data[0].length; j++)
            {
               switch (j) {

                   case 0:
                       data[i][j] = String.valueOf(tempB.get(i).getOrdenID());
                       break;

                   case 1:
                       data[i][j] = String.valueOf(tempB.get(i).getOrigen());
                       break;

                   case 2:
                       data[i][j] = String.valueOf(tempB.get(i).getDestino());
                       break;

                   case 3:
                       data[i][j] = String.valueOf(tempB.get(i).getOferta());
                       break;
               }
            }
        }


        final JTable jt=new JTable(data,column);
        //jt.setCellSelectionEnabled(true);
        //ListSelectionModel select= jt.getSelectionModel();
        //select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //select.addListSelectionListener(new ListSelectionListener() {
            //public void valueChanged(ListSelectionEvent e) {
                //String Data = null;
                //int[] row = jt.getSelectedRows();
                //int[] columns = jt.getSelectedColumns();
                //for (int i = 0; i < row.length; i++) {
                    //for (int j = 0; j < columns.length; j++) {
                        //Data = (String) jt.getValueAt(row[i], columns[j]);
                    //} }
                //System.out.println("Table element selected is: " + Data);
            //}
        //});
        JScrollPane sp=new JScrollPane(jt);
        f.add(sp);
        f.setSize(300, 200);
        f.setVisible(true);

       JOptionPane.showInputDialog(null,f,"TicoCargas",JOptionPane.INFORMATION_MESSAGE);
        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                System.out.println("Closed");
                e.getWindow().dispose();
            }
        });
    } */

    public static void consultasPendientes(int id)
    {
        String cadena = "";
        int k =0, ofertaID = 0;
        double costo = 0.0;
        ImageIcon image = new ImageIcon("empty.png");
        ImageIcon image2 = new ImageIcon("pendingOffers.png");

        for (int i = 0; i < tempB.size(); i++)
        {
            if (tempB.get(i).getStatus().equals(Status.Pending) && id == tempB.get(i).getIDB()
                    || tempB.get(i).getStatus().equals(Status.Pending) && id == tempB.get(i).getIDB() && tempB.get(i).getOfertaID() == 0)
            {
                k++;
                String origen = String.valueOf(tempB.get(i).getOrigen());
                String destino = String.valueOf(tempB.get(i).getDestino());
                int order = tempB.get(i).getOrdenID();
                int containers = tempB.get(i).getContainers();
                String status = String.valueOf(tempB.get(i).getStatus());
                ofertaID = tempB.get(i).getOfertaID();
                costo = tempB.get(i).getOferta();

                cadena += ("---------------------------------------------------\n" +
                        "Número de cotización: " + order + "               \n" +
                        "---------------------------------------------------\n" +
                        "Origen de la carga: " + origen + "               \n" +
                        "Destino de la carga: " + destino + "               \n" +
                        "Cantidad de containers: " + containers + "\n" +
                        "Status de la cotización: " + status + "\n" +
                        "--------------------------------------------------- \n" +
                        "Número de oferta: " + ofertaID + "\n" +
                        "Valor de la oferta: $ " + costo + "\n" + "\n");
            }
        }
        if (k > 0)
        {
            JOptionPane.showMessageDialog(null, cadena, "TicoCargas - Ofertas pendientes", JOptionPane.INFORMATION_MESSAGE, image2);
        }
        else {
            JOptionPane.showMessageDialog(null, "No hay cotizaciones con ofertas en este momento", "TicoCargas - Ofertas pendientes",
                    JOptionPane.INFORMATION_MESSAGE, image);
        }
    }

    public static void ofertasAceptadas(int id){

        String cadena = "";
        int reader = 0;



        for (int i = 0; i < ordenesCotB.size(); i++)
        {
            if (id == ordenesCotB.get(i).getIDB() && ordenesCotB.get(i).getStatus().equals(Status.Aceptada)) {
                String origen = String.valueOf(ordenesCotB.get(i).getOrigen());
                String destino = String.valueOf(ordenesCotB.get(i).getDestino());
                int order = ordenesCotB.get(i).getOrdenID();
                int containers = ordenesCotB.get(i).getContainers();
                String status = String.valueOf(ordenesCotB.get(i).getStatus());
                int ofertaID = ordenesCotB.get(i).getOfertaID();
                double costo = ordenesCotB.get(i).getOferta();
                String nomC = ordenesCotB.get(i).getNombreC();
                String apellC = ordenesCotB.get(i).getApellidosC();

                cadena = ("---------------------------------------------------\n" +
                        "Número de cotización: " + order + "               \n" +
                        "---------------------------------------------------\n" +
                        "Nombre del transportista: " + nomC + " " + apellC + "\n" +
                        "Origen de la carga: " + origen + "               \n" +
                        "Destino de la carga: " + destino + "               \n" +
                        "Cantidad de containers: " + containers + "\n" +
                        "Status de la cotización: " + status + "\n" +
                        "--------------------------------------------------- \n" +
                        "Número de oferta: " + ofertaID + "\n" +
                        "Valor de la oferta: $ " + costo + "\n" + "\n");

                if (reader == 0) ;
                String archivo;
                {
                    archivo = ("Reporte_Aceptadas_" + order + ".txt");
                    try (BufferedWriter cargas = new BufferedWriter(new FileWriter(archivo))) {
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    reader = 1;
                }
                File file = new File(archivo);
                try {
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    try {
                        String st;
                        while ((st = br.readLine()) != null) {
                            System.out.println(st);
                            //JOptionPane.showMessageDialog(null,st);
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(Orden.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Orden.class.getName()).log(Level.SEVERE, null, ex);
                }
                try (BufferedWriter cargas = new BufferedWriter(new FileWriter(archivo, true))) {

                    cargas.write("\n" + cadena);

                } catch (IOException ex) {
                    Logger.getLogger(Orden.class.getName()).log(Level.SEVERE, null, ex);
                }
                //JOptionPane.showMessageDialog(null, "Reporte descargado, 'Root directory'.");
            }
            cadena = "";
        }

    }

}
