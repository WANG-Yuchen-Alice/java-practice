import java.util.*;

public class Road {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] cnt = new int[n];
        HashMap<Integer, ArrayList<Integer>> bigList = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            cnt[i] = 0;
        }

        for (int i = 0; i < n; i++) {
            int thisOne = sc.nextInt();
            cnt[thisOne]++;
            if (bigList.containsKey(thisOne)) {
                bigList.get(thisOne).add(i+1);
            } else {
                bigList.put(thisOne, new ArrayList<Integer>());
                bigList.get(thisOne).add(i+1);
            }
        }

        boolean isEmpty = true;

        int max = 0;

        for (int i = 0; i < n; i++) {
            if (i == 0 && cnt[i] != 1) {
                System.out.println("NO");
                return;
            }
            if (i == 0 && cnt[i] == 1) {
                continue;
            }
            if (cnt[i] == 0) {
                if (!isEmpty) {
                    System.out.println("NO");
                    return;
                }
            } else {
                if (cnt[i] > (int)Math.pow(2, i)) {
        
                    System.out.println("NO");
                    return;
                }
                if (cnt[i] > cnt[i-1] * 2) {
                    System.out.println("NO");
                    return;
                }
                max = Math.max(max, i);

            }
            
        }
        System.out.println("YES");

        int a = 0;
        while (a <= max - 1) {
            int b = a + 1;
            int s1 = bigList.get(a).size();
            int s2 = bigList.get(b).size();
            int j = 0;
            for (int i = 0; i < s1; i++) {
                if (j < s2) {
                    System.out.println(bigList.get(a).get(i) + " " + bigList.get(b).get(j));
                    j++;
                    if (j < s2){
                        System.out.println(bigList.get(a).get(i) + " " + bigList.get(b).get(j));
                        j++;
                    }
                }
            
            }
            a++;

        }
       
    }

   
}