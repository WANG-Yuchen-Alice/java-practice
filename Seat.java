import java.util.*;

public class Seat {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[] chop = new boolean[m];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashSet<Integer> set = new HashSet<>();
        int[] q = new int[n];
        for (int i = 0; i < n; i++) {
            q[i] = sc.nextInt();

        }
        for (int j = 0; j < m; j++) {
            chop[j] = false;
            pq.add(j+1);
        }
        for (int i = 0; i < n; i++) {
            int seat = q[i];
            if (!chop[seat-1]) {
                set.add(seat);
                if (i == 0) {
                    System.out.print(seat);
                } else {
                    System.out.print(" " + seat);
                }
            } else {
                seat = pq.remove();
                while(set.contains(seat)) {
                    seat = pq.remove();
                }
                if (i == 0) {
                    System.out.print(seat);
                } else {
                    System.out.print(" " + seat);
                }
            }
            chop[seat-1] = true;

        }
        System.out.println();
    }

   
}