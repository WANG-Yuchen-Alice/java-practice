import java.util.*;

public class Chessboard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int b = sc.nextInt();
        int sum = 0;
        int res = 0;

        if (w == b) {
            sum = w + b;
        } else {
            int v = Math.min(w, b);
            sum = v + v + 1;
        }

        res = (int) Math.sqrt(sum);
        System.out.println(res);

    }
}