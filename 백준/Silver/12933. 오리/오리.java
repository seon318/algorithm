import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> ducks = new ArrayList<>();
		List<Character> alpha = new ArrayList<>(Arrays.asList('q', 'u', 'a', 'c', 'k'));
		int x;
		String input = br.readLine();
		
		for (int i = 0; i < input.length(); i++) {
			x = alpha.indexOf(input.charAt(i));
			if (ducks.contains(x-1)) ducks.set(ducks.indexOf(x-1), (x==4) ? -1 : x);
			else if (x == 0) ducks.add(0);
			else {
				System.out.println(-1);
				return;
			}
		}

		for (int d : ducks) {
			if (d != -1) {
				System.out.println(-1);
				return;
			}
		}
		System.out.println(ducks.size());
	}

}