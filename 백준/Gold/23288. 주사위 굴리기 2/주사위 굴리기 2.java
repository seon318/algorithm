import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m, k, d, top, bottom, tmp, nowX, nowY, nx, ny, num, score, cnt;
	static int[][] map;
	//북동남서상하 
	static int[] dice = {2, 3, 5, 4};
	static int[] value = new int[7];
	//북동상하 
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		d = 1; //동쪽에서 시작 
		top = 1; //윗면 
		bottom = 6; //아랫면 
		nowX = 0;
		nowY = 0;
		
		score = 0;
		
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int move = 0; move < k; move++) {
			rollDice();
		}
		
		System.out.println(score);
	}
	
	static void rollDice() {
		//주사위 좌표 갱신 
		nx = nowX + dx[d];
		ny = nowY + dy[d];
		if (!isValid(nx, ny)) {
			d = (d + 2) % 4;
			nx = nowX + dx[d];
			ny = nowY + dy[d];
		}
		nowX = nx;
		nowY = ny;
		
		//d방향으로 이동해서 주사위 방향 찾기 
		tmp = dice[d];
		dice[d] = top;
		top = dice[(d + 2) % 4];
		dice[(d + 2) % 4] = bottom;
		bottom = tmp;
		
		//정수 A와 B 비교하기 
		num = map[nowX][nowY];
		if (bottom > num) d = (d + 1) % 4;
		else if (bottom < num) d = (d + 3) % 4;
		
		//점수 구하기 
		visited = new boolean[n][m];
		visited[nowX][nowY] = true;
		cnt = 1;
		checkScore(nowX, nowY, num);
		score += num * cnt;
		
	}
	
	static void checkScore(int x, int y, int val) {
		for (int d = 0; d < 4; d++) {
			nx = x + dx[d];
			ny = y + dy[d];
			
			if (isValid(nx, ny) && !visited[nx][ny] && map[nx][ny] == val) {
				visited[nx][ny] = true;
				cnt++;
				checkScore(nx, ny, val);
			}
		}
		
	}
	
	static boolean isValid(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < m;
	}
}