package rek;

import java.util.Scanner;

public class Namb_6 {
    public static void namb_6(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = 1;
        rek(n,n,x,x);
    }

    public static void rek(int n, int N, int x, int x1){
        if (n > 0 && x1 == 1){
            rek(n / 10, N, x * 10, x1);
        } else if (N != 0){
            x /= 10;
            rek(n + (N / x) * x1,N - (N / x) * x, x, x1 * 10);
        } else {
            System.out.println(n);
        }
    }
}
