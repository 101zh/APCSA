/* Lesson 5 Coding Activity Question 1 */
package Unit3;
import java.util.Scanner;

public class U3_L5_Activity_One {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter 2 integers:");
        int x = scan.nextInt();
        double y = scan.nextDouble();
        double ratio = x / y;
        if (ratio <= 8 && ratio > 1)
            System.out.println("Ratio OK");

        scan.close();
    }
}
