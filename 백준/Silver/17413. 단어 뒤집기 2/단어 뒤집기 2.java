import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String input = br.readLine();
		Stack<Character> stack = new Stack<>();
		boolean isTag = false;
		
		for (int i = 0; i < input.length(); i++) {
			char x = input.charAt(i);
			if (x == ' ' || x == '<') {
				while (!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append(x);
				if (x == '<') isTag = true;
				continue;
			}
			
			if (x == '>'){
				sb.append(x);
				isTag = false;
				continue;
			}
			
			if (!isTag) {
				stack.add(x);
			} else {
				sb.append(x);
			}
		}
		
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.println(sb);
	}
}