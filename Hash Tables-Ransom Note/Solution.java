import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        Map<String, Integer> magazineMap = new HashMap<String, Integer>();
        
        for (String m : magazine) {
            int count = 0;
            if (magazineMap.get(m) != null) {
                count = magazineMap.get(m);
            }
            count++;
            magazineMap.put(m, count);
        }

        boolean isNo = false;
        for (String n : note) {
            if (magazineMap.get(n) == null) {
                System.out.printf("No");
                isNo = true;
                break;
            } else {
                int count = magazineMap.get(n);
                count--;
                if (count < 0) {
                    System.out.printf("No");
                    isNo = true;
                    break;
                }
                magazineMap.put(n, count);
            }
        }
        if (!isNo) {
            System.out.printf("Yes");
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
