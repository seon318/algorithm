import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int length = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(br.readLine());
		int d, l;
		int sum = 0;
		int now = 0;
		int[] shops = new int[2 * length + 2 * height];

		for (int i = 0; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			d = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			if (d == 1)
				now = l;
			else if (d == 2)
				now = length * 2 + height - l;
			else if (d == 3)
				now = length * 2 + height * 2 - l;
			else if (d == 4)
				now = length + l;
			if (i < n)
				shops[now]++;
		}
		
		for (int i = 0; i < 2 * length + 2 * height; i++) {
			if (shops[i] > 0) {
				sum += Math.min(Math.abs(now - i), 2 * length + 2 * height - Math.abs(now - i));
			}
		}
		System.out.println(sum);
	}
}