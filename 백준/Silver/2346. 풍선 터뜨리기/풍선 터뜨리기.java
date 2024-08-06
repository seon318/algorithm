import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		Deque<Integer> dq = new ArrayDeque<>();
		int x;

		for (int i = 1; i <= n; i++) {
			dq.addLast(i);
			arr[i] = Integer.parseInt(st.nextToken());
		}

		while (!dq.isEmpty()) {
			x = dq.pollFirst();
			System.out.print(x + " ");
			if (dq.isEmpty())  break;
			else if (arr[x] > 0)
				for (int j = 1; j < arr[x]; j++) {
					dq.addLast(dq.pollFirst());
				}
			else
				for (int j = 0; j < -arr[x]; j++) {
					dq.addFirst(dq.pollLast());
				}
			
		}
	}
}
