package Unit4;

import java.util.Scanner;

public class U4_L2_Activity_Two {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a positive integer:");
        System.out.print("> ");
        int num = scanner.nextInt();

        int index=0;
        while(num>0){
            System.out.println((num%10)* (int) Math.pow(10, index));
            index++;
            num/=10;
        }

        scanner.close();

    }
}
