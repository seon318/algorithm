import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int ans = 0;
    	String str1 = br.readLine();
    	String str2 = br.readLine();
    	int[] alpha1 = new int[26];
    	for (int i=0; i<str1.length(); i++) {
    		alpha1[str1.charAt(i)-97]++;
    	}
    	int[] alpha2 = new int[26];
    	for (int i=0; i<str2.length(); i++) {
    		alpha2[str2.charAt(i)-97]++;
    	}
    	for (int i=0; i<26; i++) {
    		ans += Math.abs(alpha1[i]-alpha2[i]);
    	}
    	System.out.println(ans);
    }
}
