import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		char x;
		int n;
		int t = Integer.parseInt(br.readLine());
		Deque<Character> q = new ArrayDeque<>();

		for (int i = 0; i < t; i++) {
			n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			q.addFirst(st.nextToken().charAt(0));
			
			for (int j = 0; j < n - 1; j++) {
				x = st.nextToken().charAt(0);
				if (q.getFirst() >= x) q.addFirst(x);
				else q.addLast(x);
			}
			
			while (!q.isEmpty()) {
				System.out.print(q.pollFirst());
			}
			System.out.println();
		}
	}
}
