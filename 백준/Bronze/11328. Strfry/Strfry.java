import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	int[] alpha1, alpha2;
    	String str1, str2;
    	StringTokenizer st;
    	
    	for (int t=0; t<n; t++) {
    		st = new StringTokenizer(br.readLine());
    		str1 = st.nextToken();
    		alpha1 = new int[26];
    		for (int i=0; i<str1.length(); i++) {
    			alpha1[str1.charAt(i)-97]++;
    		}
    		str2 = st.nextToken();
    		alpha2 = new int[26];
    		for (int i=0; i<str2.length(); i++) {
    			alpha2[str2.charAt(i)-97]++;
    		}
    		System.out.println(Arrays.toString(alpha1).equals(Arrays.toString(alpha2)) ? "Possible" : "Impossible"); 
    	}

    }
}
