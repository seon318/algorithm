import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		String result;
		if (a >= 90) result = "A";
		else if (a >= 80) result = "B";
		else if (a >=70) result = "C";
		else if (a >= 60) result = "D";
		else result = "F";
		
		System.out.println(result);
	}
}