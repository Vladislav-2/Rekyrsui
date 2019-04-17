package we;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        switch (i){
            case 1:
                Namb_1.namb_1();
                break;
            case 2:
                Namb_2.namb_2();
                break;
            case 3:
                Namb_3.namb_3();
                break;
            case 4:
                Namb_4.Namb_4();
                break;
            case 5:
                Namb_5.namb_5();
                break;
            case 6:
                Namb_6.namb_6();
                break;
            case 7:
                Namb_7.namb_7();
                break;
            case 8:
                Namb_8.namb_8();
                break;
            case 9:
                Namb_9.namb_9();
                break;
            case 10:
                Namb_10.namb_10();
                break;
            case 11:
                Namb_11.namb_11();
                break;
            case 12:
                Namb_12.namb_12();
                break;
                default:
                    System.out.println("Error: Задача не найдена");
        }
    }
}
