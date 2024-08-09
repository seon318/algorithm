import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int n, max, tmp, idx, left, ans;
		int t = Integer.parseInt(br.readLine());
		List<Integer> trees = new ArrayList<>();
		int[] cnt;

		for (int tc = 1; tc <= t; tc++) {
			trees.clear();
			ans = 0;

			n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				trees.add(Integer.parseInt(st.nextToken()));
			}

			max = Collections.max(trees);
			cnt = new int[max];

			for (int i = 0; i < trees.size(); i++) {
				if (trees.get(i) == max)
					continue;
				cnt[max - trees.get(i)]++;
			}

			for (int i = 3; i < cnt.length; i++) {
				if (i % 2 == 1) {
					cnt[1] += cnt[i];
					cnt[2] += cnt[i] * (i / 2);
				} else {
					cnt[2] += cnt[i] * (i / 2);
				}
			}
			if (cnt[1] != cnt[2]) {
				idx = cnt[1] > cnt[2] ? 1 : 2;
				ans += cnt[idx == 1 ? 2 : 1] * 2;
				left = Math.abs(cnt[1] - cnt[2]);
				if (idx == 1) {
					ans += 2 * left - 1;
				} else {
					ans += left / 3 * 4;
					if (left % 3 == 1) ans += 2;
					else if (left % 3 == 2) ans += 3;
					else if (left % 3 == 3) ans += 4;
				}
			} else {
				ans += cnt[1] * 2;
			}

			bw.append("#" + tc + " " + ans + "\n");
		}
		bw.flush();
	}
}
