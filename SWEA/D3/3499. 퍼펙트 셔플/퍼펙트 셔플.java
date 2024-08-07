import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;
		int t = Integer.parseInt(br.readLine());
		int n;
		Queue<String> q1 = new LinkedList<>();
		Queue<String> q2 = new LinkedList<>();
		
		for (int tc = 1; tc <= t; tc++) {
			sb = new StringBuilder();
			n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n/2 + n%2; i++) {
				q1.add(st.nextToken());
			}
			for (int i = 0; i < n/2; i++) {
				q2.add(st.nextToken());
			}
			sb.append("#").append(tc).append(" ");
			while (!q1.isEmpty() || !q2.isEmpty()) {
				if (!q1.isEmpty()) sb.append(q1.poll() + " ");
				if (!q2.isEmpty()) sb.append(q2.poll() + " ");
			}
			System.out.println(sb);
		}
	}
}
