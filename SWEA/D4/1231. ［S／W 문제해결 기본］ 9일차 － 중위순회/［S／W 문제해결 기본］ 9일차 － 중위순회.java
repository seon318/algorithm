import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
	static StringBuilder sb = new StringBuilder();
	static int[][] arr;
	static char[] node;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int n, idx, ans;

		for (int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			arr = new int[n + 1][2]; // 자식 정보 저장
			node = new char[n + 1]; // 정점 문자 저장

			// arr에 부모-자식 노드 입력하기
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				idx = Integer.parseInt(st.nextToken());
				node[idx] = st.nextToken().charAt(0);
				// 만약 자식 노드가 있다면
				if (st.hasMoreTokens()) {
					arr[idx][0] = Integer.parseInt(st.nextToken()); // 왼쪽
				}
				if (st.hasMoreTokens()) {
					arr[idx][1] = Integer.parseInt(st.nextToken()); // 오른쪽
				}
			}

			// 사칙연산 계산하기
			sb.append("#").append(tc).append(" ");
			inorder(1);
			sb.append("\n");
		}

		bw.append(sb).flush();
	}

	public static void inorder(int root) {
		if (root >= arr.length || root == 0)
			return;

		inorder(arr[root][0]); // 왼쪽
		sb.append(node[root]); // 정점
		inorder(arr[root][1]); // 오른쪽

	}
}
