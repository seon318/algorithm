import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	static int[][] puzzle = new int[9][9];
	static int[] num;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			for (int i = 0; i < 9; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 9; j++) {
					puzzle[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			bw.append("#" + tc + " " + (check() ? 1 : 0) + "\n");
		}
		bw.flush();
	}

	static boolean check() {
		num = new int[10];
		
		// 가로줄 확인
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				num[puzzle[i][j]]++;
			}
			if (!valid()) return false;
		}

		// 세로줄 확인
		for (int j = 0; j < 9; j++) {
			for (int i = 0; i < 9; i++) {
				num[puzzle[i][j]]++;
			}
			if (!valid()) return false;
		}

		// 3*3 확인
		for (int a = 0; a < 3; a++) {
			for (int b = 0; b < 3; b++) {
				for (int i = a * 3; i < (a + 1) * 3; i++) {
					for (int j = b * 3; j < (b + 1) * 3; j++) {
						num[puzzle[i][j]]++;
					}
				}
				if (!valid()) return false;
			}
		}

		return true;
	}
    
    //단위별로 1~9까지 숫자 개수 같은지 확인
	static boolean valid() {
		for (int i = 1; i < 9; i++) {
			if (num[i] != num[i + 1]) return false;
		}
		return true;
	}
}
