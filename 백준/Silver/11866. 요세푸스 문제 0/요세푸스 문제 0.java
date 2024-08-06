import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int idx = k-1;
        List<Integer> list = new LinkedList<>();
        
        for (int i = 1; i <= n; i++) {
        	list.add(i);
        }
        
        System.out.print("<");
        while (!list.isEmpty()) {
        	if (list.size() > 1) {
        		System.out.print(list.remove(idx) + ", ");
        		idx = (idx + k - 1) % list.size();
        	}
        	else System.out.print(list.remove(idx));
        	
        }
        System.out.print(">");

    }
}
