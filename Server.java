import java.util.*;

public class Server {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        for (int c = 1; c <= a; c++) {
            int s = sc.nextInt();
            int n = sc.nextInt();
            int[] arr = new int[s];
            for (int i = 0; i < s; i++) {
                arr[i] = sc.nextInt();
            }
            solve(arr, s, n, c);
        }
        sc.close();
    }

    public static void solve(int[] arr, int s, int n, int c) {
        int res = 0;
        boolean[] got = new boolean[arr.length];
        int[] temp = new int[arr.length];
        HashMap<Integer, HashSet<Integer>> index = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> index_arr = new HashMap<>();
        HashMap<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
            if (index.containsKey(arr[i])) {
                index.get(arr[i]).add(i);
                index_arr.get(arr[i]).add(i);
            } else {
                index.put(arr[i], new HashSet<Integer>());
                index_arr.put(arr[i], new ArrayList<Integer>());
                index.get(arr[i]).add(i);
                index_arr.get(arr[i]).add(i);
            }
            if (cnt.containsKey(arr[i])) {
                int val = cnt.get(arr[i]);
                cnt.put(arr[i], (val + 1));

            } else {
                cnt.put(arr[i], 1);

            }

        }
        Arrays.sort(temp);
        int marker = 0;

        while (n > 0) {
            int price = temp[marker];
            //System.out.println("n: " + n + " price: " + price);

            for (int j = marker; j < arr.length; j++) {
                if (!cnt.containsKey(price) || cnt.get(price) == 0) {
                    marker ++;
                    continue;
                } else {
                    price = temp[marker];
                    marker ++;
                    //System.out.println("get price: " + price);
                    break;
                }

            }
           
            if (marker >= arr.length) {
                break;
            }
                
                n--;

                res += price;

                if (n <= 0) {
                    
                    break;
                }

                

                int num = cnt.get(price);
                cnt.put(price, num - 1);

                int indice = new ArrayList<Integer>(index.get(price)).get(0);

                index.get(price).remove(indice);
             
                got[indice] = true;

                int val1 = 0;
                int val2 = 0;

                if (indice > 0) {
                    val1 = arr[indice - 1];

                }

                if (indice < arr.length - 1) {
                    val2 = arr[indice + 1];
                }

                if (val1 > val2) {
                    got[indice - 1] = true;
                    index.get(val1).remove(indice - 1);
                    cnt.put(val1, cnt.get(val1)-1);
                    
                } else {
                    got[indice + 1] = true;
                    index.get(val2).remove(indice + 1);
                    cnt.put(val2, cnt.get(val2)-1);
                }

                n--;
                //System.out.println("n: " + n);

            

        }

        System.out.println("Case " + c + ": " + res);
    }

   
}