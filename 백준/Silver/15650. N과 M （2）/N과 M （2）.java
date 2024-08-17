import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static boolean[] isSelected;
	static int[] numbers;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		numbers = new int[m];
		comb(0, 1);
		System.out.println(sb);
	}

	static void comb(int cnt, int idx) {
		if (cnt == m) {
			for (int i = 0; i < m; i++) {
				sb.append(numbers[i]).append(' ');
			}
			sb.append('\n');
			return;
		}

		for (int i = idx; i <= n; i++) {
			numbers[cnt] = i;
			comb(cnt + 1, i + 1);

		}

	}
}
