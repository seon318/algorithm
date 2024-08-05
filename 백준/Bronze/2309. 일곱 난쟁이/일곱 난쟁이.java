import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dwarfs = new int[9];
		int sum = 0;
		
		for (int i = 0; i < 9; i++) {
			dwarfs[i] = Integer.parseInt(br.readLine());
			sum += dwarfs[i];
		}
		
		outer: for (int i = 0; i < 9; i++) {
			for (int j = i+1; j < 9; j++) {
				if (sum - dwarfs[i] - dwarfs[j] == 100) {
					dwarfs[i] = dwarfs[j] = 100;
					break outer;
				}
			}
		}
		
		Arrays.sort(dwarfs);
		
		for (int i = 0; i < 7; i++) {
			System.out.println(dwarfs[i]);
		}
	}
}