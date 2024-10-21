import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int g = Integer.parseInt(br.readLine());
		
		int[] square = new int[g/2 + 2];
		for (int i = 1; i <= g/2 + 1; i++) {
			square[i] = i * i;
		}
		
		List<Integer> list = new ArrayList<>();
		
		int l = 1;
		int r = 2;
		while (r <= g/2 + 1) {
			if (square[r] - square[l] == g) {
				list.add(r++);
				l++;
			} else if (square[r] - square[l] < g) r++;
			else l++;
			if (l == r) break;
		}
		
		StringBuilder sb = new StringBuilder();
		if (list.size() == 0) sb.append(-1);
		else for (int i : list) sb.append(i).append("\n");
		
		System.out.println(sb);
    }

}