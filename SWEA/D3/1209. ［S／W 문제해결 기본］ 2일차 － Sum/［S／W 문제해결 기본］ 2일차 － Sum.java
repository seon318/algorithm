import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc, max, sum;
		int[][] arr = new int[100][100];
		
		for (int t = 1; t <= 10; t++) {
			tc = Integer.parseInt(br.readLine());
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			max = 0;
			//모든 행 확인
			for (int i = 0; i < 100; i++) {
				sum = 0;
				for (int j = 0; j < 100; j++) {
					sum += arr[i][j];
				}
				max = Math.max(sum, max);
			}
			
			//모든 열 확인
			for (int i = 0; i < 100; i++) {
				sum = 0;
				for (int j = 0; j < 100; j++) {
					sum += arr[j][i];
				}
				max = Math.max(sum, max);
			}
			
			//왼->오 대각선 확인
			sum = 0;
			for (int i = 0; i < 100; i++) {
				sum += arr[i][i];
			}
			max = Math.max(sum, max);
			
			//오->왼 대각선 확인
			sum = 0;
			for (int i = 0; i < 100; i++) {
				sum += arr[i][99-i];
			}
			max = Math.max(sum, max);
			
			System.out.printf("#%d %d\n", t, max);
		}
	}

}
