import java.util.*;

public class Elevator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        int m = sc.nextInt();
        int sum = x + y + z;


        if (sum <= m) {
            System.out.println("1");
        } else if (sum - x <= m || sum - y <= m || sum - z <= m) {
            System.out.println("2");
        } else {
            System.out.println("3");
        }
    }
}