import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int r, c;
	static boolean[][] visited;
	static char[][] cave;
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		cave = new char[r][c];
		String input;
		
		for (int i = 0; i < r; i++) {
			input = br.readLine();
			for (int j = 0; j < c; j++) {
				cave[i][j] = input.charAt(j);
			}
		}
		
		int row, col, nr, nc;
		boolean isLeft = false;

		
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int t = 0; t < n; t++) {
			row = r - Integer.parseInt(st.nextToken());
			col = -1;
			isLeft = !isLeft;
			
			//파괴될 미네랄 위치 찾기
			if (isLeft) {
				for (int j = 0; j < c; j++) {
					if (cave[row][j] == 'x') {
						col = j;
						break;
					}
				}
			} else {
				for (int j = c - 1; j >= 0; j--) {
					if (cave[row][j] == 'x') {
						col = j;
						break;
					}
				}
			}
			
			//만약 파괴되는 미네랄이 없다면 다음으로
			if (col == -1) continue;
			
			//클러스터 분리 확인
			cave[row][col] = '.';
			visited = new boolean[r][c];
			//바닥면에 닿은 미네랄을 방문 처리
			for (int j = 0; j < c - 1; j++) {
				if (!visited[r-1][j] && cave[r-1][j] == 'x') {
					visited[r-1][j] = true;
					dfs(r-1, j);
				}
			}
			//없앤 미네랄 근처 사방에 탐색 안 된 미네랄이 있는지 확인 -> 분리된 미네랄 체크
			for (int d = 0; d < 4; d++) {
				nr = row + dr[d];
				nc = col + dc[d];
				if (0 > nr || nr >= r || 0 > nc || nc >= c) continue;
				if (cave[nr][nc] == 'x' && !visited[nr][nc]) {
					visited = new boolean[r][c];
					visited[nr][nc] = true;
					dfs(nr, nc);
					downCluster();
					break;
				}
			}
		}
		
		//출력하기
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				sb.append(cave[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void downCluster() {
		int maxRow = 0, minRow = r-1, moveRow = -1;
		for (int i = r-1; i >= 0; i--) {
			for (int j = 0; j < c; j++) {
				if (visited[i][j]) {
					maxRow = Math.max(maxRow, i);
					minRow = Math.min(minRow, i);
				}
			}
		}
		//어디까지 떨어뜨릴 수 있는지 확인
		int idx;
		outer : for (int i = maxRow + 1; i < r; i++) {
			idx = maxRow;
			for (int k = i; k >= i - (maxRow - minRow); k--) {
				for (int j = 0; j < c; j++) {
				
					if (visited[idx][j]) {
						if ((cave[k][j] == 'x' && visited[k][j]) || cave[k][j] == '.') continue;
						break outer;
					}
				}
				idx--;
			}
			
			moveRow = i;
		}
		
		if (moveRow == minRow || maxRow == r - 1 || moveRow == -1) return;
		
		int diff = moveRow - maxRow;
		
		//떨어뜨리기
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (visited[i][j]) cave[i][j] = '.';
			} 
		}
		
		for (int i = moveRow; i >= diff; i--) {
			if (minRow == i) break;
			for (int j = 0; j < c; j++) {
				if (visited[i - diff][j]) cave[i][j] = 'x';

			}
		}
	}

	static void dfs(int r1, int c1) {
		for (int d = 0; d < 4; d++) {
			int nr = r1 + dr[d];
			int nc = c1 + dc[d];
			if (0 > nr || nr >= r || 0 > nc || nc >= c || visited[nr][nc] || cave[nr][nc] == '.') continue;
			visited[nr][nc] = true;
			dfs(nr, nc);
		}
	}
}