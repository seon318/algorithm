import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S = sc.nextLine();
		for (char c = 'a'; c <= 'z'; c++) {
			System.out.println(findIdx(S,c));
		}

	}

	static int findIdx(String S, char c) {
		int idx=0;
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == c) {
				idx = i;
				break;
			}
			else {
				idx = -1;
			}
		}
		return idx;
	}
}
