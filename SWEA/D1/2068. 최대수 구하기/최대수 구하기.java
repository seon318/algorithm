import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int x=1; x<t+1; x++) {
			int max = sc.nextInt();
			for (int i=0; i<9; i++) {
				max = Math.max(max, sc.nextInt());
			}
			System.out.println("#"+x+" "+max);
		}

	}
}