import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for (int i=1; i<=t; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			String result;
			if (a > b) {
				result = ">";
			} else if (a < b) {
				result = "<";
			} else {
				result = "=";
			}
			System.out.println("#" + i + " " + result);
		}
	}
}
