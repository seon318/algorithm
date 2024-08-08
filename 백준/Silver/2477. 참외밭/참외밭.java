import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int k = Integer.parseInt(br.readLine());
		int[] length = new int[6];

		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			length[i] = Integer.parseInt(st.nextToken());
		}

		int a1 = 0;
		int a2, b1, b2;

		for (int i = 1; i < 6; i++) {
			a1 = length[i] > length[a1] ? i : a1;
		}

		
		a2 = length[(a1 + 5) % 6] > length[(a1 + 1) % 6] ? (a1 + 5) % 6 : (a1 + 1) % 6;
		b1 = (a1 + 1) % 6 == a2 ? (a2 + 2) % 6 : (a1 + 2) % 6;
		b2 = (a1 + 1) % 6 == a2 ? (a2 + 3) % 6 : (a1 + 3) % 6;
		System.out.println((length[a1] * length[a2] - length[b1] * length[b2]) * k);
	}
}