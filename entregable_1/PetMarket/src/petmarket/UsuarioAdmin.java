/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petmarket;

public class UsuarioAdmin {
    private static String UserAdmin = "Admin";
    private static String PassAdmin = "123";


    public String getPassAdmin()
    {
        return PassAdmin;
    }

    public String getUserAdmin()
    {
        return UserAdmin;
    }

    public void setPassAdmin(String Pass) { PassAdmin = Pass;}

    public void setUserAdmin(String User) { UserAdmin = User;}


}
