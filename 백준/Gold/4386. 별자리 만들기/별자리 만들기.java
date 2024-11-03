import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n, cnt, a, b;
	static double x, y, dist, ans;
	static int[] p;
	static List<double[]> loc = new ArrayList<>();
	static PriorityQueue<double[]> pq = new PriorityQueue<>((o1, o2) -> {
		return (int) (o1[2] - o2[2]);
	});
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		p = new int[n];
		for (int i = 0; i < n; i++) {
			p[i] = i;
			st = new StringTokenizer(br.readLine());
			x = Double.parseDouble(st.nextToken());
			y = Double.parseDouble(st.nextToken());
			loc.add(new double[] {x, y});
			for (int j = 0; j < i; j++) {
				dist = Math.sqrt(Math.pow(loc.get(j)[0] - x, 2) + Math.pow(loc.get(j)[1] - y, 2));
				pq.add(new double[] {i, j, dist});
			}
		}
		
		cnt = 0;
		ans = 0;
		
		while (!pq.isEmpty() && cnt < n-1) {
			double[] tmp = pq.poll();
			a = (int) tmp[0];
			b = (int) tmp[1];
			dist = tmp[2];
			if (findP(a) == findP(b)) continue;
			cnt++;
			ans += dist;
			p[findP(a)] = p[findP(b)];
		}
		
		System.out.println(ans);
	}
	
	static int findP(int x) {
		if (p[x] != x) p[x] = findP(p[x]);
		return p[x];
	}
}