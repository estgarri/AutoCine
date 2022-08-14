public class ClienteCarrito {

    public ClienteCarrito(String nombre, String apellidos, String email, int cedula) {
        this.Nombre = nombre;
        this.Apellidos = apellidos;
        this.Email = email;
        this.Cedula = cedula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }
    public int getCedula() {
        return Cedula;
    }
    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setCedula(int cedula) {
        Cedula = cedula;
    }

    public String Nombre, Apellidos, Email;
    public int Cedula;


}
