import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t, idx, n, ans;
		String target, input;

		for (int tc = 1; tc <= 10; tc++) {
			t = Integer.parseInt(br.readLine());
			target = br.readLine();
			input = br.readLine();
			idx = input.length();
			n = target.length();
			ans = 0;
			outer : while (idx >= n) {
				if (input.substring(idx-n, idx).equals(target)) {
					ans++;
					idx -= n;
					continue;
				}
				for (int i = 0; i < n; i++) {
					if (input.substring(idx-n, idx).contains(target.charAt(i)+"")) {
						idx--;
						continue outer;
					}
				} idx -= n;
			}

			System.out.printf("#%d %d\n", t, ans);
		}
	}
}
