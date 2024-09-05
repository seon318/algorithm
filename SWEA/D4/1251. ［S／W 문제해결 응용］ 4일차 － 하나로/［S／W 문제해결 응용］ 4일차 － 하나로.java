import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static class Tunnel implements Comparable<Tunnel>{
		int V;
		long W;

		public Tunnel(int v, long l) {
			super();
			V = v;
			W = l;
		}

		@Override
		public String toString() {
			return "Island [V=" + V + ", W=" + W + "]";
		}

		@Override
		public int compareTo(Tunnel o) {
			return this.W < o.W ? -1 : 1;
		}
	}

	static int N, pick;
	static long L, diffX, diffY, ans;
	static double E;
	static List<Tunnel>[] tunnels;
	static long[][] islands;
	static boolean[] visited;
	static PriorityQueue<Tunnel> pq = new PriorityQueue<>();
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			islands = new long[N][2];
			tunnels = new ArrayList[N];
			visited = new boolean[N];
			
			for (int i = 0; i < N; i++) {
				tunnels[i] = new ArrayList<Tunnel>();
			}
			
			st =  new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				islands[i][0] = Integer.parseInt(st.nextToken());
			}
			
			st =  new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				islands[i][1] = Integer.parseInt(st.nextToken());
			}
			
			E = Double.parseDouble(br.readLine());
			
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					diffX = islands[i][0] - islands[j][0];
					diffY = islands[i][1] - islands[j][1];
					L = diffX * diffX + diffY * diffY;
					tunnels[i].add(new Tunnel(j, L));
					tunnels[j].add(new Tunnel(i, L));
				}
			}
			
			visited[0] = true;
			ans = 0;
			pick = 1;
			
			pq.clear();
			pq.addAll(tunnels[0]);
			
			while (pick != N) {
				Tunnel t = pq.poll();
				if (visited[t.V]) continue; //이미 뽑았다면
				ans += t.W; //비용 추가
				visited[t.V] = true; //방문체크
				pick++;
				pq.addAll(tunnels[t.V]);
			}
			
			ans = Math.round(ans * E);
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	
	}
}