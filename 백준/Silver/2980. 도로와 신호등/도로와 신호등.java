import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int now = 0;
		int time = 0;
		int d, r, g;
		int[][] road = new int[l][2];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			d = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			road[d] = new int[] { r, g };
		}

		while (now < l-1) {
			if (road[now + 1][0] != 0) {
				while (time % (road[now + 1][0] + road[now + 1][1]) < road[now + 1][0])
					time++;
			}
			time++;
			now++;
		}
		
		System.out.println(time);

	}
}
