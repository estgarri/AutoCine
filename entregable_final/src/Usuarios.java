public class Usuarios {

    public String Nombre, Apellidos;
    public int Cedula;
    public Rol Rol;
    private String Username;
    private String Password;



    public Usuarios(int cedula, String nombre, String apellidos, Rol rol, String username, String password) {
        this.Cedula = cedula;
        this.Nombre = nombre;
        this.Apellidos = apellidos;
        this.Rol = rol;
        this.Username = username;
        this.Password = password;

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

    public void setCedula(int cedula) {
        Cedula = cedula;
    }

    public Rol getRol() {
        return Rol;
    }

    public void setRol(Rol rol) {
        this.Rol = rol;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

}
