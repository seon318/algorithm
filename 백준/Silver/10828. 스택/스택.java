import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	Stack<Integer> stack = new Stack<>();
    	
    	int n = Integer.parseInt(br.readLine());
    	for (int i=0; i<n; i++) {
    		String input = br.readLine();
    		if (input.contains("push")) {
    			String[] parts = input.split(" ");
    			stack.push(Integer.parseInt(parts[1]));
    		} else if (input.equals("pop")) {
    			System.out.println(stack.size()>0 ? stack.pop() : -1);
    		} else if (input.equals("size")) {
    			System.out.println(stack.size());
    		} else if (input.equals("empty")) {
    			System.out.println(stack.size()>0 ? 0 : 1);
    		} else if (input.equals("top")) {
    			System.out.println(stack.size()>0 ? stack.peek() : -1);
    		}
    	}
    }
}
