import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, sum, dir, nx, ny, d1, d2, spreaded, dis;
	static int[][] map;
	static int x, y;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		x = n / 2;
		y = n / 2;
		dir = 0;
		dis = 1;
		
		outer : while(true) {
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < dis; j++) {
					if (x == 0 && y == 0) break outer;
					move();
				}
				dir = ++dir % 4;
			}
			dis++;
			
		}
		
		System.out.println(sum);
		
	}
	
	static void move( ) {
		nx = x + dx[dir];
		ny = y + dy[dir];
		spread(map[nx][ny]);
		map[nx][ny] = 0;
		x = nx;
		y = ny;
	}
	
	static void spread(int sand) {
		spreaded = 0;
		d1 = (dir + 1) % 4;
		d2 = (dir + 3) % 4;
		
		//1%
		check(x + dx[d1], y + dy[d1], sand / 100);
		check(x + dx[d2], y + dy[d2], sand / 100);
		
		//2%
		check(nx + dx[d1] * 2, ny + dy[d1] * 2, sand * 2 / 100);
		check(nx + dx[d2] * 2, ny + dy[d2] * 2, sand * 2 / 100);
		
		//5%
		check(nx + dx[dir] * 2, ny + dy[dir] * 2, sand * 5 /100);
		
		//7%
		check(nx + dx[d1], ny + dy[d1], sand * 7 / 100);
		check(nx + dx[d2], ny + dy[d2], sand * 7 / 100);

		//10%
		check(nx + dx[d1] + dx[dir], ny + dy[d1] + dy[dir], sand * 10 / 100);
		check(nx + dx[d2] + dx[dir], ny + dy[d2] + dy[dir], sand * 10 / 100);

		//55%
		check(nx + dx[dir], ny + dy[dir], sand - spreaded);

	}
	
	static boolean isValid(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < n;
	}
	
	static void check(int x, int y, int val) {
		if (isValid(x, y)) {
			map[x][y] += val;
		}
		else {
			sum += val;
		}
		spreaded += val;

	}
}