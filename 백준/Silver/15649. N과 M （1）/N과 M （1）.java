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

		isSelected = new boolean[n + 1];
		numbers = new int[m];
		perm(0);
		System.out.println(sb);
	}

	static void perm(int cnt) {
		if (cnt == m) {
			for (int i = 0; i < m; i++) {
				sb.append(numbers[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for (int i = 1; i <= n; i++) {
			if (!isSelected[i]) {
				numbers[cnt] = i;
				isSelected[i] = true;
				perm(cnt + 1);
				isSelected[i] = false;

			}
			
		}
	}
}