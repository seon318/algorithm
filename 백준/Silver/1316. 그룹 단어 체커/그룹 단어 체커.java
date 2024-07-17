import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;
		
		for (int i=0; i<n; i++) {
			String word = sc.next();
			char[] past = new char[word.length()];
			int idx = 0;
			char now = word.charAt(0);
			boolean isGroupWord = true;
			
			outer: for (int j=1; j<word.length(); j++) {
				char x = word.charAt(j);
				for (char c : past) {
					if (c == x) {
						isGroupWord = false;
						break outer;
					}
				}
				if (x == now) continue;
				else {
					past[idx++] = now;
					now = x;
				}
			}
			if (isGroupWord) ++cnt;
		}
		
		System.out.println(cnt);
	}
}