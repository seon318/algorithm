import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int[] arr = new int[x];
			for (int i = 0; i < x; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			long sum = 0;
			for (int i = 0; i < x - 1; i++) {
				for (int j = i + 1; j < x; j++) {
					sum += gcd(Math.max(arr[i], arr[j]), Math.min(arr[i], arr[j]));
				}
			}
			System.out.println(sum);
		}
	}
	
	static int gcd(int a, int b) {
		while (b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
}