import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		String a = " ";
		String b = "*";
		for (int i = 1; i <= num; i++) {
			System.out.println(a.repeat(num-i) + b.repeat(i));
		}
	}
}