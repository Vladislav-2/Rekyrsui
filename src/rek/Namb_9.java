package rek;

import java.util.Scanner;

public class Namb_9 {
    public static void namb_9(){
        Scanner sc = new Scanner(System.in);
        int st = sc.nextInt();
        int end = sc.nextInt();
        rek(st,end,end);
    }

    public static void rek(int st, int end, int sum){
        if (st == end){
            System.out.println(st);
        } else if(st > end) {
            System.out.println("Error: неверный ввод данных");
        } else if(st + 1 == end){
            System.out.println(sum + end -1);
        } else {
            rek(st+1,end,sum + st);
        }
    }
}
