import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int x1, x2, y1, y2, sum;
		int[][] paper = new int[101][101];

		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			for (int x = x1; x < x2; x++) {
				for (int y = y1; y < y2; y++) {
					paper[x][y] = 1;
				}
			}
		}
		sum = 0;
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				sum += paper[i][j];
			}
		}
		System.out.println(sum);
	}
}
