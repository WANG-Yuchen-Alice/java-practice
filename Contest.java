import java.util.*;

public class Contest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int e = sc.nextInt();
        sc.close();

        int s = Math.min(d, e);
        int A = Math.min(a, b);
        int ans = 0;
        ans += Math.min(A, s);
        s -= ans;
        ans += Math.min(c, s);

        System.out.println(ans);
    }

   
}