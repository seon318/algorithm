import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int n, ans;
	static String[] str;
	static boolean[] isSelected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			str = new String[n];
			isSelected = new boolean[n];

			for (int i = 0; i < n; i++) {
				str[i] = br.readLine();
			}
			
			ans = 0;
			sub(0);
			sb.append("#").append(tc).append(" ").append(ans).append("\n");

		}
		System.out.println(sb);
	}

	static void sub(int cnt) {
		if (cnt == n) {
			boolean[] alpha = new boolean[26];
			for (int i = 0; i < n; i++) {
				if (isSelected[i]) {
					for (int j = 0; j < str[i].length(); j++) {
						alpha[str[i].charAt(j) - 'a'] = true;
					}
				}
			}

			for (int i = 0; i < 26; i++) {
				if (!alpha[i])
					return;
			}
			ans++;
			return;
		}

		isSelected[cnt] = true;
		sub(cnt + 1);
		isSelected[cnt] = false;
		sub(cnt + 1);
	}
}