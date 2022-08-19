public class Orden {

    public Provincias Origen;
    public Provincias Destino;
    public int Containers;

    public String NombreB;
    public String ApellidosB;
    private int IDB;

    public String NombreC;
    public String ApellidosC;
    private int IDC;

    public double Oferta;
    public Status Status;

    public int OrdenID;

    public Orden (Provincias origen, Provincias destino, int containers, String nombreB, String apellidosB, int iDB,
                  String nombreC, String apellidosC, int iDC, double oferta, Status status, int ordenID)
    {
        this.Origen = origen;
        this.Destino = destino;
        this.Containers = containers;
        this.NombreB = nombreB;
        this.ApellidosB = apellidosB;
        this.IDB = iDB;
        this.NombreC = nombreC;
        this.ApellidosC = apellidosC;
        this.IDC = iDC;
        this.Oferta = oferta;
        this.Status = status;
        this.OrdenID = ordenID;
    }

    public Provincias getOrigen() {return Origen;}

    public void setOrigen(Provincias origen) {
        Origen = origen;
    }

    public Provincias getDestino() {
        return Destino;
    }

    public void setDestino(Provincias destino) {
        Destino = destino;
    }

    public int getContainers() {
        return Containers;
    }

    public void setContainers(int containers) {
        Containers = containers;
    }

    public String getNombreB() {
        return NombreB;
    }

    public void setNombreB(String nombreB) {
        NombreB = nombreB;
    }

    public String getApellidosB() {
        return ApellidosB;
    }

    public void setApellidosB(String apellidosB) {
        ApellidosB = apellidosB;
    }

    public int getIDB() {
        return IDB;
    }

    public void setIDB(int IDB) {
        this.IDB = IDB;
    }

    public String getNombreC() {
        return NombreC;
    }

    public void setNombreC(String nombreC) {
        NombreC = nombreC;
    }

    public String getApellidosC() {
        return ApellidosC;
    }

    public void setApellidosC(String apellidosC) {
        ApellidosC = apellidosC;
    }

    public int getIDC() {
        return IDC;
    }

    public void setIDC(int IDC) {
        this.IDC = IDC;
    }

    public double getOferta() {
        return Oferta;
    }

    public void setOferta(double oferta) {
        Oferta = oferta;
    }

    public Status getStatus() {
        return Status;
    }

    public void setStatus(Status status) {
        Status = status;
    }

    public int getOrdenID() {
        return OrdenID;
    }

    public void setOrdenID(int ordenID) {
        OrdenID = ordenID;
    }


}
