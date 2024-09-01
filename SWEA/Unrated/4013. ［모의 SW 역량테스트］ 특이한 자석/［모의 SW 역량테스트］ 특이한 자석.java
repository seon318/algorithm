import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int k, num, dir, score;
	static int[][] magnet;
	static int[] idx, rotate;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= t; tc++) {
			k = Integer.parseInt(br.readLine());
			magnet = new int[4][8];
			
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					magnet[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			idx = new int[4];
			score = 0;
			
			for (int c = 0; c < k; c++) {
				st = new StringTokenizer(br.readLine());
				num = Integer.parseInt(st.nextToken()) - 1;
				dir = Integer.parseInt(st.nextToken());
				rotate = new int[4];
				
				//어디까지 회전 되는지 확인 
				rotate[num] = dir;
				for (int i = num; i > 0; i--) {
					if (magnet[i - 1][(idx[i - 1] + 2) % 8] != magnet[i][(idx[i] + 6) % 8])rotate[i - 1] = -rotate[i];
					else break;
				}
				for (int i = num; i < 3; i++) {
					if (magnet[i][(idx[i] + 2) % 8] != magnet[i + 1][(idx[i + 1] + 6) % 8])rotate[i + 1] = -rotate[i];
					else break;
				}
				
				//자석 돌리기 
				for (int i = 0; i < 4; i++) {
					if (rotate[i] == -1) idx[i] = (idx[i] + 1) % 8;
					else if (rotate[i] == 1) idx[i] = (idx[i] + 7) % 8;
				}
			}
			
			//점수 확인하기 
			for (int i = 0; i < 4; i++) {
				if (magnet[i][idx[i]] == 1) score += (1 << i);
			}
			
			sb.append("#").append(tc).append(" ").append(score).append("\n");
		}
		System.out.println(sb);
	}
}