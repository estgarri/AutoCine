public class String_Array_iterate {


    public static void main(String[] args) {
        String s = "Techie, Delight, test";

        String[] arr = s.split(",");

        for (String ch : arr) {
            System.out.print(ch);
        }
    }
}