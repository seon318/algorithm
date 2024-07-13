import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[] students = new boolean[31];
	
		for (int i=1; i<29; i++) {
			int s = sc.nextInt();
			students[s] = true;
		}
		
		for (int i=1; i<31; i++) {
			if (!students[i]) System.out.println(i);
		}
	}
}
