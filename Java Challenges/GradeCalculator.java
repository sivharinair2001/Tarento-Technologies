import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean grade = true;
        while (grade) {
            System.out.println("Enter the grade");
            int marks = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            if (marks >= 90) {
                System.out.println("Grade A");
            } else if (marks >= 80) {
                System.out.println("Grade B");
            } else if (marks >= 70) {
                System.out.println("Grade C");
            } else if (marks >= 60) {
                System.out.println("Grade D");
            } else {
                System.out.println("Failed (F)");
            }

            System.out.println("Do you want to continue (yes/no)");
            String res = sc.nextLine().toLowerCase();
            if (!res.equals("yes")) {
                grade = false;
            }
        }
        System.out.println("Bye");
        sc.close();
    }
}
