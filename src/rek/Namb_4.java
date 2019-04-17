package rek;

import java.util.Scanner;

public class Namb_4 {
    public static void Namb_4(){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        rek(N);
    }

    public static void rek(int N){
        if (N != 0) {
            System.out.print(N % 10 + " ");
            rek(N / 10);
        }
    }
}
