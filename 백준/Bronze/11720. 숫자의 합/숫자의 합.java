import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.nextLine());
		int sum = 0;
		String arr = sc.nextLine();
		for (int i = 0; i < num; i++) {
			sum += Integer.parseInt(arr.substring(i, i+1));
		}
		System.out.println(sum);
	}
}