import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input;
		Set<String> keys;
		int x;
		int n = Integer.parseInt(br.readLine());
		Map<String, Integer> map = new HashMap<>();
		
		for (int i = 0; i < n; i++) {
			input = br.readLine().split("[.]");
			if (map.containsKey(input[1])) x = map.get(input[1]);
			else x = 0;
			map.put(input[1], ++x);
		}
		
		List<String> keySet = new ArrayList<>(map.keySet());
		Collections.sort(keySet);
		
		for (String key : keySet) {
			System.out.print(key + " ");
			System.out.print(map.get(key) + "\n");
		}
	}

}