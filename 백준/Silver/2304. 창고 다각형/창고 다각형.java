import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int l, h, max, tmp;
		
		int[] building = new int[1001];
		max = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			l = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			building[l] = h;
			if (building[max] < h) max = l;
		}
		
		tmp = 0;
		for (int i = 0; i < max; i++) {
			if (tmp < building[i]) tmp = building[i];
			building[i] = tmp;
		}
		
		tmp = 0;
		for (int i = 1000; i > max; i--) {
			if (tmp < building[i]) tmp = building[i];
			building[i] = tmp;
		}
		
		System.out.println(Arrays.stream(building).sum());
	}
}
