import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> front = new PriorityQueue<>(Comparator.reverseOrder());
		PriorityQueue<Integer> back = new PriorityQueue<>();
		
		for (int i = 1; i <= n; i++) {
			if (i % 2 == 1) front.add(Integer.parseInt(br.readLine()));
			else back.add(Integer.parseInt(br.readLine()));
			
			while (!front.isEmpty() && !back.isEmpty() && front.peek() > back.peek()) {
				front.add(back.poll());
				back.add(front.poll());
			}
			
			sb.append(front.peek()).append("\n");
		}
		
		System.out.println(sb);
	}
}