import java.util.*;

public class Page {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        sc.close();

        if (a % 2 == 0) {
            System.out.println(-1);
            return;
        }
        if (a == 1) {
            System.out.println(1);
            return;
        } if (a == 3) {
            System.out.println(10 + " " + 11);
            return;
        }

        a = (a-1) / 2;

        if (a <= 8) {
            if (a % 2 == 0) {
                System.out.println(a + " " + (a + 1));
                return;
            } else {
                if (a == 3) {
                    System.out.println(12 + " " + 13);
                } else if (a == 5) {
                    System.out.println(14 + " " + 15);
                } else {
                    System.out.println(16 + " " + 17);
                }
                return;
            }
        } else {
            a = a - 8;
            int nines = a / 9;
            int res = a - nines * 9;
            String one = "" + res;
            for (int i = 1; i <= nines; i++) {
                
                one += "9";
            }
            String two = one + "9";
            one += "8";
            System.out.println(one + " " + two);
        }


    }

   
}