package we;

import java.util.Scanner;

public class Namb_1 {
    public static void namb_1(){
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        rek(A,B);
    }

    static void rek (int A, int B) {
        if (A > B){
            if (A - 1 == B){
                System.out.println(A + " " + B);
            } else {
                System.out.print(A + " ");
                rek(A-1,B);
            }
        }
        else if (A < B){
            if (A + 1 == B){
                System.out.println(A + " " + B);
            } else {
                System.out.print(A + " ");
                rek(A+1,B);
            }
        }
        else{
            System.out.println("Error: числа одинаковы");
        }
    }
}
