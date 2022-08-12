public class Clientes {

    public String Nom;
    public String Apell;

    public String Email;

    public int Ced;


    public Clientes(int ced, String nom, String apell, String email) {
        this.Ced = ced;
        this.Nom = nom;
        this.Apell = apell;
        this.Email = email;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getApell() {
        return Apell;
    }

    public void setApell(String apell) {
        Apell = apell;
    }

    public int getCed() {
        return Ced;
    }

    public void setCed(int ced) {
        Ced = ced;
    }

    public String getEmail() {        return Email;    }

    public void setEmail(String email) {        Email = email;    }
}
