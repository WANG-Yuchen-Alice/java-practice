import java.util.*;
import java.io.*;

public class Conformity {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        String key;
        HashMap<String, Integer> map = new HashMap<>();
        
        String num_str = reader.readLine();
        int num = Integer.valueOf(num_str);

        int num_max = 0;

        for (int n = 0; n < num; n++) {
            line = reader.readLine();
            key = lineToKey(line);
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
            num_max = Math.max(num_max, map.get(key));
        }

        int ans = 0;

        Iterator hmIterator = map.entrySet().iterator();
        while (hmIterator.hasNext()) { 
            Map.Entry mapElement = (Map.Entry)hmIterator.next(); 
            if ((int)mapElement.getValue() == num_max) {
                ans += num_max;
            }
        } 

        System.out.println(ans);
        
    }

    public static String lineToKey(String line) {
        String[] strs = line.trim().split(" ");
        int[] mods = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            mods[i] = Integer.valueOf(strs[i]);
        }
        Arrays.sort(mods);
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < strs.length; i++) {
            sb.append(mods[i] + " ");
        }
        return sb.toString().trim();
    }
}