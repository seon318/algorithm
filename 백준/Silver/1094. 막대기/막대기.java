import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int ans = 0;
		
		//이진수로 바꾸어서 1의 개수를 셈
		String binary = Integer.toBinaryString(x);
		
		for (int i=0; i<binary.length(); i++) {
			if (binary.charAt(i) == '1') ans++;
		}
		
		System.out.println(ans);
	}
}