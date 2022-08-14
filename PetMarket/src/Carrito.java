public class Carrito {

    public String Articulos, Email;
    public int Cedula, Cantidad;

    public double Precio;

    public double Kg;

    public Carrito(String articulos, int cant, double precio, double kg) {
        this.Articulos = articulos;
        this.Cantidad = cant;
        this.Precio = precio;
        this.Kg = kg;
    }
    public double getKg() {
        return Kg;
    }

    public void setKg(double kg) {
        Kg = kg;
    }
    public String getArticulos() {
        return Articulos;
    }

    public void setArticulos(String artículos) {
        Articulos = artículos;
    }

    public int getCedula() {
        return Cedula;
    }

    public void setCedula(int cedula) {
        Cedula = cedula;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int cantidad) {
        Cantidad = cantidad;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double precio) {
        this.Precio = precio;
    }

}

