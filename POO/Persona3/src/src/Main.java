import java.io.*;
import java.time.LocalDate;

public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;
    public static void main(String[] args)  throws IOException{

        Persona tmpPersona;
        tmpPersona = new Persona();
        out.println(tmpPersona.getEdad());
        out.println("Digite el nombre");
        String name = in.readLine();
        out.println("Digite el correo electrónico");
        String email = in.readLine();
        out.println("digite el día de su nacimiento");
        int dia = Integer.parseInt(in.readLine());
        out.println("Digite el mes de su nacimiento");
        int mes = Integer.parseInt(in.readLine());
        out.println("Digite el año de su nacimiento");
        int year = Integer.parseInt(in.readLine());
        tmpPersona.setFechaNacimiento(mes,dia,year);
        tmpPersona.setMail(email);
        tmpPersona.setNombre(name);
        out.println("Edad " + tmpPersona.getEdad());
        //creo otra persona usando el otro constructor.
        out.println("Digite el nombre de la otra persona");
        String nombre = in.readLine();
        out.println("Digite el correo de la otra persona");
        String correo = in.readLine();
        tmpPersona = new Persona(nombre,correo);
    }
}