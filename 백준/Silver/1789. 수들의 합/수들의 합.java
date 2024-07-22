import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long s = sc.nextLong();
		long sum = 0;
		long now = 0;
		
		while (true)  {
			sum += ++now;
			if (sum > s) {
				break;
			}
		}
		System.out.println(--now);
	}
}
