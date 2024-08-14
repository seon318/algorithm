import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int n, idx, ans;
		String root;

		Map<Character, Integer> map = new HashMap<>();
		map.put('+', -1);
		map.put('-', -2);
		map.put('*', -3);
		map.put('/', -4);

		for (int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			arr = new int[n + 1][3]; // 2차원 배열 생성

			// arr에 부모-자식 노드 입력하기
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				idx = Integer.parseInt(st.nextToken());
				root = st.nextToken();
				// 만약 뒤에 토큰이 남았다면 연산자인 경우임
				if (st.hasMoreTokens()) {
					arr[idx][0] = Integer.parseInt(st.nextToken()); // 왼쪽
					arr[idx][1] = Integer.parseInt(st.nextToken()); // 오른쪽
					arr[idx][2] = map.get(root.charAt(0)); // 연산자
				} else {
					arr[idx][0] = Integer.parseInt(root);
				}
			}

			// 사칙연산 계산하기
			ans = calculate(1);
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		bw.append(sb).flush();
	}

	public static int calculate(int root) {
		// 연산자인 경우
		if (arr[root][2] != 0) {
			int l = calculate(arr[root][0]); // 왼쪽
			int r = calculate(arr[root][1]); // 오른쪽
			switch (arr[root][2]) {
			case -1:
				l += r;
				break;
			case -2:
				l -= r;
				break;
			case -3: 
				l *= r;
				break;
			case -4:
				l /= r;
				break;
			}
			return l;
		// 연산자가 아닌 경우
		} else {
			return arr[root][0];
		}
	}
}
