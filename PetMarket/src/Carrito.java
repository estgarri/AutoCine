public class Carrito {

    public String Articulos, Email;
    public int Cedula, Cantidad;

    public double precio;

    public Carrito(String articulos, int cant) {
        this.Articulos = articulos;
        this.Cantidad = cant;
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
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}

