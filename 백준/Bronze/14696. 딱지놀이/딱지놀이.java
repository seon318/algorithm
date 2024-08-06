import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		List<Integer> a = new ArrayList<>();
		List<Integer> b = new ArrayList<>();
		int num1, num2, idx;
		int n = Integer.parseInt(br.readLine());

		outer: for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			num1 = Integer.parseInt(st.nextToken());
			a.clear();
			for (int j = 0; j < num1; j++) {
				a.add(Integer.parseInt(st.nextToken()));
			}
			Collections.sort(a, Collections.reverseOrder());

			st = new StringTokenizer(br.readLine());
			num2 = Integer.parseInt(st.nextToken());
			b.clear();
			for (int j = 0; j < num2; j++) {
				b.add(Integer.parseInt(st.nextToken()));
			}
			Collections.sort(b, Collections.reverseOrder());
			for (int k = 0; k < Math.min(num1, num2); k++) {
				if (a.get(k) > b.get(k)) {
					System.out.println('A');
					continue outer;
				} else if (a.get(k) < b.get(k)) {
					System.out.println('B');
					continue outer;
				}
			}

			if (num1 > num2) System.out.println('A');
			else if (num1 == num2) System.out.println('D');
			else System.out.println('B');
		}
	}

}