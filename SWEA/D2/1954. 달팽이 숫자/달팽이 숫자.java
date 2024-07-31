import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int n, num, x, y, dir, nx, ny;
		int[][] snail;
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		
		for (int tc=1; tc<=t; tc++) {
			n = Integer.parseInt(br.readLine());
			snail = new int[n][n];
			num = 0;
			x = 0;
			y = 0;
			dir = 0;
			
			//현재 할당할 숫자 num을 하나씩 키우며 n-1까지 숫자 할당
			while (num++ < n*n) {
				snail[x][y] = num;
				//현재 이동방향으로 한 칸 보내기
				nx = x + dx[dir];
				ny = y + dy[dir];
				//범위체크 & 이미 할당된 칸인지 확인
				if (0 > nx || nx >= n || 0 > ny || ny >= n || snail[nx][ny] != 0) {
					dir = (++dir) % 4; //다음 방향으로 바꾸기
					//바뀐 방향으로 한 칸 보내기
					nx = x + dx[dir];
					ny = y + dy[dir];
				}
				//x, y값 갱신하기
				x = nx;
				y = ny;
			}
			
			System.out.println("#"+tc);
			for (int i=0; i<n; i++) {
				for (int j=0; j<n; j++) {
					System.out.print(snail[i][j]+" ");
				}
				System.out.println();
			}
		}
		
	}

}
