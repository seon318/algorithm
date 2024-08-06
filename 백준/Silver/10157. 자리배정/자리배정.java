import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int c = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(br.readLine());
		int[][] arr = new int[c][r];
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		int x = 0;
		int y = 0;
		int nx, ny;
		int d = 0;
		int num = 1;
		
		if (c * r < k) {
			System.out.println(0);
			return;
		}
		
		while (num < k) {
			arr[x][y] = num++;
			nx = x + dx[d];
			ny = y + dy[d];
			
			if (0 > nx || nx >= c || 0 > ny | ny >= r || arr[nx][ny] != 0) {
				d = ++d % 4;
				nx = x + dx[d];
				ny = y + dy[d];
			}
			
			x = nx;
			y = ny;
		}
		
		System.out.println((x+1) + " " + (y+1));
	}
}
