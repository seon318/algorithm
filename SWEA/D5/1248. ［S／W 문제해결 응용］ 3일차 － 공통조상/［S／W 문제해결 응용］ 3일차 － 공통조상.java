import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	static int[][] arr;
	static int ans, x, y, n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		int v, e, parent, child;

		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			arr = new int[v + 1][2];

			// arr에 부모-자식 노드 입력하기
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < e; i++) {
				parent = Integer.parseInt(st.nextToken());
				child = Integer.parseInt(st.nextToken());
				if (arr[parent][0] == 0)
					arr[parent][0] = child;
				else
					arr[parent][1] = child;
			}

			// 순회하며 두 정점의 공통 조상 찾기
			check(1);
			ans = 0;
			preorder(n);

			sb.append("#").append(tc).append(" ").append(n).append(" ").append(ans).append("\n");

		}
		bw.append(sb).flush();
	}

	public static boolean check(int root) {
		// 만약 루트가 0이거나 최대 번호보다 크다면 반환
		if (root >= arr.length || root == 0)
			return false;

		// 타겟 번호를 찾을 경우 true 반환
		if (root == x || root == y)
			return true;

		boolean findX = check(arr[root][0]);
		boolean findY = check(arr[root][1]);

		// 둘 다 찾았을 경우 n을 root로 설정 후 true 반환
		if (findX && findY) {
			n = root;
			return true;
			// 둘 중 하나만 찾았을 경우 true 반환
		} else if (findX || findY) {
			return true;
		}
		// 둘 다 못 찾았을 경우 false 반환
		return false;
	}

	public static void preorder(int root) {
		// 만약 루트가 0이거나 e+1보다 크다면 반환
		if (root >= arr.length || root == 0)
			return;
		ans++; // 루트
		preorder(arr[root][0]); // 왼쪽
		preorder(arr[root][1]); // 오른쪽
	}
}