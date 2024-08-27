import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int lenR = 3, lenC = 3, time = 0;
	static int[][] arr;
	static List<Integer> tmp = new ArrayList<>();
	static int[] cnt;
	static PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
		if (o1[0] != o2[0])
			return o1[0] - o2[0];
		if (o1[1] != o2[1])
			return o1[1] - o2[1];
		return 0;
	});

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		arr = new int[100][100];
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (arr[r - 1][c - 1] != k && time++ < 100) {
			if (lenR >= lenC)
				sortR();
			else
				sortC();
		}
		
		if (time > 100)
			time = -1;

		System.out.println(time);
	}

	static void sortR() {
		int maxC = 0;
		for (int i = 0; i < lenR; i++) {
			tmp.clear();
			for (int j = 0; j < lenC; j++) {
				tmp.add(arr[i][j]);
			}
			sortTmp();
			for (int j = 0; j < tmp.size(); j++) {
				arr[i][j] = tmp.get(j);
			}
			for (int j = tmp.size(); j < 100; j++) {
				arr[i][j] = 0;
			}
			maxC = Math.max(maxC, tmp.size());
		}
		lenC = maxC;
	}

	static void sortC() {
		int maxR = 0;
		for (int j = 0; j < lenC; j++) {
			tmp.clear();
			for (int i = 0; i < lenR; i++) {
				tmp.add(arr[i][j]);
			}
			sortTmp();
			for (int i = 0; i < tmp.size(); i++) {
				arr[i][j] = tmp.get(i);
			}
			for (int i = tmp.size(); i < 100; i++) {
				arr[i][j] = 0;
			}
			maxR = Math.max(maxR, tmp.size());
		}
		lenR = maxR;

	}

	static void sortTmp() {
		cnt = new int[101];
		pq.clear();

		for (int i = 0; i < tmp.size(); i++) {
			cnt[tmp.get(i)]++;
		}
		for (int c = 1; c <= 100; c++) {
			if (cnt[c] != 0)
				pq.add(new int[] { cnt[c], c });
		}

		tmp.clear();
		while (!pq.isEmpty() && tmp.size() < 99) {
			int[] item = pq.poll();
			tmp.add(item[1]);
			tmp.add(item[0]);
		}
	}
}