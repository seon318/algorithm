import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int sum = 0;
		
		int[][] arr = new int[100][100];
		
		for (int i = 0; i < N; i++) {
			int c = sc.nextInt();
			int r = sc.nextInt();
			for (int row = r; row < r + 10; row++) {
				for (int col = c; col < c + 10; col++) {
					arr[row][col] = 1;
				}
			}

		}
		
		for (int row = 0; row < 100; row++) {
			for (int col = 0; col < 100; col++) {
				sum += arr[row][col];
			}
		}
		System.out.println(sum);
		sc.close();
	}
}
