import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int[] alpha = new int[26];
		for (int i=0; i<s.length(); i++) {
			alpha[s.charAt(i)-97]++;
		}
		for (int i=0; i<26; i++) {
			System.out.print(alpha[i]+" ");
		}
	}
}
