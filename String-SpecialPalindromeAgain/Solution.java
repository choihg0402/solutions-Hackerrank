import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the substrCount function below.
    static long substrCount(int n, String s) {
        long count = 0;
        char[] array = s.toCharArray();

        for (int i = 0; i < array.length; i++) {
            char ch = array[i];
            int sum = 0;
            int index = 0;
            boolean isInterupt = false;
            count++;
            index++;
            if (i == array.length - 1) {
                break;
            }
            for (int j = i + 1; j < array.length; j++) {
                if (ch == array[j]) {
                    if (isInterupt) {
                        index--;
                        if (index == 0) {
                            count++;
                            break;
                        }
                    } else {
                        count++;
                        index++;
                    }
                } else {
                    if (isInterupt) {
                        break;
                    } else {
                        isInterupt = true;
                    }
                }
            }
        }

        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        long result = substrCount(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
