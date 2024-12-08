import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] cnt;
	static int digit = 1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int X = 1;
		cnt = new int[10];
		
		while (X <= N) {
			while (X % 10 != 0 && X <= N) {
				count(X);
				X++;
			}
			
			while (N % 10 != 9 && X <= N) {
				count(N);
				N--;
			}
			
			if (X > N) break;
			
			X /= 10;
			N /= 10;
			
			for (int i = 0; i < 10; i++) {
				cnt[i] += (N - X + 1) * digit;
			}
			
			digit *= 10;
		}
		
		for (long i : cnt) {
			sb.append(i).append(" ");
		}
		
		System.out.println(sb);
	}

	private static void count(int n) {
		while (n > 0) {
			cnt[n % 10] += digit;
			n /= 10;
		}
	}
}