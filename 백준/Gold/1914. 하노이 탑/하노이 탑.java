import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		BigInteger moves = BigInteger.valueOf(2).pow(n).subtract(BigInteger.ONE);
		System.out.println(moves);
		if (n <= 20) {
			hanoi(n, 1, 3, 2);
			System.out.println(sb);
		}
	}

	static void hanoi(int n, int start, int end, int mid) {
		if (n == 1) {
			sb.append(start).append(" ").append(end).append("\n");
			return;
		}
		hanoi(n-1, start, mid, end);
		sb.append(start).append(" ").append(end).append("\n");
		hanoi(n-1, mid, end, start);
	}

}