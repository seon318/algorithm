import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		Map<String , String> map = new HashMap<>();
		String strA, strB;
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			strA = st.nextToken();
			strB = st.nextToken();
			map.put(strA, strB);
		}
		for (int i = 0; i < m; i++) {
			sb.append(map.get(br.readLine())).append("\n");
		}
		System.out.println(sb);
	}


}