import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		n %= 1500000;
		int a = 0;
		int b = 1;
		boolean turnA = false;
		for (int i = 1; i <= n; i++) {
			turnA = !turnA;
			if (turnA) {
				a = (a + b) % 1000000;
			} else {
				b = (a + b) % 1000000;
			}
		}
		System.out.println(turnA ? b : a);
	}
}