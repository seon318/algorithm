import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	static int n, k, num;
	static String input;
	static StringBuilder numX;
	static Set<Integer> set = new HashSet<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= t; tc++) {

			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			input = br.readLine();
			
			for (int i = 0; i < n; i++) {
				numX = new StringBuilder();
				for (int j = i; j < i + n / 4; j++) {
					numX.append(input.charAt(j % n));
				}
				set.add(Integer.parseInt(numX.toString(), 16));
			}
			
			Integer[] newSet = set.toArray(new Integer[0]);
			Arrays.sort(newSet, Comparator.reverseOrder());
			sb.append("#").append(tc).append(" ").append(newSet[k-1]).append('\n');
			set.clear();
		}
		
		System.out.println(sb);
	}
}