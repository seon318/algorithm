import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[42];
		int x;
		for (int i=0; i<10; i++) {
			x = sc.nextInt();
			arr[x%42] = 1;
		}
		int sum = IntStream.of(arr).sum();
		System.out.println(sum);
	}
}
