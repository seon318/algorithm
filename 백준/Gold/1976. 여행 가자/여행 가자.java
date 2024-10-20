import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m, link, num;
	static int[] p;
	
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		p = new int[n + 1];
		for (int i = 1; i <= n; i++) p[i] = i;
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				link = Integer.parseInt(st.nextToken());
				if (link == 1 && parent(i) != parent(j)) {
					p[parent(i)] = p[parent(j)];
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		num = parent(Integer.parseInt(st.nextToken()));
		for (int i = 1; i < m; i++) {
			if (num != parent(Integer.parseInt(st.nextToken()))) {
				System.out.println("NO");
				return;
			}
		}
		
		System.out.println("YES");
    }
    
    static int parent(int x) {
    	if (x != p[x]) p[x] = parent(p[x]);
    	return p[x];
    }

}