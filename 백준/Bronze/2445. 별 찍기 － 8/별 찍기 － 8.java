import java.util.Scanner;

public class Main {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for (int i=1; i<n; i++) {
			System.out.println("*".repeat(i)+" ".repeat((n-i)*2)+"*".repeat(i));
		}
		for (int i=n; i>0; i--) {
			System.out.println("*".repeat(i)+" ".repeat((n-i)*2)+"*".repeat(i));
		}
	}
}