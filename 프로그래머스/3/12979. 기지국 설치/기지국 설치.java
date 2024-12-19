class Solution {
    public int solution(int n, int[] stations, int w) {
        int idx = 0;
        int now = 1;
        int len = stations.length;
        int answer = 0;
        while (now <= n) {
            if (idx < stations.length && stations[idx] - w <= now) {
                now = stations[idx] + w + 1;
                idx++;
            } else {
                answer++;
                now += (2 * w + 1);
            }
//             int start = idx;
//             int end = len;
//             while (start < end) {
//                 System.out.println(start + " " + end);
//                 idx = (start + end + 1) / 2;
//                 if (idx >= now) start = idx + 1;
//                 else end = idx - 1;
                    
//             }
        }

        return answer;
    }
}