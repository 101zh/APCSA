/* Lesson 6 Coding Activity Question 2 */
package Unit3;

import java.util.Scanner;

public class U3_L6_Activity_Two
{
  public static void main(String[] args)
  {

    Scanner scan = new Scanner(System.in);
    int x = scan.nextInt();
    int y = scan.nextInt();
    
    if(!(y>9) || (!(x<=2) && x*y>10))
      System.out.println("pass");

    scan.close();
  }
}
