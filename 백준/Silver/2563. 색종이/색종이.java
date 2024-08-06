import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int a, b, sum;
		int[][] paper = new int[100][100];

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			for (int x = a; x < a + 10; x++) {
				for (int y = b; y < b + 10; y++) {
					paper[x][y] = 1;				}
			}
		}

		sum = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				sum += paper[i][j];
			}
		}
		System.out.println(sum);
	}
}
