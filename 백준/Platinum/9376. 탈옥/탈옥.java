import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int h, w, prisonerNum;
	static char[][] arr;
	static int[][] prisoners, outside, prisoner1, prisoner2;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String input;
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			arr = new char[h+2][w+2];
			prisoners = new int[2][2];
			prisonerNum = 0;
			
			for (int i = 0; i < h; i++) {
				input = br.readLine();
				for (int j = 0; j < w; j++) {
					arr[i+1][j+1] = input.charAt(j);
					if (arr[i+1][j+1] == '$') {
						prisoners[prisonerNum][0] = i+1;
						prisoners[prisonerNum++][1] = j+1;
					}
				}
			}
			
			outside = bfs(new int[] {0, 0});
			prisoner1 = bfs(prisoners[0]);
			prisoner2 = bfs(prisoners[1]);
			System.out.println(getSum(prisoner1, prisoner2, outside));
		}
	}

	private static int getSum(int[][] d1, int[][] d2, int[][] d3) {
		int ans = h * w;
		
		for (int i = 1; i < h+1; i++) {
			for (int j = 1; j < w+1; j++) {
				if (arr[i][j] == '*') continue;
				if (d1[i][j] == -1 && d2[i][j] == -1 && d3[i][j] == -1) continue;
				int sum = d1[i][j] + d2[i][j] + d3[i][j];
				if (arr[i][j] == '#') sum -= 2;
				ans = Math.min(sum, ans);
			}
		}
		return ans;
	}

	private static int[][] bfs(int[] start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
        	return o1[2] - o2[2];
        });
        int[][] dist = new int[h+2][w+2];
        for (int i = 0; i < h+2; i++) Arrays.fill(dist[i], -1);
        
        pq.offer(new int[] {start[0], start[1], 0});
        dist[start[0]][start[1]] = 0;
        
        while (!pq.isEmpty()) {
        	int[] item = pq.poll();
        	int x = item[0];
        	int y = item[1];
        	for (int d = 0; d < 4; d++) {
        		int nx = x + dx[d];
        		int ny = y + dy[d];
        		if (!isValid(nx, ny) || dist[nx][ny] != -1) continue;
        		dist[nx][ny] = dist[x][y] + (arr[nx][ny] == '#' ? 1 : 0);
        		pq.offer(new int[] {nx, ny, dist[nx][ny]});
        	}
        }
		return dist;
	}

	private static boolean isValid(int x, int y) {
		return x >= 0 && x < h+2 && y >= 0 && y < w+2 && arr[x][y] != '*';
	}
	
	
}