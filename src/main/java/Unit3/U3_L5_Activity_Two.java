/* Lesson 5 Coding Activity Question 2 */
package Unit3;

import java.util.Scanner;

public class U3_L5_Activity_Two {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter two numbers:");
        int a = scan.nextInt();
        int b = scan.nextInt();

        if (b == 0)
            System.out.println(b + " is not a factor of " + a);
        else if (a % b == 0)
            System.out.println(b + " is a factor of " + a);
        else
            System.out.println(b + " is not a factor of " + a);

        scan.close();
    }
}
