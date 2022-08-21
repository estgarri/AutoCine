import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Carrier {


    public static void ofertasPendientes(int id)
    {
        String cadena = "";
        int k =0;
        ImageIcon image = new ImageIcon("empty.png");

        for (int i = 0; i < Broker.ordenesCotB.size(); i++)
        {
            if (Broker.ordenesCotB.get(i).getStatus().equals(Status.Pending))
            {
                k++;
                String origen = String.valueOf(Broker.ordenesCotB.get(i).getOrigen());
                String destino = String.valueOf(Broker.ordenesCotB.get(i).getDestino());
                int order = Broker.ordenesCotB.get(i).getOrdenID();
                int containers = Broker.ordenesCotB.get(i).getContainers();

                cadena += ("---------------------------------------------------\n" +
                        "Número de cotización: " + order + "               \n" +
                        "---------------------------------------------------\n" +
                        "Origen de la carga: " + origen + "               \n" +
                        "Destino de la carga: " + destino + "               \n" +
                        "Cantidad de containers: " + containers + "\n" +
                        "---------------------------------------------------");
            }
        }
        if (k > 0)
        {
            JOptionPane.showMessageDialog(null, cadena);
        }
        else {
            JOptionPane.showMessageDialog(null, "No hay cotizaciones pendientes en este momento", "TicoCargas - Ofertas pendientes",
                    JOptionPane.INFORMATION_MESSAGE, image);
        }
    }

    public static void presentarOferta(int id)
    {

        boolean seguir = true;
        int orden = 0;
        String cadena2 = "", test = "", cadena3 = "";
        double costo = -1.0;
        ImageIcon image = new ImageIcon("waiting.png");

        try {
            orden = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el número al cual desea presentar la oferta : "));

        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error! Formato inválido para el número de orden.",
                    "Sistema TicoCargas", JOptionPane.WARNING_MESSAGE);
            seguir = false;
        }

            if (seguir == true)
            {

                for (int i = 0; i < Broker.ordenesCotB.size(); i++)
                {
                    if (Broker.ordenesCotB.get(i).getStatus().equals(Status.Pending) && orden == Broker.ordenesCotB.get(i).getOrdenID())
                    {
                        String origen = String.valueOf(Broker.ordenesCotB.get(i).getOrigen());
                        String destino = String.valueOf(Broker.ordenesCotB.get(i).getDestino());
                        int order = Broker.ordenesCotB.get(i).getOrdenID();
                        int containers = Broker.ordenesCotB.get(i).getContainers();

                        cadena2 = ("---------------------------------------------------\n" +
                                "Número de cotización: " + order + "               \n" +
                                "---------------------------------------------------\n" +
                                "Origen de la carga: " + origen + "               \n" +
                                "Destino de la carga: " + destino + "               \n" +
                                "Cantidad de containers: " + containers + "\n" +
                                "--------------------------------------------------- \n" + "\n");

                        test = JOptionPane.showInputDialog(null,cadena2 + "Digite la oferta : $ ");

                        if (test == null)
                        {
                            JOptionPane.showMessageDialog(null, "Oferta cancelada.",
                                    "Sistema TicoCargas", JOptionPane.WARNING_MESSAGE);
                            break;
                        }

                        try {
                            costo = Double.parseDouble(test);

                        } catch (HeadlessException | NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Error! Formato inválido, oferta cancelada.",
                                    "Sistema TicoCargas", JOptionPane.WARNING_MESSAGE);
                            break;
                        }
                        for (int j = 0; j < Registro.usuarios.size(); j++)
                        {
                            if (id == Registro.usuarios.get(j).getCedula())
                            {
                                Provincias origenf = Broker.ordenesCotB.get(i).getOrigen();
                                Provincias destinof = Broker.ordenesCotB.get(i).getDestino();
                                int contianers = Broker.ordenesCotB.get(i).getContainers();
                                String nomB = Broker.ordenesCotB.get(i).getNombreB();
                                String apellB = Broker.ordenesCotB.get(i).getApellidosB();
                                int iDB = Broker.ordenesCotB.get(i).getIDB();
                                String nomC = Registro.usuarios.get(j).getNombre();
                                String apellC = Registro.usuarios.get(j).getApellidos();
                                int iDC = Registro.usuarios.get(j).getCedula();
                                double oferta = costo;
                                Status status = Broker.ordenesCotB.get(i).getStatus();
                                int ordenID = Broker.ordenesCotB.get(i).getOrdenID();

                                for (int k = 0; k < Broker.tempB.size(); k++)
                                {

                                    if (ordenID == Broker.tempB.get(k).getOrdenID())
                                    {
                                        double ofertaO = Broker.tempB.get(k).getOferta();
                                        String s1 = "---------------------------------------------------\n" +
                                                "Número de cotización: " + order + "               \n" +
                                                "---------------------------------------------------\n" +
                                                "Origen de la carga: " + origen + "               \n" +
                                                "Destino de la carga: " + destino + "               \n" +
                                                "Cantidad de containers: " + containers + "\n" +
                                                "--------------------------------------------------- \n" +
                                                "Este es el número de oferta: " + oferta + "\n" +
                                                "A nombre de: " + nomC + " " + apellC + "\n" +
                                                "---------------------------------------------------\n";
                                        String s = s1;

                                        if (ofertaO == 0)
                                        {
                                            Broker.tempB.get(k).setOferta(oferta);
                                            Broker.tempB.get(k).setNombreC(nomC);
                                            Broker.tempB.get(k).setApellidosC(apellC);
                                            Broker.tempB.get(k).setIDC(iDC);
                                            cadena3 = s;
                                            JOptionPane.showMessageDialog(null, cadena3, "Confirmación de la orden", JOptionPane.INFORMATION_MESSAGE, image);
                                            break;
                                        } else
                                        {
                                            int ofertaID = Broker.tempB.size() + 1;
                                            Broker.tempB.add(new Orden(origenf, destinof, contianers, nomB, apellB, iDB,
                                                    nomC, apellC, iDC, oferta, status, ordenID, ofertaID));
                                            i = 100000;
                                            cadena3 = s1;
                                            JOptionPane.showMessageDialog(null, cadena3, "Confirmación de la orden", JOptionPane.INFORMATION_MESSAGE, image);
                                            break;
                                        }
                                    }
                                    //Broker.tempB.add(new Orden(origenf, destinof, contianers, nomB, apellB, iDB,
                                    //nomC, apellC, iDC,  oferta, status, ordenID));
                                }
                            }
                        }
                    }
                }
            }
    }


    public static void ofertasAceptadasC(int id)
    {

        String cadena5 = "";
        int reader = 0;



        for (int i = 0; i < Broker.ordenesCotB.size(); i++)
        {
            if (id == Broker.ordenesCotB.get(i).getIDC() && Broker.ordenesCotB.get(i).getStatus().equals(Status.Aceptada)) {
                String origen = String.valueOf(Broker.ordenesCotB.get(i).getOrigen());
                String destino = String.valueOf(Broker.ordenesCotB.get(i).getDestino());
                int order = Broker.ordenesCotB.get(i).getOrdenID();
                int containers = Broker.ordenesCotB.get(i).getContainers();
                String status = String.valueOf(Broker.ordenesCotB.get(i).getStatus());
                int ofertaID = Broker.ordenesCotB.get(i).getOfertaID();
                double costo = Broker.ordenesCotB.get(i).getOferta();
                String nomB = Broker.ordenesCotB.get(i).getNombreB();
                String apellB = Broker.ordenesCotB.get(i).getApellidosB();

                cadena5 = ("---------------------------------------------------\n" +
                        "Número de cotización: " + order + "               \n" +
                        "---------------------------------------------------\n" +
                        "Nombre del cliente: " + nomB + " " + apellB + "\n" +
                        "Origen de la carga: " + origen + "               \n" +
                        "Destino de la carga: " + destino + "               \n" +
                        "Cantidad de containers: " + containers + "\n" +
                        "Status de la cotización: " + status + "\n" +
                        "--------------------------------------------------- \n" +
                        "Número de oferta: " + ofertaID + "\n" +
                        "Valor de la oferta: $ " + costo + "\n" + "\n");

                System.out.println("Confirmacion \n" + cadena5);

                if (reader == 0) ;
                String archivo;
                {
                    archivo = ("Reporte_Aceptadas_Order_" + order + "_Oferta_" + ofertaID + ".txt");
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

                    cargas.write("\n" + cadena5);

                } catch (IOException ex) {
                    Logger.getLogger(Orden.class.getName()).log(Level.SEVERE, null, ex);
                }
                //JOptionPane.showMessageDialog(null, "Reporte descargado, 'Root directory'.");
            }
            cadena5 = "";
        }

    }

}



