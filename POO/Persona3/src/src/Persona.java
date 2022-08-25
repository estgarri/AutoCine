import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class Persona {
    private String nombre;
    private String mail;
    private int edad;
    private LocalDate fechaNacimiento;

    public Persona(){

    }

    public Persona(String nombre,String mail){
        setNombre(nombre);
        this.mail = mail;
    }

    public LocalDate getFechaNacimiento(){
        return fechaNacimiento;
    }
    public void setFechaNacimiento(int mes, int dia, int year){
        this.fechaNacimiento = LocalDate.of(year,mes,dia);
        //calcular la edad y asignarla al atributo edad.
        this.edad = Period.between(this.fechaNacimiento,LocalDate.now()).getYears();
    }
    public String getNombre(){
        return this.nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getMail() {
        return this.mail;
    }
    public void setMail(String mail){
        this.mail = mail;
    }
    public int getEdad(){
        return edad;
    }

}
