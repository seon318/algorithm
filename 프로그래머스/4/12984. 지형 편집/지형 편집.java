public class Solution {
    int[][] landArr;
    int p;
    int q;
    
    public long solution(int[][] land, int P, int Q) {
        landArr = land;
        p = P;
        q = Q;
                
        int left = 1000000000;
        int right = 0;
        int mid = 0;
        
        //left를 최솟값, right를 최댓값으로 갱신
        for (int[] arr: land) {
            for (int x : arr) {
                if (left > x) left = x;
                if (right < x) right = x;
            }
        }
        
        while (left < right) {
            mid = (left + right) / 2;
            if (calculateCost(mid) > calculateCost(mid + 1)) left = mid + 1;
            else right = mid;
        }
        
        long answer = calculateCost(left);
        return answer;
    }
    
    //비용 계산 함수
    long calculateCost(long height) {
        long sum = 0;
        for (int[] arr : landArr) {
            for (int x : arr) {
                if (x < height) sum += (height - x) * p;
                else if (x > height) sum += (x - height) * q;
            }
        }
        return sum;
    }
}