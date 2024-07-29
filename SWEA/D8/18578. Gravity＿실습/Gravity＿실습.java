import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int n, max, diff, maxDiff;
		
		for (int x=1; x<t+1; x++) {
			n = sc.nextInt();
			max = 0;
			maxDiff = 0;
			int[] arr = new int[n];
			for (int i=0; i<n; i++) {
				arr[i] = sc.nextInt();
				max = Math.max(arr[i], max);
			}
			
			for (int i=0; i<n; i++) {
				diff = 0;
				for (int j=i; j<n; j++) {
					if (arr[i]>arr[j]) diff++;
				}
				maxDiff = Math.max(maxDiff, diff);
			}
			
			System.out.println("#"+x+" "+maxDiff);
			
		}
	}
}