import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		int n, x;

		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			pq.clear();

			sb.append('#').append(tc).append(' ');

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				if (st.nextToken().equals("1")) {
					pq.add(Integer.parseInt(st.nextToken()));
				} else {
					sb.append(pq.isEmpty() ? -1 : pq.poll()).append(' ');
				}
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}