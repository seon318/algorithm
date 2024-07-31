import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t;
		int n = 100;
		int r = 0;
		int c = 0;
		int[][] arr = new int[100][100];

		for (int tc = 1; tc <=10; tc++) {
			t = Integer.parseInt(br.readLine());
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					//출발 위치 r, c (X 지점에서부터 거꾸로 탐색할 예정)
					if (i == 99 && arr[i][j] == 2) {
						r = i;
						c = j;
					}
				}
			}
			//가장 윗 줄에 도달할 때까지 계속 위로 올라가기
			while (r > 0) {
				r--;
				//좌측 확인해서 1이면 좌측에 1이 없을 때까지 계속 이동
				if (c-1 >= 0 && arr[r][c-1] == 1) {
					while (c-1 >= 0 && arr[r][c-1] == 1) {
						c--;
					}
				} 
				//우측 확인해서 1이면 우측에 1이 없을 때까지 계속 이동
				else if (c+1 < n && arr[r][c+1] == 1) {
					while (c+1 < n && arr[r][c+1] == 1) {
						c++;
					}
				}
			}
			System.out.printf("#%d %d\n", t, c);
		}
	}

}
