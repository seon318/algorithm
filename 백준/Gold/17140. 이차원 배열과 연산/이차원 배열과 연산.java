import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int r, c, k, idx, rLen = 3, cLen = 3, time = 0;
	static int[][] arr = new int[100][100];
	static int[] cnt, tmp;
	static PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
		if (o1[1] != o2[1])
			return o1[1] - o2[1];
		else
			return o1[0] - o2[0];
	});

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken()) - 1;
		c = Integer.parseInt(st.nextToken()) - 1;
		k = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while (arr[r][c] != k && time++ <= 100) {
			idx = 0;
			if (rLen >= cLen) {
				for (int i = 0; i < rLen; i++) {
					rSort(i);
					cLen = Math.max(cLen, idx);
				}
			}
			else {
				for (int j = 0; j < cLen; j++) {
					cSort(j);
					rLen = Math.max(rLen, idx);
				}
			}
		}
		
		if (time > 100) time = -1;
		
		System.out.println(time);
	}
	
	static void rSort(int i) {
		cnt = new int[101];
		for (int j = 0; j < cLen; j++) cnt[arr[i][j]]++;
		for (int x = 1; x <= 100; x++) {
			if (cnt[x] > 0) pq.add(new int[] {x, cnt[x]});
		}
		idx = 0;
		while (!pq.isEmpty() && idx < 99) {
			tmp = pq.poll();
			arr[i][idx++] = tmp[0];
			arr[i][idx++] = tmp[1];
		}
		for (int x = idx; x < 100; x++) {
			arr[i][x] = 0;
		}
	}
	
	static void cSort(int j) {
		cnt = new int[101];
		for (int i = 0; i < rLen; i++) cnt[arr[i][j]]++;
		for (int x = 1; x <= 100; x++) {
			if (cnt[x] > 0) pq.add(new int[] {x, cnt[x]});
		}
		idx = 0;
		while (!pq.isEmpty() && idx < 99) {
			tmp = pq.poll();
			arr[idx++][j] = tmp[0];
			arr[idx++][j] = tmp[1];
		}
		for (int x = idx; x < 100; x++) {
			arr[x][j] = 0;
		}
	}
}