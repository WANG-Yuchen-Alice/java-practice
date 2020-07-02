import java.util.*;

public class Mayor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        if (m == n) {
            System.out.println(2 * n);
            for (int i = 1; i <= n; i++) {
                System.out.print(i + " ");
            }
            System.out.print(1 + " ");
            for(int i = n; i > 1; i--) {
                System.out.print(i + " ");
            }
            System.out.println(1);
            return;
        } else if (n == m+1) {
            System.out.println(n + n - 1);
            for (int i = 1; i <= n; i++) {
                System.out.print(i + " ");
            }
            for (int i = n - 1; i > 1; i--) {
                System.out.print(i + " ");
            }
            System.out.println(1);
            return;
        }
    }

   
}