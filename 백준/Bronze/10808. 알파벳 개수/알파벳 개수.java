import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int[] arr = new int[26];
		int i = -1;
		for (char c = 'a'; c <= 'z'; c++) {
			i++;
			for (int index = 0; index < s.length(); index++) {
				if (s.charAt(index) == c) {
					arr[i]++;
				}
			}
		}
		for (int j = 0; j < 25; j++) {
			System.out.print(arr[j] + " ");
		}
		System.out.print(arr[25]);
		sc.close();
	}
}
