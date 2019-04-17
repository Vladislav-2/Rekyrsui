package rek;

import java.util.Scanner;

public class Namb_3 {
    public static void namb_3(){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int x = 1;
        rek(N,N,N,x,N);
    }

    public static void rek(int N, int sum, int count, int x, int n){
        if (count == sum){
            if (n != 0){
                rek(N, sum, count, x * 10, n / 10);
            } else {
                sum = 0;
                count = -99999;
                rek(N, sum, count, x / 10, n);
            }
        } else if (N < 10 && N > 0){
            sum += N;
            rek(N / 10, sum, count, x, n);
        } else if (N != 0){
            sum += N / x;
            rek((N - ((N / x) * x)), sum, count, x / 10, n);
        }
        if (N == 0){
            System.out.println(sum);
        }
    }
}
