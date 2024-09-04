import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		arr = new int[v + 1];
		for (int i = 1; i <= v; i++) {
			arr[i] = i;
		}
		
		int[][] edges = new int[e][3];
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			edges[i][0] = Integer.parseInt(st.nextToken());
			edges[i][1] = Integer.parseInt(st.nextToken());
			edges[i][2] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(edges, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
			return o1[2] - o2[2];
		}});
		
		int ans = 0;
		int pick = 0;
		
		for (int i = 0; i < e; i++) {
			if (findSet(edges[i][0]) != findSet(edges[i][1])) {
				arr[findSet(edges[i][1])] = findSet(edges[i][0]);
				ans += edges[i][2];
				pick++;
			}
			
			if (pick == v - 1)
				break;
		}
		
		System.out.println(ans);
	}
	
	static int findSet(int x) {
		if (arr[x] != x) {
			arr[x] = findSet(arr[x]);
		}
		return arr[x];
	}
}