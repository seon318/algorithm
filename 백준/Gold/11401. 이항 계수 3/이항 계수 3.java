import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long n, k, p;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		p = 1000000007;
		
		System.out.println((pow(fac(n - k) * fac(k) % p, p-2) * fac(n)) % p);

	}
	
	private static long pow(long l, long m) {
		if (m == 1) return l % p;
		long num = pow(l, m / 2);
		
		if (m % 2 == 1) return (num * num % p) * l % p;
		return num * num % p;
	}

	static long fac(long x) {
		long num = 1;
		for (int i = 2; i <= x; i++) {
			num *= i;
			num %= p;
		}
		return num;
	}
}