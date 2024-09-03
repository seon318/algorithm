import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] arr;
	static int[] numbers;
	static boolean[] selected;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		numbers = new int[m];
		selected = new boolean[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		perm(0);
		System.out.println(sb);
	}
	
	static void perm(int cnt) {
		if (cnt == m) {
			for (int i = 0; i < m; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		int past = 0;
		
		for (int i = 0; i < n; i++) {
			if (!selected[i] && past != arr[i]) {
				numbers[cnt] = arr[i];
				selected[i] = true;
				past = arr[i];
				perm(cnt + 1);
				selected[i] = false;
			}
			
		}
	}
}