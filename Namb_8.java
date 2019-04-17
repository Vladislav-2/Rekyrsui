package we;

import java.util.Scanner;

public class Namb_8 {
    static int ch;
    public static void namb_8(){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        ch = m;
        rek(m,n);
    }

    public static void rek(int m, int n){
        if (n > 1){
            rek(m * ch, n - 1);
        } else if (n == 0) {
            rek(0, 1);
        } else if (ch == 0){
            System.out.println(1);
        } else {
            System.out.println(m);
        }
    }
}
