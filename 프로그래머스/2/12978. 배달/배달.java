import java.util.*;

class Solution {
    final int INF = 500001;
    
    public int solution(int N, int[][] road, int K) {
        List<int[]>[] adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] path : road) {
            int a = path[0] - 1;
            int b = path[1] - 1;
            int c = path[2];
            adj[a].add(new int[] {b, c});
            adj[b].add(new int[] {a, c});
        }

        int[] dist = new int[N];
        Arrays.fill(dist, INF);
        dist[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.add(new int[] {0, 0});
        
         while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int currentNode = now[0];
            int currentDist = now[1];

            if (currentDist > dist[currentNode]) continue;

            for (int[] edge : adj[currentNode]) {
                int nextNode = edge[0];
                int nextDist = currentDist + edge[1];

                if (nextDist < dist[nextNode] && nextDist <= K) {
                    dist[nextNode] = nextDist;
                    pq.add(new int[] {nextNode, nextDist});
                }
            }
         }
        
        int answer = 0;
        for (int d : dist) if (d <= K) answer++;

        return answer;
    }
}