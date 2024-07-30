import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc<=t; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];

			st = new StringTokenizer(br.readLine());
			for (int i=0; i<n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i=0; i<n; i++) {
				int min = i;
				for (int j=i; j<n; j++) {
					if (arr[j] < arr[min]) {
						min = j;
					}
				}
				int tmp = arr[i];
				arr[i] = arr[min];
				arr[min] = tmp;
			}
			
			System.out.print("#"+tc+" ");
            for (int i=0; i<n; i++) {
               System.out.print(arr[i]+" ");
            }
            System.out.println();
		}
	}
}