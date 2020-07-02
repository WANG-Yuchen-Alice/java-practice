import java.util.*;

public class Smaller {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] res = new int[n]; //target sequence
        int[] arr = new int[n]; //given sequence
        int[] seq = new int[n]; //0 - (n-1)
        boolean[] flag = new boolean[1];
        boolean[] visited = new boolean[n];
        flag[0] = false;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            seq[i] = i;
            visited[i] = false;
        }
        sc.close();
        
        for (int i = 0; i < n; i++) {
            if (flag[0]) {//already smaller, don't care about the rest, just produce in descending order
                wrapUp(i, visited, res, n);
                break;

            }
            //else still need to keep smaller
            int target = arr[i];
            int thisOne = findEqualOrSmaller(target, visited);
            if (thisOne == -1) {
                System.out.println("-1");
                return;
            } 
            if (thisOne < target) {
                flag[0] = true;
            }
            res[i] = thisOne;

        }
        if (!flag[0]) {
            System.out.println("-1");
        } else {
            printOutRes(res);
        }

    }

    public static int findEqualOrSmaller(int target, boolean[] visited) {
        for (int j = target; j >= 0; j--) {
            if (!visited[j]) {
                visited[j] = true;
                return j;
            }
        }
        return -1;
    }

    public static void wrapUp(int i, boolean[] visited, int[]res, int n) {
        int marker = i; //fill in the res from the current position
        for (int j = n-1; j >= 0; j--) {
            if (!visited[j]) {
                res[marker] = j;
                visited[j] = true;
                marker ++;
                if (marker > n) {
                    break;
                }
            }

        }
    }

    public static void printOutRes(int[] res) {
        System.out.print(res[0]);

        for (int j = 1; j < res.length; j++) {
            System.out.print(" " + res[j]);
        }
        
        System.out.println();
    }
}