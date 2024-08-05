import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> list = new LinkedList<>();
		int x;
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			x = Integer.parseInt(st.nextToken());
			list.add(i - 1 - x, i);
		}
		
		for (int i = 0; i < n; i++) {
			System.out.print(list.get(i) + " ");
		}
	}
}