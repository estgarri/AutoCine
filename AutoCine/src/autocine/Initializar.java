package autocine;

import java.util.Arrays;

public class Initializar {

    public static String[][] cups = new String[4][6];
    public static int f = 0, c = 0;

    public void Initializer()
    {

        for (int f = 0; f < cups.length; f++)
        {
            for (int c = 0; c < cups[0].length; c++)
            {
                //System.out.println(f + c);
                cups[f][c] = ("D");
            }
        }
        //System.out.println("Inicializado");
        //System.out.println(Arrays.deepToString(this.cups));
    }
}
