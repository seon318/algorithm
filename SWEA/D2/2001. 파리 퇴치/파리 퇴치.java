import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n, m, total, max;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc<=t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			arr = new int[n][n];
			for (int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			max = 0; // 최댓값 초기화
			//0 ~ n-m을 시작 인덱스로 설정해서 catchFlies() 실행 후 최댓값 갱신
			for (int i=0; i<=n-m; i++) {
				for (int j=0; j<=n-m; j++) {
					max = Math.max(max, catchFlies(i, j));
				}
			}
			System.out.printf("#%d %d\n", tc, max);
		}
		
	}
	
	//시작 인덱스로부터 m*m배열의 합 반환
	static int catchFlies(int i, int j) {
		total = 0;
		for (int x=i; x<i+m; x++) {
			for (int y=j; y<j+m; y++) {
				total += arr[x][y];
			}
		}
		return total;
	}
}
