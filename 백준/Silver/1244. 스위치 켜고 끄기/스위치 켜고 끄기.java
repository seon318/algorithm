import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x, y;

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int s = Integer.parseInt(br.readLine());
		for (int i = 0; i < s; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			if (x == 1) {
				for (int j = y; j <= n; j++) {
					if (j % y == 0) {
						arr[j] = arr[j] == 0 ? 1 : 0;
					}
				}
			} else {
				arr[y] = arr[y] == 0 ? 1 : 0;
				for (int j = 1; j <= Math.min(n - y, y - 1); j++) {
					if (arr[y + j] == arr[y - j]) {
						arr[y + j] = arr[y + j] == 0 ? 1 : 0;
						arr[y - j] = arr[y - j] == 0 ? 1 : 0;
					} else
						break;
				}
			}
		}
		
		int num = 0;
		for (int i = 1; i <= n; i++) {
			System.out.print(arr[i] + " ");
			num++;
			if (num == 20) {
				System.out.print("\n");
				num = 0;
			}
		}
	}
}
