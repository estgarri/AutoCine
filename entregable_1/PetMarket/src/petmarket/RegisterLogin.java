/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petmarket;

public class RegisterLogin {

    private String Username;
    private String Password;
    public String Nombre;
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

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }



    public RegisterLogin(String username, String password, String nombre)
    {
        this.Username = username;
        this.Password = password;
        this.Nombre = nombre;

    }

}