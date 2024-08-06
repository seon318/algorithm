import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String input;
		Deque<Integer> q = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {
			input = br.readLine();
			switch (input) {
			case ("size"):
				System.out.println(q.size());
				break;
			case ("empty"):
				System.out.println(q.isEmpty() ? 1 : 0);
				break;
			case ("pop_front"):
				System.out.println(q.isEmpty() ? -1 : q.pollFirst());
				break;
			case ("pop_back"):
				System.out.println(q.isEmpty() ? -1 : q.pollLast());
				break;
			case ("front"):
				System.out.println(q.isEmpty() ? -1 : q.getFirst());
				break;
			case ("back"):
				System.out.println(q.isEmpty() ? -1 : q.getLast());
				break;
			default:
				if (input.startsWith("push_front"))
					q.addFirst(Integer.parseInt(input.split(" ")[1]));
				else q.addLast(Integer.parseInt(input.split(" ")[1]));
					
			}
		}

	}
}
