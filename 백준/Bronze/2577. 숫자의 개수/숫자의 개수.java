import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[3];
		arr[0] = sc.nextInt();
		arr[1] = sc.nextInt();
		arr[2] = sc.nextInt();
		int[] num = new int[10];
		int multiple = arr[0] * arr[1] * arr[2];
		String s = Integer.toString(multiple);
		for (int i = 0; i < s.length(); i++) {
			num[s.charAt(i) - '0']++;
		}
		for (int i = 0; i < 10; i++) {
			System.out.println(num[i]);
		}
        sc.close();
	}
}
