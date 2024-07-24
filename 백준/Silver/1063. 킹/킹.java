import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {	
	static String[] movement = {"R", "L", "B", "T", "RT", "LT", "RB", "LB"};
	static List<String> moveList = Arrays.asList(movement);
	
	static int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
	static int[] dy = {0, 0, -1, 1, 1, 1, -1, -1};
	static int idx, kx, ky, rx, ry;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		int[] king = {input.charAt(0) - 64, Character.getNumericValue(input.charAt(1))};
		input = sc.next();
		int[] rock = {input.charAt(0) - 64, Character.getNumericValue(input.charAt(1))};

		int n = sc.nextInt();
		
		for (int i=0; i<n; i++) {
			input = sc.next();
			idx = moveList.indexOf(input);
			kx = king[0]+dx[idx];
			ky = king[1]+dy[idx];
			rx = rock[0];
			ry = rock[1];
			if (kx == rock[0] && ky == rock[1]) {
				rx += dx[idx];
				ry += dy[idx];
			}
			if (0<kx && kx<=8 && 0<ky && ky<=8 && 0<rx && rx<=8 && 0<ry && ry<=8) {
				king[0] = kx;
				king[1] = ky;
				rock[0] = rx;
				rock[1] = ry;
			}
		}
		
		System.out.println((char)(king[0]+64)+(king[1]+""));
		System.out.println((char)(rock[0]+64)+(rock[1]+""));

	}
}