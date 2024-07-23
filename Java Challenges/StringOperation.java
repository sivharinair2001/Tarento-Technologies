import java.util.Scanner;

public class StringOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String");
        String st = sc.nextLine();

        System.out.println("The length of the string is " + st.length());
        System.out.println("The string in UpperCase: " + st.toUpperCase());

        System.out.println("The Substring from the inputted string is " + st.substring(4,11));

        char oldchar = 'a';
        char newchar = 'e';

        String newstring = st.replace(oldchar,newchar);

        System.out.println("The New string is " + newstring);
    }
}
