import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		String str;
		List<Character> list = new ArrayList<>();

		for (int tc = 1; tc <= t; tc++) {
			str = br.readLine();
			list.clear();
			list.add(str.charAt(0));

			outer: for (int i = 1; i < str.length(); i++) {
				if (list.isEmpty() || list.get(0) != str.charAt(i))
					list.add(str.charAt(i));
				else {
					for (int j = 1; j < list.size(); j++) {
						if (list.get(j) != str.charAt(i + j)) {
							list.add(str.charAt(i));
							continue outer;
						}
					}

					break;
				}
			}

			sb.append("#").append(tc).append(" ").append(list.size()).append("\n");
		}

		System.out.println(sb);
	}
}
