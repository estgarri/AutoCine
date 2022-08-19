import javax.swing.*;
import java.util.ArrayList;

public class Broker {

    public static ArrayList<Orden> ordenesCotB = new ArrayList<>();
    public static ArrayList<Orden> tempB = new ArrayList<>();


    public static void cotizar(int id)
    {
        ImageIcon image = new ImageIcon();

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


        Object[] pedirCotizacion;

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
            value3 = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el número de containers"));

            if (value3 != 0)
            {
                /*try {
                    option2 = Integer.parseInt(field3.getText());

                    value3 = option2;

                }catch (HeadlessException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error! Cantidad de container debe ser un número entero.",
                        "Sistema PetMarket", JOptionPane.WARNING_MESSAGE);
                cont = false;
                }*/

                if (cont == true)
                {
                    for (int i = 0; i < Registro.usuarios.size(); i++)
                    {
                        if (id == Registro.usuarios.get(i).getCedula())
                        {
                            String nomB = Registro.usuarios.get(i).getNombre();
                            String apellB = Registro.usuarios.get(i).getApellidos();
                            int iDB = Registro.usuarios.get(i).getCedula();
                            Status status = Status.Pending;
                            String nombreC = "", apellidosC ="";
                            int iDC = 0;
                            Double oferta = 0.0;
                            int ordenID = ordenesCotB.size() + 1;
                            ordenesCotB.add(new Orden(value1, value2, value3, nomB, apellB, iDB,
                                    nombreC, apellidosC, iDC,  oferta, status, ordenID));
                            tempB.add(new Orden(value1, value2, value3, nomB, apellB, iDB,
                                    nombreC, apellidosC, iDC,  oferta, status, ordenID));
                            String prov1 = String.valueOf(value1);
                            String prov2 = String.valueOf(value2);
                            String cadena = (prov1 + " " + prov2 + " " + value3 + " " +  nomB + " " + apellB + " " + iDB +
                                    " " + nombreC + " " + apellidosC + " " + iDC + " " + oferta + " " + status  + " " + ordenID);

                            System.out.println(cadena);
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
        String cadena = "";
        String nomC = "", apellC ="";
        int iDC = 0;
        String value1 = null, value2 = null;
        ImageIcon image = new ImageIcon("accept-deny.png");
        String[] status = {"", "Aceptada", "Rechazada"};

        for (int i = 0; i < tempB.size(); i++)
        {
            if (tempB.get(i).getStatus().equals(Status.Pending) && id == tempB.get(i).getIDB())
            {
                String origen = String.valueOf(tempB.get(i).getOrigen());
                String destino = String.valueOf(tempB.get(i).getOrigen());
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
                        "--------------------------------------------------- \n"+
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

                cadena = ("Número de cotización: " + order + "\n" +
                        "Origen de la carga: " + origen + "\n" +
                        "Destino de la carga: " + destino + "\n" +
                        "Cantidad de containers: " + containers + "\n" +
                        "New Status: " + value1);

                System.out.println("New " + cadena);

                switch (value1){

                    case "Aceptada":
                        ordenesCotB.get(i).setIDC(iDC);
                        ordenesCotB.get(i).setNombreC(nomC);
                        ordenesCotB.get(i).setApellidosC(apellC);
                        ordenesCotB.get(i).setOferta(oferta);
                        ordenesCotB.get(i).setStatus(Status.Aceptada);
                        tempB.get(i).setStatus(Status.Aceptada);

                        break;

                    case "Rechazada":

                        break;

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


}
