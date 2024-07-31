import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int t, n, tmp;
	static int[][] arr, newArr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String[] str;

		t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			str = new String[n];
            
			System.out.println("#" + tc);
			// 90도씩 3번 돌려서 str 배열의 각 인덱스에 출력 형태로 넣기
			for (int k=0; k<3; k++) {
				arr = rotate();
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (k==0 && j==0) str[i] = "";
						str[i] += arr[i][j];
					}
					str[i] += " ";
				}
			}
			
			for (int i=0; i<n; i++) {
				System.out.println(str[i]);
			}

		}
	}

	static int[][] rotate() {
		// 전치행렬
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i > j) {
					tmp = arr[i][j];
					arr[i][j] = arr[j][i];
					arr[j][i] = tmp;
				}
			}
		}
		// 역으로 할당
		newArr = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				newArr[i][j] = arr[i][n - 1 - j];
			}
		}
		// 90도 돌린 결과 반환
		return newArr;
	}

}
