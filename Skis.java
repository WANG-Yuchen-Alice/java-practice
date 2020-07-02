import java.util.*;

public class Skis {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        int[][] arr = new int[2][n];
        for (int i = 0; i < n; i++) {
            arr[1][i] = i + 1;
            arr[0][i] = sc.nextInt();
        }
        sc.close();
        mergeSort(arr, 0, n-1);
        int count = 0;
        
        ArrayList<String> list = new ArrayList<>();
        for (int m = n-1; m >= 1; m--) {
            if (arr[0][m] - arr[0][m-1] <= k) {
                list.add(arr[1][m] + " " + arr[1][m-1]);
                m --;
                count ++;
            }
        }

        System.out.println(count);
        for (int j = 0; j < list.size(); j++) {
            System.out.println(list.get(j));
        }
        
    }

    public static void mergeSort(int[][]arr, int left, int right) {
        if (right - left <= 0) {
            return;
        }
        int mid = (right - left) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    public static void merge(int[][] arr, int left, int mid, int right) {
        int s1 = mid - left + 1;
        int s2 = right - mid;
        int[][] leftArr = new int[2][s1];
        int[][] rightArr = new int[2][s2];
        int l = 0;
        for (int i = left; i <= mid; i++) {
            leftArr[0][l] = arr[0][i];
            leftArr[1][l] = arr[1][i];
            l++;
        }
        int r = 0;
        for (int i = mid + 1; i <= right; i++) {
            rightArr[0][r] = arr[0][i];
            rightArr[1][r] = arr[1][i];
            r++;
        }
        l = 0;
        r = 0;
        int k = left;
        while (l < s1 && r < s2) {
            if (leftArr[1][l] <= rightArr[1][r]) {
                arr[1][k] = leftArr[1][l];
                arr[0][k] = leftArr[0][l];
                l++;
                k++;
            } else {
                arr[1][k] = rightArr[1][r];
                arr[0][k] = rightArr[0][r];
                r++;
                k++;
            }
        }
        while (l < s1) {
            arr[1][k] = leftArr[1][l];
                arr[0][k] = leftArr[0][l];
                l++;
                k++;
        }
        while (r < s2) {
            arr[1][k] = rightArr[1][r];
                arr[0][k] = rightArr[0][r];
                r++;
                k++;
        }


    }

   
}