import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		String ans = "";
		
		for (int i=0; i<n.length(); i++) {
			char x = n.charAt(i);
			if (Character.isUpperCase(x)) {
				ans += Character.toLowerCase(x);
			} else {
				ans += Character.toUpperCase(x);
			}
		}
		System.out.println(ans);
	}
}
