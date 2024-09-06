import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int n, start, x, y, now, ans;
	static List<Integer>[] contact;
	static List<Integer> item;
	static Queue<Integer> queue;
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10 ; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			contact = new ArrayList[101];
			visited = new boolean[101];
			
			for (int i = 0; i < 101; i++) {
				contact[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n/2; i++) {
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				contact[x].add(y);
			}
						ans = start;
			queue = new LinkedList<>();
			queue.add(start);
			visited[start] = true;
			while (true) {
				while (!queue.isEmpty()) {
					item = contact[queue.poll()];
					for (int i = 0; i < item.size(); i++) {
						now = item.get(i);
						if (visited[now]) continue;
						visited[now] = true;
						pq.add(now);
					}
				}
				if (pq.isEmpty()) break;
				while (!pq.isEmpty()) {
					ans = pq.peek();
					queue.add(pq.poll());
				}
			}
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
	
}