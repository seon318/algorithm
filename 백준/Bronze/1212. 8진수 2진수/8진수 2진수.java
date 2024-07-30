import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n = br.readLine();
		String[] binary = {"000", "001", "010", "011", "100", "101", "110", "111"};
		StringBuilder ans = new StringBuilder();

		ans.append(Integer.parseInt(binary[n.charAt(0)-'0']));
		for (int i=1; i<n.length(); i++) {
			ans.append(binary[n.charAt(i)-'0']);
		}
		System.out.println(ans);
	}
}