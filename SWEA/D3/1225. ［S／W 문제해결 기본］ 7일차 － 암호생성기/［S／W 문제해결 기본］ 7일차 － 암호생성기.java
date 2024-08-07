import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;
		int[] arr = new int[8];
		int t, idx, num;
		
		for (int tc = 1; tc <= 10; tc++) {
			idx = 0;
			num = 1;
			
			t = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 8; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			while (true) {
				arr[idx] -= num++;
				if (arr[idx] <= 0) {
					arr[idx++] = 0;
					break;
				}
				num = num > 5 ? 1 : num;
				idx = ++idx % 8;
			}
			
			System.out.print("#" + t + " ");
			for (int i = 0; i < 8; i++) {
				System.out.print(arr[(idx+i) % 8] + " ");
			}
			System.out.println();
			
		}
	}
}
