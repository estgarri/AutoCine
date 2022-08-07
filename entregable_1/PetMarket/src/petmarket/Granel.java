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
public class Granel {

    public String nombre;
    public String tipoAnimal;
    public double precio;
    public double kilos;
    public String codigo;

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

    public double getKilos() {
        return kilos;
    }

    public void setKilos(double kilos) {
        this.kilos = kilos;
    }



    public Granel(String Codigo, String Nombre, String TipoAnimal, double Precio, double Kilos)
    {
        this.codigo = Codigo;
        this.nombre = Nombre;
        this.tipoAnimal = TipoAnimal;
        this.precio = Precio;
        this.kilos = Kilos;

    }
}