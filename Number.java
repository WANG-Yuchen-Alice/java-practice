import java.util.*;

public class Number {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        sc.close();

        int ans = 0;

        int gp = a / 9;
        ans += 21 * gp;

        int res = a - 9 * gp;

        if (res == 0) {
            System.out.println(ans);
            return;
        } else if (res == 1) {
            System.out.println(ans + 3);
            return;
        } else if (res == 2) {
            System.out.println(ans + 6);
            return;
        } else if (res == 3) {
            System.out.println(ans + 7);
            return;
        } else if (res == 4) {
            System.out.println(ans + 9);
            return;
        } else if (res == 5) {
            System.out.println(ans + 12);
            return;
        } else if (res == 6) {
            System.out.println(ans + 14);
            return;
        } else if (res == 7) {
            System.out.println(ans + 15);
            return;
        } else if (res == 8) {
            System.out.println(ans + 18);
            return;
        }
       
    }

   
}