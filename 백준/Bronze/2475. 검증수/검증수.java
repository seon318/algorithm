import java.util.Scanner;
import java.lang.Math;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		for (int i=0; i < 5; i++) {
			num += Math.pow(sc.nextInt(), 2);
		}
		num %= 10;
		System.out.println(num);
	}
}