public class Main {

	public static void main(String[] args) {
		boolean[] arr = new boolean[10001];
		int sum = 0;
		for (int i=1; i<=10000; i++) {
			String num = i + "";
			sum = i;
			for (int t=0; t<num.length(); t++) {
				sum += Character.getNumericValue(num.charAt(t));
			}
			if (sum <=10000) arr[sum] = true;
		}
		
		for (int i=1; i<=10000; i++) {
			if (!arr[i]) System.out.println(i);
		}
		
	}
}
