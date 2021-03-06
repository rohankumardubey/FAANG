import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.StringTokenizer;

/*

Problem Description
Task. Given two non-negative integers ๐ and ๐, where ๐ โค ๐, find the last digit of the sum ๐น๐ + ๐น๐+1 +
ยท ยท ยท + ๐น๐.
Input Format. The input consists of two non-negative integers ๐ and ๐ separated by a space.
Constraints. 0 โค ๐ โค ๐ โค 1014
.
Output Format. Output the last digit of ๐น๐ + ๐น๐+1 + ยท ยท ยท + ๐น๐.
Sample 1.
Input:
3 7
Output:
1
๐น3 + ๐น4 + ๐น5 + ๐น6 + ๐น7 = 2 + 3 + 5 + 8 + 13 = 31.
Sample 2.
Input:
10 10
Output:
5
๐น10 = 55.
Sample 3.
Input:
10 200
Output:
2
๐น10 + ๐น11 + ยท ยท ยท + ๐น200 = 734 544 867 157 818 093 234 908 902 110 449 296 423 262
 */
public class Week2FibonacciLastDigitOfSumOfSquare {
    public static void main(String[] args) {
        FastScan scan = new FastScan();
        long fibonacciNumber = scan.nextLong();
        LocalDateTime startTime = LocalDateTime.now();
        System.out.println(getFibonacciLastDigitOfSquareSum(fibonacciNumber));
        System.out.println("Time took to complete (in sec) is: " + ChronoUnit.SECONDS.between(startTime, LocalDateTime.now()));
    }

    private static int getFibonacciLastDigitOfSquareSum(long fibonacciNumber) {
        BigDecimal fistNumber = BigDecimal.ONE;
        BigDecimal secondNumber = BigDecimal.ZERO;
        BigDecimal fibNumber = BigDecimal.ONE;
        int sumLastDigit = 1;
        for (int i = 2; i <= fibonacciNumber; i++) {
            fibNumber = fistNumber.add(secondNumber);
            sumLastDigit = getSquareLastDigit(fibNumber);
            secondNumber = fistNumber;
            fistNumber = fibNumber;
        }
        return sumLastDigit;
    }

    private static int getSquareLastDigit(BigDecimal fib) {
        return getLastDigit(fib.multiply(fib).toString());
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
