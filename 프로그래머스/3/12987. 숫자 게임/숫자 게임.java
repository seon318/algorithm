import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int len = A.length;
        int idx = 0;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            if (A[idx++] < B[i]) ans++;
            else idx--;
        }
        return ans;
    }
}