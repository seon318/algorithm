import java.util.*;

class Solution {
    int m, n, answer;
    int MOD = 20170805;
    
    public int solution(int m, int n, int[][] cityMap) {
        int[][][] arr = new int[m][n][2];
        
        for (int i = 1; i < m; i++) {
            if (cityMap[i][0] == 1) break;
            arr[i][0][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            if (cityMap[0][i] == 1) break;
            arr[0][i][1] = 1;
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (cityMap[i][j] == 1) continue;
                switch (cityMap[i-1][j]) {
                    case 0:
                        arr[i][j][0] += arr[i-1][j][1];
                    case 2:
                        arr[i][j][0] += arr[i-1][j][0];
                }
                
                switch (cityMap[i][j-1]) {
                    case 0:
                        arr[i][j][1] += arr[i][j-1][0];
                    case 2:
                        arr[i][j][1] += arr[i][j-1][1];
                }
                arr[i][j][0] %= MOD;
                arr[i][j][1] %= MOD;
            }
        }
        
        int answer = (arr[m-1][n-1][0] + arr[m-1][n-1][1]) % MOD;

        return answer;
    }

}