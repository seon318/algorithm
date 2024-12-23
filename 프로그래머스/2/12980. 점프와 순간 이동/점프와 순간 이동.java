import java.util.*;

public class Solution {
    
    public int solution(int n) {
        int ans = 1;
        int num = n;
        while (num > 1) {
            if (num % 2 == 0) num /= 2;
            else {
                num -= 1;
                ans++;
            }
        }
        return ans;
    }
}