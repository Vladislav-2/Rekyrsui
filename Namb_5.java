package we;

import java.util.Scanner;

public class Namb_5 {
    public static void namb_5(){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int x = 1;
        rek(N,N,x);
    }

    public static void rek(int N,int n, int x){
        if (n > 0){
            rek(N,n / 10, x * 10);
        } else if(N != 0){
            x = x / 10;
            System.out.print(N / x + " ");
            rek(N - (N / x) * x, n, x);
        }
    }
}
