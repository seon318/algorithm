import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int[][] sky = new int[h][w];
		String row;
		int time = 0;
		
		for (int i = 0; i < h; i++) {
			row = br.readLine();
			time = 0;
			for (int j = 0; j < w; j++) {
				if (row.charAt(j) == '.' && time == 0) sky[i][j] = -1;
				else if (row.charAt(j) == '.' && time > 0) sky[i][j] = time++;
				else if (time == 0 || row.charAt(j) == 'c') time = 1;
			}
		}
		
		for (int i = 0 ; i < h; i++) {
			for (int j = 0; j < w; j++) {
				System.out.print(sky[i][j] + " ");
			}
			System.out.println();
		}
		
	}
}
