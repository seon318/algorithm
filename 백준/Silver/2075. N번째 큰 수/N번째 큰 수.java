import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int j = 0; j < n; j++) {
			pq.add(arr[n - 1][j]);
		}
		
		for (int j = 0; j < n; j++) {
			for (int i = n - 2; i >= 0; i--) {
				if (arr[i][j] > pq.peek()) {
					pq.poll();
					pq.add(arr[i][j]);
				} else break;
			}
			
		}
		
		System.out.println(pq.peek());
	}
}