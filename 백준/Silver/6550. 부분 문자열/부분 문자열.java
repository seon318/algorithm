import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String str;
		
		while ((str = br.readLine()) != null) {
			 st = new StringTokenizer(str);
			String s = st.nextToken();
			String t = st.nextToken();
			
			int idx = 0;
			for (int i = 0; i < t.length(); i++) {
				if (t.charAt(i) == s.charAt(idx)) idx++;
				if (idx == s.length()) break;
			}
			
			System.out.println(idx == s.length() ? "Yes" : "No");
			
		}

	}

}