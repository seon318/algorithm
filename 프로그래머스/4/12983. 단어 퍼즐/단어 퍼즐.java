import java.util.*;

class Solution {
    Set<String> set = new HashSet<>();
    
    public int solution(String[] strs, String t) {
        for (String str : strs) set.add(str);
        int len = t.length();
        int[] dp = new int[len];
        Arrays.fill(dp, 20001);
        String word = "";
        if (set.contains(t.charAt(0)+"")) dp[0] = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 4; j >= 0; j--) {
                if (i >= j && set.contains(t.substring(i - j, i + 1))) {
                    // System.out.println(i - j + " " + (i + 1) + " " + t.substring(i - j, i + 1));
                    if (i - j == 0) dp[i] = 1;
                    else dp[i] = Math.min(dp[i], dp[i - j - 1] + 1);
                }
                
            }
        }
        // System.out.println(Arrays.toString(dp));
        return dp[len - 1] > 20000 ? -1 : dp[len - 1];
    }
    
}