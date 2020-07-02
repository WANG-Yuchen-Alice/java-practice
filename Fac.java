public class Fac {
    public static void main(String[] args) {
       
       System.out.println(new Solution().uniquePaths(10, 10));

    }
}
class Solution {
    public int uniquePaths(int m, int n) {
        int a = m - 1;
        int b = n - 1;
        int s = a + b;

        return choose(s, a);
        
    }

    public int choose(int s, int a) {
        if (a <= 1) {
            return s;
        } 
        if (s == a) {
            return 1;
        }
        if (s < a) {
            return -1;
        }

        return choose(s - 1, a) + choose(s - 1, a - 1);
    }
    
    public int fac(int n) {
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
        }
        return res;
    }
}