import java.util.*;

public class Unsorted {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.close();
        
        if (k <= 2) {
            System.out.println(-1);
            return;
        }

        if (n % 2 == 0) { //even
            int mid = n / 2;
            for (int i = 1; i < mid; i++) {
                System.out.print(i + " " );
                System.out.print(n - i + 1 + " ");
            }
            System.out.print(mid + " " + (mid+1));

        } else {
            int mid = n / 2 + 1;
            for (int i = 1; i < mid; i++) {
                System.out.print(i + " " );
                System.out.print(n - i + 1 + " ");
            }
            System.out.print(mid);
        }
        System.out.println();
    }

   
}