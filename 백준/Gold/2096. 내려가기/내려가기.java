import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[][] num = new int[n][3];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			num[i][0] = Integer.parseInt(st.nextToken());
			num[i][1] = Integer.parseInt(st.nextToken());
			num[i][2] = Integer.parseInt(st.nextToken());
		}
		int[][] maxArr = new int[n][3];
		maxArr[0] = num[0];
		for (int i = 1; i < n; i++) {
			maxArr[i][0] = Math.max(maxArr[i-1][0], maxArr[i-1][1]) + num[i][0];
			maxArr[i][1] = Math.max(maxArr[i-1][0], Math.max(maxArr[i-1][1], maxArr[i-1][2])) + num[i][1];
			maxArr[i][2] = Math.max(maxArr[i-1][1], maxArr[i-1][2]) + num[i][2];
		}
		
		int[][] minArr = new int[n][3];
		minArr[0] = num[0];
		for (int i = 1; i < n; i++) {
			minArr[i][0] = Math.min(minArr[i-1][0], minArr[i-1][1]) + num[i][0];
			minArr[i][1] = Math.min(minArr[i-1][0], Math.min(minArr[i-1][1], minArr[i-1][2])) + num[i][1];
			minArr[i][2] = Math.min(minArr[i-1][1], minArr[i-1][2]) + num[i][2];
		}
		
		int max = Math.max(maxArr[n-1][0], Math.max(maxArr[n-1][1], maxArr[n-1][2]));
		int min = Math.min(minArr[n-1][0], Math.min(minArr[n-1][1], minArr[n-1][2]));
		System.out.println(max + " " + min);
	}
}