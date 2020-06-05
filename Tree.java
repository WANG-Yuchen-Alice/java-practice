import java.util.*;

public class Tree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        while (a != b) {
            if (a > b) {
                a = a / 2;
            } else {
                b = b / 2;
            }

        }
        System.out.println(a);

    }
}