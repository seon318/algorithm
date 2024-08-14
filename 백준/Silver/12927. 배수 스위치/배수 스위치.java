import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String input = br.readLine();
		int n = input.length();
		int ans = 0;
		int x;
		boolean[] arr = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			if (input.charAt(i - 1) == 'Y') {
				arr[i] = true;
			} else {
				arr[i] = false;
			}
		}

		for (int i = 1; i <= n; i++) {
			if (arr[i] == true) {
				for (int j = i; j <= n; j += i) {
					arr[j] = !arr[j];
				}
				ans++;

			}
		}

		sb.append(ans);
		System.out.println(sb);
	}
}