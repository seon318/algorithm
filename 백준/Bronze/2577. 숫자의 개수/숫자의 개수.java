import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		String mul = a*b*c + "";
		int[] ans = new int[10];
		
		for (int i=0; i<mul.length(); i++) {
			int x = Character.getNumericValue(mul.charAt(i));
			++ans[x];
		}
		
		for (int i=0; i<10; i++) {
			System.out.println(ans[i]);
		}
	}
}