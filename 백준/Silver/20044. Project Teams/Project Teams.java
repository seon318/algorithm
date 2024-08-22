import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] s = new int[2 * n];
		
		for (int i = 0; i < 2 * n; i++) {
			s[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(s);
		
		int min = s[0] + s[2 * n - 1];
		for (int i = 1; i < n; i++) {
			min = Math.min(min, s[i] + s[2 * n - 1 - i]);
		}
		
		System.out.println(min);
	}
}