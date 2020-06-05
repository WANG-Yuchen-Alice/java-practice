import java.util.*;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int len = str.length();

        //initialize the array
        int[] arr = new int[26];
        int[] left = new int[26];
        int[] right = new int[26];
        for (int i = 0; i < 26; i++) {
            arr[i] = 0;
            left[i] = 0;
            right[i] = 0;
        }

        if (len % 2 == 0) {
            //count the number of letters
            for (int i = 0; i < len; i++) {
                char thisChar = str.charAt(i);
                int index = (int)thisChar - 65;
                arr[index] ++;
                if (i % 2 == 0) { //belong to left
                    left[index] ++;
                } else {
                    right[index] ++;
                }
            }

            if (!checkValid(arr, left, right)) {
                System.out.println("NO");
                return;

            } else {
                produceResult(str, len);
                return;
            }

        } else { //odd number of letters, only one odd permitted
            if (len == 1) {
                System.out.println(str);
                return;
            } else if (len == 3) {
                if (str.charAt(0) == str.charAt(2)) {
                    System.out.println(str);
                } else {
                    System.out.println("NO");
                }
                return;
            }
            //cases where len >= 5 remain to be discussed

            for (int i = 0; i < len; i++) {
                char thisChar = str.charAt(i);
                int index = (int)thisChar - 65;
                arr[index] ++;
            }

            int[] middlePosition = new int[2]; //hope to store at least 1 index for each position
            middlePosition[0] = -1; //represent even
            middlePosition[1] = -1; //represent odd

            char[] strChars = str.toCharArray();

            int middleIndex = len / 2;

            char middleChar = checkOnlyOneOdd(strChars, arr, len, middlePosition);
            //System.out.println("middle char: " + middleChar);
            //System.out.println("middle pos: " + middlePosition[0] + " " + middlePosition[1]);
            if (middleChar == ' ') {
                System.out.println("NO");
                return;
            }

            //move the only odd letter to the middle position
            int k = (len - 1) / 2; //if k is odd, middle index should be odd
            if (k % 2 == 0) { //want middle char at even position
                if (middlePosition[0] == -1) {
                    //System.out.println("want C to be at even position but it is not");
                    System.out.println("NO");
                    return;
                } else {
                    strChars[middlePosition[0]] = strChars[middleIndex];
                    strChars[middleIndex] = middleChar;
                }
            } else { //want middle char at odd position
                if (middlePosition[1] == -1) {
                    System.out.println("NO");
                    return;
                } else {
                    strChars[middlePosition[1]] = strChars[middleIndex];
                    strChars[middleIndex] = middleChar;
                }

            }

            //System.out.println("after swapping, the string: " + new String(strChars));

            for (int i = 0; i < len; i++) {
                char thisChar = strChars[i];
                int index = (int)thisChar - 65;
                //System.out.println("index: " + index);
                if (i < middleIndex) {
                    //System.out.println("left half");
                    if (i % 2 == 0) {
                        //System.out.println("even, go to left");
                        left[index] ++;
                    } else {
                        //System.out.println("odd, go to right");
                        right[index] ++;
                    }
                } else if (i > middleIndex) {
                    //System.out.println("right half");
                    if (i % 2 != 0) {
                        left[index] ++;
                    } else {
                        right[index] ++;
                    }
                }
            }

            arr[(int)(middleChar - 65)] --; //deduct the one from the middle char counter
            
            // arrToString(arr);
            // arrToString(left);
            // arrToString(right);

            if (!checkValid(arr, left, right)) {
                //System.out.println("not valid");
                System.out.println("NO");
                return;
            } else {
                produceResultOdd(strChars, len);
                return;
            }

        }


    }

    public static boolean checkValid(int[] arr, int[] left, int[]right) {
        //condition for valid: each letter has even appearace, with equal amount in left and right array
        for (int i = 0; i < 26; i++) {
            if (left[i] != right[i]) {
                return false;
            }
        }
        return true;
    }

    public static void produceResult(String str, int len) {  //O(n)
        char[] chars = new char[len];
        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) { //even position, remain untouched
                chars[i] = str.charAt(i);
            } else {
                chars[i] = str.charAt(len-1-i);
            }
        }
        String result = new String(chars);
        System.out.println(result);

    }

    public static char checkOnlyOneOdd(char[] strChars, int[] arr, int len, int[] middlePosition) {
        int counter = 0;
        char res = ' ';
        for (int i = 0; i < len; i++) {
            char thisChar = strChars[i];
            int charNum = (int)thisChar - 65;
            if (arr[charNum] % 2 != 0) {
                counter ++;
                if (counter > 1) {
                    return ' ';
                }
                res = thisChar;
                //System.out.println("find 1 char: " + res);
                if (i % 2 == 0) {
                    //System.out.println("even updated: " + i);
                    middlePosition[0] = i;
                } else {
                    //System.out.println("Odd plus 1");
                    middlePosition[1] = i;
                }
            }

        }
        if (counter == 1) {
            return res;
        }
        return ' ';
    }

    public static void produceResultOdd(char[] strChars, int len) {
        int mid = (len-1)/2;
        char[] temp = new char[mid];
        int j = 0;
        for (int i = 0; i < len; i++) {
            if (i == mid) {
                continue;
            } else if (i < mid) {
                if (i % 2 != 0) {
                    strChars[i] = strChars[len-1-i];
                }
            } else {
                if (i % 2 == 0) {
                    strChars[i] = strChars[len-1-i];
                }
            }
        
        }

        String result = new String(strChars);
        System.out.println(result);
    }

    //for debugging
    public static void arrToString(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len/5; i++) {
            System.out.println(i + " " + arr[i]);
        }

    }
    
}