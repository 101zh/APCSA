/* Lesson 1 1/2 Coding Activity Question 1 */
package Unit4;

import java.util.Scanner;

public class U4_L1_5_Activity_One
{
  public static void main(String[] args)
  {

    Scanner scan = new Scanner(System.in);
    int num = scan.nextInt();
    int fac = 1;
    while(fac <= 5){
      System.out.println(num*fac);
      fac++;
    }
    
    scan.close();
  }
}