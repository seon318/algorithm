import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int r, c, t, cnt, sum, air1, air2;
	static int[][] matrix, tmp;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		matrix = new int[r][c];
		int num = 0;
		
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
				//공기청정기 위치 찾기 
				if (matrix[i][j] == -1) {
					matrix[i][j] = 0;
					if (num++ == 0) {
						air1 = i;
					} else {
						air2 = i;
					}
				}
			}
		}
		
		for (int time = 0; time < t; time++) {
			//미세먼지 확산 
			tmp = new int[r][c];
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (matrix[i][j] > 0) spreadDust(i, j, matrix[i][j]);
				}
			}
			
			//임시값 더해주기 
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					matrix[i][j] += tmp[i][j];
				}
			}
						
			//공기청정기 작동 
			purifyUp();
			purifyDown();
		}
		
		sum = 0;
		//남은 먼지 더하기
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				sum += matrix[i][j];
			}
		}
		
		System.out.print(sb.append(sum));
	}
	
	static void spreadDust(int x, int y, int val) {
		cnt = 0;
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			//칸이 없거나 공기청정기 칸이면 넘어가기 
			if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
			if ((nx == air1 && ny == 0) || (nx == air2 && ny == 0)) continue;
			
			cnt++;
			tmp[nx][ny] += val / 5;
		}
		tmp[x][y] -= val / 5 * cnt;
	}
	
	static void purifyUp() {
		for (int i = air1 - 1; i > 0; i--) {
			matrix[i][0] = matrix[i - 1][0];
		}
		for (int i = 0; i < c - 1; i++) {
			matrix[0][i] = matrix[0][i + 1];
		}
		for (int i = 0; i < air1; i++) {
			matrix[i][c - 1] = matrix[i + 1][c - 1];
		}
		for (int i = c - 1; i > 0; i--) {
			matrix[air1][i] = matrix[air1][i - 1];
		}
	}
	
	static void purifyDown() {
		for (int i = air2 + 1; i < r - 1; i++) {
			matrix[i][0] = matrix[i + 1][0];
		}
		for (int i = 0; i < c - 1; i++) {
			matrix[r - 1][i] = matrix[r - 1][i + 1];
		}
		for (int i = r - 1; i > air2; i--) {
			matrix[i][c - 1] = matrix[i - 1][c - 1];
		}
		for (int i = c - 1; i > 0; i--) {
			matrix[air2][i] = matrix[air2][i - 1];
		}
	}
}