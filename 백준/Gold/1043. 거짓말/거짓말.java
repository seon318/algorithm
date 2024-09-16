import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[] p;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int[] truth = new int[k];
		for (int i = 0; i < k; i++) {
			truth[i] = Integer.parseInt(st.nextToken());
		}

		List<Integer>[] party = new ArrayList[m];
		for (int i = 0; i < m; i++) {
			party[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			for (int j = 0; j < size; j++) {
				party[i].add(Integer.parseInt(st.nextToken()));
			}
		}

		p = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			p[i] = i;
		}
		
		for (int i = 0; i < m; i++) {
			int tmp = party[i].get(0);
			for (int j = 0; j < party[i].size(); j++) {
				int pa = findSet(tmp);
				int pb = findSet(party[i].get(j));
				if (pa != pb) p[pa] = pb;
			}
		}
		int cnt = 0;
		for (int i = 0; i < m; i++) {
			int tmp = party[i].get(0);
			boolean flag = true;
			for (int j = 0; j < k; j++) {
				if (findSet(tmp) == findSet(truth[j])) {
					flag = false;
					break;
				}
			}
			if (flag) cnt++;
		}
		
		System.out.println(cnt);
	}

	static int findSet(int x) {
		if (p[x] != x)
			p[x] = findSet(p[x]);
		return p[x];
	}
}