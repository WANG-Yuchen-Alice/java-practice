import java.util.*;

public class Banknotes {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    int a = n / 100;
    n = n - a*100;
    int b = n / 10;
    n = n - b * 10;
    int c = n;
    System.out.println(a + b + c);
    }

}