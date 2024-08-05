import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String now, clap;

		for (int i = 1; i <= n; i++) {
			now = i + "";
			if (now.contains("3") || now.contains("6") || now.contains("9")) {
				clap = "";
				for (int j = 0; j < now.length(); j++) {
					if (now.charAt(j) % 3 == 0 && now.charAt(j) != '0') {
						clap += "-";
					}
				}
				now = clap;
			}
			System.out.print(now + " ");
		}
	}

}