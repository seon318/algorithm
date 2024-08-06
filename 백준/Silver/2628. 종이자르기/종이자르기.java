import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int length = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		int[] paper_l = new int[length];
		int[] paper_h = new int[height];
		int d, x;

		int n = Integer.parseInt(br.readLine());
		for (int t = 0; t < n; t++) {
			st = new StringTokenizer(br.readLine());
			d = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());

			if (d == 0) {
				paper_h[x] = 1;
			} else
				paper_l[x] = 1;
		}

		int max_l = 0;
		int max_h = 0;
		int past = 0;
		for (int i = 0; i < length; i++) {
			if (paper_l[i] == 1) {
				max_l = Math.max(i - past, max_l);
				past = i;
			}
		}
		max_l = Math.max(length - past, max_l);
		
		past = 0;
		for (int i = 0; i < height; i++) {
			if (paper_h[i] == 1) {
				max_h = Math.max(i - past, max_h);
				past = i;
			}
		}
		max_h = Math.max(height -  past, max_h);
		
		System.out.println(max_h * max_l);
	}
}
