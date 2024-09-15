import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int k;
	static int[] arr, sel;
	static StringBuilder sb = new StringBuilder();

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if (k == 0) break;
			arr = new int[k];
			sel = new int[k];
			for (int i = 0; i < k; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			comb(0, 0);
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static void comb(int cnt, int idx) {
		if (cnt == 6) {
			for (int i = 0; i < 6; i++) {
				sb.append(arr[sel[i]]).append(" ");
			}
			sb.append("\n");
		}
		
		for (int i = idx; i < k; i++) {
			sel[cnt] = i;
			comb(cnt + 1, i + 1);
		}
	}
}