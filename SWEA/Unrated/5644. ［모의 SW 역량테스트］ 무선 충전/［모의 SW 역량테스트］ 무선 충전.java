import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Charger {
	int id, x, y, c, p;

	Charger(int id, int x, int y, int c, int p) {
		this.id = id;
		this.x = x;
		this.y = y;
		this.c = c;
		this.p = p;
	}
}

public class Solution {
	static int m, a, x, y, c, p, ax, ay, bx, by, sum, time, p1, p2;
	static int[] moveA, moveB;
	static int[] dx = { 0, 0, 1, 0, -1 };
	static int[] dy = { 0, -1, 0, 1, 0 };
	static Charger[] ap;
	static PriorityQueue<Charger> pqA = new PriorityQueue<>((o1, o2) -> {
		return o2.p - o1.p;
	});
	static PriorityQueue<Charger> pqB = new PriorityQueue<>((o1, o2) -> {
		return o2.p - o1.p;
	});

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());

			moveA = new int[m];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				moveA[i] = Integer.parseInt(st.nextToken());
			}

			moveB = new int[m];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				moveB[i] = Integer.parseInt(st.nextToken());
			}

			ap = new Charger[a];
			for (int i = 0; i < a; i++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				p = Integer.parseInt(st.nextToken());
				ap[i] = new Charger(i, x, y, c, p);
			}
			
			ax = 1;
			ay = 1;
			bx = 10;
			by = 10;
			sum = 0;
			time = 0;
			
			while (true) {
				//충전 가능한 충전기만 넣기
				pqA.clear();
				pqB.clear();
				
				for (Charger charger : ap) {
					if (Math.abs(ax - charger.x) + Math.abs(ay - charger.y) <= charger.c) {
						pqA.add(charger);
					}
					if (Math.abs(bx - charger.x) + Math.abs(by - charger.y) <= charger.c) {
						pqB.add(charger);
					}
				}
				
				//충전기 고르기
				if (!pqA.isEmpty() && !pqB.isEmpty()) {
					if (pqA.peek().id == pqB.peek().id) {
						sum += pqA.poll().p;
						pqB.poll();
						if (!pqA.isEmpty()) p1 = pqA.peek().p;
						else p1 = 0;
						if (!pqB.isEmpty()) p2 = pqB.peek().p;
						else p2 = 0;
						sum += Math.max(p1, p2);
						
					}
					else sum += pqA.peek().p + pqB.peek().p;
				} else {
					if (!pqA.isEmpty()) sum += pqA.peek().p;
					if (!pqB.isEmpty()) sum += pqB.peek().p;
				}

				if (time == m) break;

				//이동시키기
				ax += dx[moveA[time]];
				ay += dy[moveA[time]];
				bx += dx[moveB[time]];
				by += dy[moveB[time]];
				
				time++;
			}
			
			sb.append("#").append(tc).append(" ").append(sum).append("\n");
		}
		
		System.out.println(sb);
	}
}