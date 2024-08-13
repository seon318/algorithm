import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<Integer> L = new ArrayList<>();
		int max = 0;
		for (int i = 0; i <= N; i++) {
			L.clear();
			L.add(N);
			L.add(i);
			int index = 0;

			while (L.get(index) - L.get(index + 1) >= 0) {
				L.add(L.get(index) - L.get(index + 1));
				index++;
			}
			max = Math.max(max, L.size());
		}
		for (int i = 0; i <= N; i++) {
			L.clear();
			L.add(N);
			L.add(i);
			int index = 0;

			while (L.get(index) - L.get(index + 1) >= 0) {
				L.add(L.get(index) - L.get(index + 1));
				index++;
			}
			if (L.size() == max) {
				System.out.println(max);
				for (int val : L) {
					System.out.print(val + " ");
				}
			}
		}
		sc.close();
	}
}
