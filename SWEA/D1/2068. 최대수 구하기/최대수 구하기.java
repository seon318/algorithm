import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for (int i=1; i<=t; i++) {
			int result = 0;
			for (int j=0; j<10; j++) {
				int num = sc.nextInt();
				result = Math.max(result, num);
			}
			System.out.println("#" + i + " " + result);
		}
	}
}
