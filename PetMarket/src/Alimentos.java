public class Alimentos {


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(String tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String codigo;
    public String nombre;
    public String tipoAnimal;
    public double precio;
    public int cantidad;



    public Alimentos(String Codigo, String Nombre, String TipoAnimal, double Precio, int Cantidad)
    {
        this.codigo = Codigo;
        this.nombre = Nombre;
        this.tipoAnimal = TipoAnimal;
        this.precio = Precio;
        this.cantidad = Cantidad;

    }
}
