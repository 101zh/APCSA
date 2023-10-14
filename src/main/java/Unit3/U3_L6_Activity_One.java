/* Lesson 6 Coding Activity Question 1 */
package Unit3;

import java.util.Scanner;

public class U3_L6_Activity_One
{
  public static void main(String[] args)
  {
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter a number in the fifties");
    int num = scan.nextInt();

    if(num < 50 || num >= 60)
    {
      System.out.println("That's not in the fifties!");
      num = 55;
    }
    System.out.println("Your number is " + num);
    
    scan.close();
  }
}
