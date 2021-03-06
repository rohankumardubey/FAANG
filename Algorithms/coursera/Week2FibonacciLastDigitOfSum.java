import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

/*

Problem Description
Task. Given an integer ๐, find the last digit of the sum ๐น0 + ๐น1 + ยท ยท ยท + ๐น๐.
Input Format. The input consists of a single integer ๐.
Constraints. 0 โค ๐ โค 1014
.
Output Format. Output the last digit of ๐น0 + ๐น1 + ยท ยท ยท + ๐น๐.
Sample 1.
Input:
3
Output:
4
๐น0 + ๐น1 + ๐น2 + ๐น3 = 0 + 1 + 1 + 2 = 4.
Sample 2.
Input:
100
Output:
5
The sum is equal to 927 372 692 193 078 999 175, the last digit is 5.
0 1 1 2 3
 */
public class Week2FibonacciLastDigitOfSum {
    public static void main(String[] args) {
        FastScan scan = new FastScan();
        long fibonacciNumber = scan.nextLong();
        System.out.println(getFibonacciLastDigitOfSum(fibonacciNumber));
    }

    private static int getFibonacciLastDigitOfSum(long fibonacciNumber) {
        BigDecimal fistNumber = BigDecimal.ONE;
        BigDecimal secondNumber = BigDecimal.ZERO;
        BigDecimal fibNumber = BigDecimal.ONE;
        int sumLastDigit = 1;

        if (fibonacciNumber == 0) {
            return 0;
        }
        if (fibonacciNumber == 1) {
            return 1;
        }
        for (int i = 2; i <= fibonacciNumber; i++) {
            fibNumber = fistNumber.add(secondNumber);
            sumLastDigit = getLastDigit(sumLastDigit + getLastDigit(fibNumber.toString()));
            secondNumber = fistNumber;
            fistNumber = fibNumber;
        }
        return sumLastDigit;
    }

    private static int getLastDigit(int number) {
        String value = String.valueOf(number);
        return Integer.parseInt(String.valueOf(value.charAt(value.length() - 1)));
    }

    private static int getLastDigit(String number) {
        return Integer.parseInt(String.valueOf(number.charAt(number.length() - 1)));
    }

    static class FastScan {
        BufferedReader br;
        StringTokenizer st;

        FastScan() {
            try {
                br = new BufferedReader(new
                        InputStreamReader(System.in));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        FastScan(InputStream stream) {
            try {
                br = new BufferedReader(new
                        InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
