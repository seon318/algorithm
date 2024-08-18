import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int n, total, ans;
    static int[] weights;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());

            weights = new int[n];
            total = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                weights[i] = Integer.parseInt(st.nextToken());
                total += weights[i];
            }

            dp = new int[1 << n][total + 1];
            ans = solve(0, 0, 0);

            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }

    static int solve(int bitmask, int left, int right) {
        if (bitmask == (1 << n) - 1) {
            return 1;
        }

        if (dp[bitmask][left] != 0) {
            return dp[bitmask][left];
        }

        int res = 0;

        for (int i = 0; i < n; i++) {
            if ((bitmask & (1 << i)) != 0) continue;

            res += solve(bitmask | (1 << i), left + weights[i], right);

            if (left >= right + weights[i]) {
                res += solve(bitmask | (1 << i), left, right + weights[i]);
            }
        }

        dp[bitmask][left] = res;
        return res;
    }
}
