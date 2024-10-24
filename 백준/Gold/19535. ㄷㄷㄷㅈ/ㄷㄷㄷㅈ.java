import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		List<Integer>[] list = new ArrayList[n+1];
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		long d =0, g=0;
		boolean[] check = new boolean[n+1];
		for(int i = 1; i <= n; i++) {
			long a = list[i].size();
			if(a >= 3) {
				g += (a*(a-1)*(a-2))/6;
			}
			
			check[i] = true;
			for(int nxt : list[i]) {
				long b = list[nxt].size();
				if(!check[nxt]) {
					d += (a-1)*(b-1);
				}
			}
		}
		
		if (d == g * 3) System.out.println("DUDUDUNGA");
		else if (d < g * 3) System.out.println("G");
		else System.out.println("D");
	}

}