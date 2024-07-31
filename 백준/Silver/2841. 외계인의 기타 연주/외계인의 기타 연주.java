import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer>[] stack = new Stack[7];

		int line, fret;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		int move = 0;

		for (int x = 0; x < 7; x++) {
			stack[x] = new Stack<Integer>();
		}
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			line = Integer.parseInt(st.nextToken());
			fret = Integer.parseInt(st.nextToken());

			while (!stack[line].isEmpty() && stack[line].peek() > fret) {
				stack[line].pop();
				move++;
			}
			
			if (stack[line].isEmpty() || stack[line].peek() < fret) {
				stack[line].push(fret);
				move++;
			}

		}
		System.out.println(move);
	}
}
