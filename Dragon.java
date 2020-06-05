import java.util.*;

public class Dragon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int t = sc.nextInt();
        int doubleH = h / 2;
        for (int i = 1; i <= doubleH; i++) {
            kill2H();
        }
        h = h - 2 * doubleH;

        int doubleT = t/2;
        int twoToneH = Math.min(h, doubleT);
        for (int i = 1; i <= twoToneH; i++) {
            kill2T1H();
        }
        h -= twoToneH;
        t -= 2*twoToneH;

        int oneToneH = Math.min(h, t);
        for (int i = 1; i <= oneToneH; i++) {
            kill1T1H();
        }

        h -= oneToneH;
        t -= oneToneH;

        for (int i = 1; i <= h; i++) {
            kill1H();
        }

        for (int i = 1; i <= t; i++) {
            kill1T();
        }



        

    }

    public static void kill4T() { //3
        System.out.println("TT");
        System.out.println("TT");
        System.out.println("HH");
    }

    public static void kill2H() { //1
        System.out.println("HH");
    }

    public static void kill1H() { //7
        System.out.println("H"); //H - T
        kill1T();
    }

    public static void kill3T() { //4
        System.out.println("T"); //TTT - TTTT
        kill4T();
    }

    public static void kill2T1H() { //2
        System.out.println("TT"); //TTH - HH
        kill2H();
    }

    public static void kill1T1H() { //3
        System.out.println("T"); //TH - TTH
        kill2T1H();
    }

    public static void kill2T() { //5
        System.out.println("T");//TT - TTT
        System.out.println("T"); //TTT - TTTT
        kill4T();
    }

    public static void kill1T() { //6
        System.out.println("T"); //T - TT
        kill2T();
    }
    
}