import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long a, b, min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		min = Integer.MAX_VALUE;
		
		calc(a, 0);
		
		System.out.println(min == Integer.MAX_VALUE ? -1 : min+1);
	}
	
	static long multiple(long x) {
		return x * 2;
	}
	
	static long addone(long x) {
		return Long.parseLong(x + "1");
	}
	
	static void calc(long x, long ans) {
		if (x == b) {
			min = Math.min(min, ans);
			return;
		} else if (x > b){
			return;
		}
		calc(multiple(x), ans+1);
		calc(addone(x), ans+1);
	}
}
