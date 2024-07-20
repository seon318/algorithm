import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		String input;
		int score;
		int num ;
		
		for (int i=0; i<t; i++) {
			input = sc.next();
			num = 0;
			score = 0;
			for (int k=0; k<input.length(); k++) {
				if (input.charAt(k) == 'O') score += ++num;
				else num = 0;
			}
			
			System.out.println(score);
		}
	}
}
