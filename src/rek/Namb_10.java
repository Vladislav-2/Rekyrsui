package rek;

import java.util.Scanner;

public class Namb_10 {
    public static void namb_10(){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int i = 1;
        rek(m,n,i,i);
    }

    public static void rek(int m, int n, int i, int u){
        if (m == n){
            System.out.println(m);
        } else if(m <= 0 || n <= 0){
            System.out.println("Error: неправельный ввод данных");
        } else if(m % i == 0 && n % i == 0){
            rek(m,n,i + 1, i);
        } else if(i < m && i < n){
            rek(m,n,i + 1, u);
        } else {
            System.out.println(u);
        }
    }
}
