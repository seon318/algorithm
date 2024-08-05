
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine(); 
		int goodWordCount = 0;

		for (int tc = 1; tc <= T; tc++) {
			String s = sc.nextLine();
			if (isGoodWord(s)) {
				goodWordCount++;
			}
		}
		System.out.println(goodWordCount);
	}

	static boolean isGoodWord(String s) {
		int LEN = s.length();
		if(LEN%2!=0) {
			return false;
		}
		Stack<Character> stack = new Stack<>();
		for(char c : s.toCharArray()) {
			if(stack.isEmpty()|| stack.peek()!=c) {
				stack.push(c);
			}
			else {
				stack.pop();
			}
		}
		return stack.isEmpty();
	}
}
