/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petmarket;

/**
 *
 * @author estga
 */
public class Usuarios {
    public String Nombre, Apellidos;
    public int Cedula;
    public Rol rol;



    public Usuarios(int cedula, String nombre, String apellidos, Rol rol) {
        this.Cedula = cedula;
        this.Nombre = nombre;
        this.Apellidos = apellidos;
        this.rol = rol;

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
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

}
    
