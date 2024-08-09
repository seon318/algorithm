import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String memory;
		int ans;
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= t; tc++) {
			memory = br.readLine();
			
			ans = memory.charAt(0) - '0';
			for (int i = 1; i < memory.length(); i++) {
				if (memory.charAt(i) != memory.charAt(i - 1)) ans++;
			}
 
			bw.append("#" + tc + " " + ans + "\n");
		}
		bw.flush();
	}
}
