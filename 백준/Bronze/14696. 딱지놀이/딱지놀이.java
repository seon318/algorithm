import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			sc.next();
			String s1 = sc.nextLine();
			sc.next();
			String s2 = sc.nextLine();
			String[] A = s1.trim().split(" ");
			String[] B = s2.trim().split(" ");
			for (int j = 4; j >= 1; j--) {
				int cnt1 = 0;
				int cnt2 = 0;
				for (String s : A) {
					if (Integer.parseInt(s) == j) {
						cnt1++;
					}
				}
				for (String s : B) {
					if (Integer.parseInt(s) == j) {
						cnt2++;
					}
				}
				if (cnt2 > cnt1) {
					System.out.println("B");
					break;
				} else if (cnt2 < cnt1) {
					System.out.println("A");
					break;
				} else {
					if (j == 1) {
						System.out.println("D");
					}
					continue;
				}
			}

		}
		sc.close();
	}
}
