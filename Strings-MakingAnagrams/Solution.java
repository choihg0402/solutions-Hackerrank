import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        
        int[] alphabet = new int[26];
        char[] aArray = a.toCharArray();
        char[] bArray = b.toCharArray();

        for (char c: aArray) {
            alphabet[c - 'a'] += 1;
        }

        for (char c: bArray) {
            alphabet[c - 'a'] -= 1;
        }

        int count = 0;
        for(int i = 0; i < alphabet.length; i++) {
            count += Math.abs(alphabet[i]);
        }

        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
