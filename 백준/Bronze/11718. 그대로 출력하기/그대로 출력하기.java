import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			try {
				System.out.println(sc.nextLine());
			}
			
			catch (Exception e) {
				break;
			}
		}
	}
}
