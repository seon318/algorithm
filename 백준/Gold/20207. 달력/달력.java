import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	static char[] arr1 = { 'a', 'b', 'c', 'b', 'a' };
	static char[] arr2 = { 'a', 'b', 'c', 'a', 'b', 'c' };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		boolean isStart = false;
		int s, e, now, max;
		int n = Integer.parseInt(br.readLine());
		int paper = 0;
		int[] cal = new int[366];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			for (int j = s; j <= e; j++) {
				++cal[j];
			}
		}

		s = 365;
		for (int i = 0; i <= 365; i++) {
			if (!isStart && cal[i] != 0) {
				if (i == 365)
					paper += cal[365];
				else {
					s = i;
					isStart = true;
				}
			} if (isStart && (i == 365 || cal[i + 1] == 0)) {
				isStart = false;
				e = i;
				max = cal[s];
				for (int j = s + 1; j <= e; j++) {
					max = Math.max(max, cal[j]);
				}
				paper += (e - s + 1) * max;

			}

		}

		System.out.println(paper);
	}
}