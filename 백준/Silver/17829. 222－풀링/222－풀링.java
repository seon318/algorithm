import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		int[] compare = new int[4];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
        while (n > 1) {
            for (int i = 0; i < n; i += 2) {
                for (int j = 0; j < n; j += 2) {
                    compare[0] = arr[i][j];
                    compare[1] = arr[i][j + 1];
                    compare[2] = arr[i + 1][j];
                    compare[3] = arr[i + 1][j + 1];
                    Arrays.sort(compare);
                    arr[i / 2][j / 2] = compare[2];
                }
            }
            n /= 2;
        }
		System.out.println(arr[0][0]);
	}
}