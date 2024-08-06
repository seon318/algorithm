import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String duck = br.readLine();
		boolean isValid = true;
		int ans = 0;
		int[] freq = new int[5];
		Map<Character, Integer> m = new HashMap<>();
		m.put('q', 0);
		m.put('u', 1);
		m.put('a', 2);
		m.put('c', 3);
		m.put('k', 4);
		out: for (char c : duck.toCharArray()) {
			if (c == 'q') {
				ans++;
				if (freq[4] > 0) {
					ans--;
					for (int i = 0; i < 5; i++) {
						freq[i]--;
					}
				}
			}
			freq[m.get(c)]++;
			for (int i = 0; i < 4; i++) {
				if (freq[i] < freq[i + 1]) {
					isValid = false;
					break out;
				}
			}
		}
		for (int i = 0; i < 4; i++) {
			if (freq[i] != freq[i + 1])
				isValid = false;
		}
		System.out.println(isValid ? ans : -1);
	}
}