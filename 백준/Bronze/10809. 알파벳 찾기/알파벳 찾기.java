import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int[] arr = new int[26];
		Arrays.fill(arr, -1);
		int idx;
		for (int i=0; i<s.length(); i++) {
			idx = s.charAt(i) - 97;
			if (arr[idx] == -1) arr[idx] = i;
		}
		
		for (int i=0; i<26; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
