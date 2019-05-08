import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the isValid function below.
    static String isValid(String s) {
        char[] input = s.toCharArray();
        int[] alphabet = new int[26];
        for (char c : input) {
            alphabet[c - 'a']++;
        }

        List<int[]> list = Arrays.asList(alphabet);
        Collections.reverse(list);
        
        int num = 0;
        int count = 0;
        for (int i : list.get(0)) {
            if (i > 0) {
                if (num == 0) {
                    num = i;
                } else {
                    if (i == 1) {
                        count++;
                    } else {
                        count += Math.abs(num - i);
                    }
                    if (count > 1) {
                        return "NO";
                    }
                }
            }
        }
        if (input.length == 0) {
            return "NO";
        }
        return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
