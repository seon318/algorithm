import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int[] p;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		class Planet {
			int num, x, y, z;

			public Planet(int num, int x, int y, int z) {
				super();
				this.num = num;
				this.x = x;
				this.y = y;
				this.z = z;
			}

			@Override
			public String toString() {
				return "Planet [num=" + num + ", x=" + x + ", y=" + y + ", z=" + z + "]";
			}
			
		}
		
		class Edge implements Comparable<Edge> {
			int a, b, d;

			public Edge(int a, int b, int d) {
				super();
				this.a = a;
				this.b = b;
				this.d = d;
			}

			@Override
			public String toString() {
				return "Edge [a=" + a + ", b=" + b + ", d=" + d + "]";
			}

			@Override
			public int compareTo(Edge o) {
				return this.d - o.d;
			}
			
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		List<Planet> planets = new ArrayList<>();
		PriorityQueue<Edge> edges = new PriorityQueue<>();
		p = new int[N];
		
		//입력 받기 
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			planets.add(new Planet(i, x, y, z));
			p[i] = i;
		}
		
		//정렬 및 거리 계산하기
		Collections.sort(planets, (o1, o2) -> o1.x - o2.x);
		Planet a, b = planets.get(0);
		for (int i = 1; i < N; i++) {
			a = b;
			b = planets.get(i);
			edges.add(new Edge(a.num, b.num, b.x - a.x));
		}

		Collections.sort(planets, (o1, o2) -> o1.y - o2.y);
		b = planets.get(0);
		for (int i = 1; i < N; i++) {
			a = b;
			b = planets.get(i);
			edges.add(new Edge(a.num, b.num, b.y - a.y));
		}

		Collections.sort(planets, (o1, o2) -> o1.z - o2.z);
		b = planets.get(0);
		for (int i = 1; i < N; i++) {
			a = b;
			b = planets.get(i);
			edges.add(new Edge(a.num, b.num, b.z - a.z));
		}
		
		//최소 비용 간선 뽑기
		int pick = 0;
		int dist = 0;
		while (pick < N - 1) {
			Edge e = edges.poll();
			if (findP(e.a) == findP(e.b)) continue;
			p[findP(e.a)] = findP(e.b);
			pick++;
			dist += e.d;
		}
		
		System.out.println(dist);
	}
	
	public static int findP(int x) {
		if (p[x] != x)
			p[x] = findP(p[x]);
		return p[x];
	}
}