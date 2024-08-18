import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        String str;
        int ans;
        
        for (int tc = 1; tc <= t; tc++) {
            str = br.readLine();
            ans = 0;
            for (int i = 0; i < str.length(); i++) {
            	if (str.charAt(i) == '(') {
            		ans++;
            		if (str.charAt(i + 1) == ')') i++;
            	} else if (str.charAt(i) == ')') ans++;
            }

            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
