import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Base64;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		String encodedStr, decodedStr;
		byte[] decodedBytes;
		
		for (int tc = 1; tc <= t; tc++) {
			encodedStr = br.readLine();
			decodedBytes = Base64.getDecoder().decode(encodedStr);
			decodedStr = new String(decodedBytes);
			
			sb.append("#").append(tc).append(" ").append(decodedStr).append("\n");
		}
		
		System.out.println(sb);
	}
}
