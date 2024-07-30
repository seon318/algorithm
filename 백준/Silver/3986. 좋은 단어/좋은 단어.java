import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	Stack<Character> stack = new Stack<>();
    	int ans = 0;
    	
    	int n = Integer.parseInt(br.readLine());
    	for (int t=0; t<n; t++) {
    		stack.removeAll(stack);
    		String input = br.readLine();
    		for (int i=0; i<input.length(); i++) {
    			char x = input.charAt(i);
    			if (stack.size() > 0 && stack.peek() == x) stack.pop();
    			else stack.push(x);
    		}
    		if (stack.size() == 0) ans++;
    	}
    	System.out.println(ans);
    }
}
