import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static String T, P;
	static int ans, tLen, pLen, pi[];
	static List<Integer> list = new ArrayList<>();
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	T = br.readLine();
    	P = br.readLine();
    	tLen = T.length();
    	pLen = P.length();
    	pi = new int[pLen];
    	
    	getPi();
    	kmp();
    	
    	StringBuilder sb = new StringBuilder();
    	sb.append(ans).append('\n');
    	for (int i = 0; i < list.size(); i++) {
    		sb.append(list.get(i)).append(' ');
    	}
    	
    	System.out.println(sb);
    }
    
    public static void kmp() {
    	int j = 0;
    	for (int i = 0; i < tLen; i++) {
    		while (j > 0 && T.charAt(i) != P.charAt(j)) {
    			j = pi[j - 1];
    		}
    		if (T.charAt(i) == P.charAt(j)) {
    			if (j == pLen - 1) {
    				ans++;
    				list.add(i - pLen + 2);
    				j = pi[j];
    			} else j++;
    		}
    	}
		
	}

	public static void getPi() {
    	int j = 0;
    	for (int i = 1; i < pLen; i++) {
    		while (j > 0 && P.charAt(i) != P.charAt(j)) {
    			j = pi[j - 1];
    		}
    		if (P.charAt(i) == P.charAt(j)) pi[i] = ++j;
    	}
    }
    
    
}