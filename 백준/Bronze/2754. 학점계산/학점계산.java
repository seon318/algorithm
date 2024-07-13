import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		
		double ans = 0;
		if (n.charAt(0) == 'A') ans = 4;
		else if (n.charAt(0) == 'B') ans = 3;
		else if (n.charAt(0) == 'C') ans = 2;
		else if (n.charAt(0) == 'D') ans = 1;
		
		if (n.length() == 2) {
			if (n.charAt(1) == '+') ans += 0.3;
			else if (n.charAt(1) == '-') ans -= 0.3;
		}
		
		System.out.println(ans);
	}
}
