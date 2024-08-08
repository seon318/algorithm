import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		int n, sum;
		String str;
		
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());

			sum = 0;
			//넓어지는 부분
			for (int i = 0; i <= n/2; i++) {
				str = br.readLine();
				for (int j = n/2 - i; j <  i + 1 + n/2; j++) {
					sum += str.charAt(j) - '0';
				}
			}
			
			//좁아지는 부분
			for (int i = n/2 - 1; i >= 0; i--) {
				str = br.readLine();
				for (int j = n/2 - i; j < i + 1 + n/2 ; j++) {
					sum += str.charAt(j) - '0';
				}
			}
			bw.append("#" + tc + " " + sum + "\n");
		}
		bw.flush();
	}
}