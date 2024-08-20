import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++) {
			cnt = 1;
			sb.append(isPalindrome(br.readLine())).append(" ").append(cnt).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static int recursion(String str, int l, int r) {
		if (l >= r) return 1;
		else if (str.charAt(l) != str.charAt(r)) return 0;
		else {
			cnt++;
			return recursion(str, l + 1, r - 1);
		}
	}
	
	static int isPalindrome(String str) {
		return recursion(str, 0, str.length() - 1);
	}
}
