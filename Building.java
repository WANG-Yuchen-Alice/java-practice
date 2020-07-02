import java.util.*;

public class Building {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][]map = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        boolean[] flag = new boolean[1];
        for (int r = 0; r < n; r++) {
            String str = sc.next();
           // System.out.println(str + str.length());
            for (int c = 0; c < m; c++) {
                if (str.charAt(c) == '#') {
                    map[r][c] = 1;
                } else {
                    map[r][c] = 0;
                }
                visited[r][c] = false;
            }
        }

        int color = 1;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                flag[0] = false;
                if (visited[r][c]) {
                    continue;
                }
                paint(map, r, c, n, m, color, visited, flag);
                if (flag[0]) {
                    color ++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 0) {
                    System.out.print('.');
                } else {
                    System.out.print((char)(map[i][j] + 65));
                }
            }
            System.out.println();
        }
    }

    public static void paint(int[][] map, int r, int c, int n, int m, int color, boolean[][]visited, boolean[]flag) {
        if (r >= n || c >= m || map[r][c] == 0) {
            return;
        }
        if (visited[r][c]) {
            return;
        }
        visited[r][c] = true;

        
        map[r][c] = color;
        flag[0] = true;
        paint(map, r, c + 1, n, m, color, visited, flag);
        paint(map, r+1, c, n, m, color, visited, flag);
    }

   
}