import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String date;
		boolean isDate;
		
		int t = sc.nextInt();
		for (int tc=1; tc<=t; tc++) {
			date = sc.next();
			isDate = true;
			int month = Integer.parseInt(date.substring(4, 6));
			int day = Integer.parseInt(date.substring(6, 8));
			if (1 > month || month > 12) isDate = false;
			else {
				switch (month) {
				case 1:
				case 3:
				case 5:
				case 7:
				case 8:
				case 10:
				case 12:
					if (1 > day || day > 31) isDate = false;
					break;
				case 4:
				case 6:
				case 9:
				case 11:
					if (1 > day || day > 30) isDate = false;
					break;
				case 2:
					if (1 > day || day > 28) isDate = false;
					break;
				}
			}
			if (isDate) System.out.printf("#%d %s/%s/%s\n", tc, date.substring(0, 4), date.substring(4, 6), date.substring(6, 8));
			else System.out.printf("#%d -1\n", tc);
		}
	}
}