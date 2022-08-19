import javax.swing.*;
import java.awt.*;

public class Carrier {


    public static void ofertasPendientes(int id)
    {
        String cadena = "";

        for (int i = 0; i < Broker.ordenesCotB.size(); i++)
        {
            if (Broker.ordenesCotB.get(i).getStatus().equals(Status.Pending))
            {
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
        JOptionPane.showMessageDialog(null, cadena);
    }

    public static void presentarOferta(int id)
    {

        boolean seguir = true;
        int orden = 0;
        String cadena2 = "";
        double costo = 0.0;

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
                                "---------------------------------------------------");
                        try {
                            costo = Double.parseDouble(JOptionPane.showInputDialog(null,
                                    "Digite la oferta : $ "));
                        } catch(HeadlessException | NumberFormatException e){
                            JOptionPane.showMessageDialog(null, "Error! Formato inválido, oferta cancelada.",
                                    "Sistema TicoCargas", JOptionPane.WARNING_MESSAGE);
                            break;
                        }
                        for (int j =0; j < Registro.usuarios.size(); j++) {
                            if (id == Registro.usuarios.get(j).getCedula()) {
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

                                for (int k = 0; k < Broker.tempB.size(); k++){
                                    if (ordenID == Broker.tempB.get(k).getOrdenID())
                                    {
                                        Broker.tempB.get(k).setOferta(oferta);
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

