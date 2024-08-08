import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		int n, j, tmp;
		int[] arr;

		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 1; i < arr.length; i++) {
				tmp = arr[i];
				for (j = i - 1; j >= 0 && arr[j] > tmp; j--) {
					arr[j+1] = arr[j];
				}
				arr[j+1] = tmp;
			}
			
			
			bw.append("#" + tc + " ");
			for (int i = 0; i < n; i++) {
				bw.append(arr[i] + " ");
			}
			bw.append("\n");
		}
		bw.flush();
	}
}
