import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static long n, p, q;
	static HashMap<Long, Long> map = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Long.parseLong(st.nextToken());
		p = Long.parseLong(st.nextToken());
		q = Long.parseLong(st.nextToken());
		
		map.put(0L, 1L);
		System.out.println(dfs(n));
	}

	private static long dfs(long x) {
		if (map.containsKey(x)) return map.get(x);
		long i = (long)Math.ceil(x/p);
		long j = (long)Math.ceil(x/q);
		map.put(i, dfs(i));
		map.put(j, dfs(j));
		return map.get(i) + map.get(j);
	}
}