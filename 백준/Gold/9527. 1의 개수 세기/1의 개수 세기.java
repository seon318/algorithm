import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        int x = Long.toBinaryString(B).length();
        dp = new long[x];
        dp[0] = 1;
        for (int i = 1; i < x; i++) {
            dp[i] = (dp[i - 1] << 1) + (1L << i);
        }

        System.out.println(getCount(B) - getCount(A - 1));
    }

    private static long getCount(long n) {
        long count = n & 1;
        int size = (int) (Math.log(n) / Math.log(2));
        for (int i = size; i > 0; i--) {
            if((n & (1L << i))!=0L){
                count += dp[i - 1] + (n - (1L << i)) + 1;
                n -= (1L << i);
            }

        }
        return count;
    }
}