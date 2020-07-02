import java.util.*;

public class Point {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[]arr = new int[n];
        int[] res = new int[n];
        int[] temp = new int[n+1];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            map.put(arr[i], i);
            temp[i] = -1;
        }
        temp[n] = -1;
        Arrays.sort(arr);

        int cnt = -1;

        for (int i = 0; i < n; i++) {
            int thisOne = arr[i];
            //System.out.println(" thisone; " + thisOne);
            for (int j = 1; j < n+1; j++) {
                
                if (temp[j] == -1 || Math.abs(temp[j] - thisOne) >= k) {
                   // System.out.println("temp[j]: " + temp[j]);
                    temp[j] = thisOne;
                    res[map.get(thisOne)] = j;
                    cnt = Math.max(cnt, j);
                    //System.out.println(j + " " + thisOne);
                    break;
                }
            }
        }

        System.out.println(cnt);
        

        for (int i = 0; i < n-1; i++) {
            System.out.print(res[i] + " ");

        }
        System.out.println(res[n-1]);


    }

   
}