package rek;

import java.util.Scanner;

public class Namb_7 {
    public static void namb_7() {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        int y = 114;
        char[] b = {114,97,100,97,114};
        rek(b,0,0);
    }

    public static void rek(char[] n, int q, int l){
        if (n[q] != 0){
            rek(n,q+1,l+1);
        } else {
            System.out.println("");
        }
    }
}
