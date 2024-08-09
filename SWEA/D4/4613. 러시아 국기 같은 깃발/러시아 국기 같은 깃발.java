import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int n, m;
		int t = Integer.parseInt(br.readLine());
		int[][] flag; //각 줄별 색상별 개수 저장
		int sum, max_sum;
		String row;
		//색상별 flag 배열 인덱스
		Map<Character, Integer> map = new HashMap<>();
		map.put('W', 0);
		map.put('B', 1);
		map.put('R', 2);

		// 1. 입력
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			flag = new int[n][3];

			for (int i = 0; i < n; i++) {
				row = br.readLine();
				for (int j = 0; j < row.length(); j++) {
					flag[i][map.get(row.charAt(j))]++;
				}
			}
			
			//2. 바꾸지 않아도 되는 색을 최대로 만들기
			max_sum = 0;
			for (int t1 = 1; t1 < n -1; t1++) {
				for (int t2 = t1 + 1; t2 < n; t2++) {
					sum = 0;
					for (int i = 0; i < n; i++) {
						if (i < t1) sum += flag[i][0];
						else if (i < t2) sum += flag[i][1];
						else sum += flag[i][2];
					}
					max_sum = Math.max(max_sum, sum);
				}
			 }
 
			// 3. 출력
			bw.append("#" + tc + " " + (n * m - max_sum) + "\n");
		}
		bw.flush();
	}
}
