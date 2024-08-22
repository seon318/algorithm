import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		String move = br.readLine();
		
		List<int[]> list = new ArrayList<>();
		
		list.add(new int[] {0, 0});
		
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, -1, 0, 1};
		int d = 0;
		for (int i = 0; i < n; i++) {
			char now = move.charAt(i);
			if (now == 'L') d = (d + 3) % 4;
			else if (now == 'R') d = (d + 1) % 4;
			else {
				int[] tmp = list.get(list.size() - 1);
				int nx = tmp[0] + dx[d];
				int ny = tmp[1] + dy[d];
				list.add(new int[] {nx, ny});
			}
		}
		
		int minX = 0, minY = 0, maxX = 0, maxY = 0;
		for (int i = 0; i < list.size(); i++) {
			minX = Math.min(minX, list.get(i)[0]);
			minY = Math.min(minY, list.get(i)[1]);
			maxX = Math.max(maxX, list.get(i)[0]);
			maxY = Math.max(maxY, list.get(i)[1]);
		}
		
		
		int x = maxX - minX + 1;
		int y = maxY - minY + 1;
		char[][] arr = new char[x + 1][y + 1];
		for (int i = 0; i < x + 1; i++) {
			Arrays.fill(arr[i], '#');
		}
		
		for (int i = 0; i < list.size(); i++) {
			int[] tmp = list.get(i);
			arr[tmp[0] - minX][tmp[1] - minY] = '.';
		}
		
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				sb.append(arr[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}