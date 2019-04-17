package rek;

import java.util.Scanner;

public class Namb_2 {
    public static void namb_2(){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        rek(N);
    }

    public static void rek(int N){
        if (N == 2){
            System.out.println("Yes");
        } else if (N > 2 && N % 2 != 1) {
            rek(N / 2);
        } else {
            System.out.println("No");
        }
    }
}
