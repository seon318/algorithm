import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int h, w, n, command, carX, carY, bombX, bombY, nx, ny, dir;
	static char[][] map;
	static String input;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			map = new char[h][w];
			for (int i = 0; i < h; i++) {
				input = br.readLine().trim();
				for (int j = 0; j < w; j++) {
					map[i][j] = input.charAt(j);
					if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
						carX = i;
						carY = j;
						if (map[i][j] == '^') dir = 0;
						else if (map[i][j] == 'v') dir = 1;
						else if (map[i][j] == '<') dir = 2;
						else dir = 3;
						map[i][j] = '.';
					}
				}
			}
			
			n = Integer.parseInt(br.readLine());
			input = br.readLine();
			for (int i = 0; i < n; i++) {
				command = input.charAt(i);
				if (command == 'S') {
					bombX = carX;
					bombY = carY;
					
					while (true) {
						bombX += dx[dir];
						bombY += dy[dir];
						
						if (bombX < 0 || bombX >= h || bombY < 0 || bombY >= w || map[bombX][bombY] == '#') break;
						if (map[bombX][bombY] == '*') {
							map[bombX][bombY] = '.';
							break;
						}
					}
					
				} else {
					switch (command) {
					case 'U' :
						dir = 0;
						break;
					case 'D' :
						dir = 1;
						break;
					case 'L' :
						dir = 2;
						break;
					case 'R' :
						dir = 3;
						break;
					}
					
					nx = carX + dx[dir];
					ny = carY + dy[dir];
					
					if (nx < 0 || nx >= h || ny < 0 || ny >= w || map[nx][ny] != '.') continue;
					
					carX = nx;
					carY = ny;
				}
			}
			
			switch (dir) {
			case 0 : 
				map[carX][carY] = '^';
				break;
			case 1 :
				map[carX][carY] = 'v';
				break;
			case 2 :
				map[carX][carY] = '<';
				break;
			case 3 :
				map[carX][carY] = '>';
				break;
			}

			sb.append("#").append(tc).append(" ");
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

	

}