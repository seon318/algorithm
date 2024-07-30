import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc=1; tc<=10; tc++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[100];
			
			for (int i=0; i<100; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i=0; i<n; i++) {
				Arrays.sort(arr);
				arr[0]++;
				arr[arr.length-1]--;
			}
			
			Arrays.sort(arr);
			
			System.out.printf("#%d %d\n", tc, arr[arr.length-1]-arr[0]);
		}
	}
}
