import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		int[] num = new int[n];
		num[0] = 1;
		int max;
		
		for (int i=1; i<n; i++) {
			max = 1;
			for (int j=0; j<=i; j++) {
				if (arr[i] > arr[j]) {
					max = Math.max(max, num[j]+1);
				}
			}
			num[i] = max;
		}
		max = 0;
		for (int i=0; i<n; i++) {
			max = Math.max(max, num[i]);
		}
		System.out.println(max);
	}
}