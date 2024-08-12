import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<Integer> l = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			l.add(i - num, i + 1);
		}
		for(int value : l) {
		System.out.print(value + " ");
		}
}
}