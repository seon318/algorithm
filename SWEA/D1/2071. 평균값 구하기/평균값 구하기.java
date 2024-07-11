import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for (int i=1; i<=t; i++) {
			int sum = 0;
			for (int j=0; j<10; j++) {
				int num = sc.nextInt();
				sum += num;
			}
			int result = sum / 10;
			if (sum % 10 >= 5) {
				result += 1;
			}
			System.out.println("#" + i + " " + result);
		}
	}
}
