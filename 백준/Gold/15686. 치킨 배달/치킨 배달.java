import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n, m, min, dis;
	static int[][] selectedChicken;
	static List<int[]> chicken, house;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		selectedChicken = new int[m][2];
		chicken = new ArrayList<>();
		house = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int input = Integer.parseInt(st.nextToken());
				if (input == 2)
					chicken.add(new int[] { i, j });
				else if (input == 1)
					house.add(new int[] { i, j });
			}
		}

		min = 10000;
		comb(0, 0);
		
		System.out.println(min);

	}

	static void comb(int cnt, int idx) {
		if (cnt == m) {
			checkDistance();
			return;
		}

		for (int i = idx; i < chicken.size(); i++) {
			selectedChicken[cnt] = chicken.get(i);
			comb(cnt + 1, i + 1);
		}
	}

	static void checkDistance() {
		dis = 0;
		for (int i = 0; i < house.size(); i++) {
			int[] h = house.get(i);
			int d = 100;
			for (int j = 0; j < m; j++) {
				d = Math.min(d, Math.abs(h[0] - selectedChicken[j][0]) + Math.abs(h[1] - selectedChicken[j][1]));
			}
			dis += d;
		}
		
		min = Math.min(min, dis);

	}
}
