import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();

		System.out.println((A + B - C));
		
String a = String.valueOf(A);
String b = String.valueOf(B);

		System.out.println(Integer.parseInt(a + b) - C);
		
		
		sc.close();

	}
}
