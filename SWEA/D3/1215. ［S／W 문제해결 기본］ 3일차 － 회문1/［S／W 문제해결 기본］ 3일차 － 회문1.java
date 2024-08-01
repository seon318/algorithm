import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int n, ans;
	static char[][] arr = new char[8][8];;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc=1; tc<=10; tc++) {
			ans = 0;
			n = Integer.parseInt(br.readLine());
			for (int i=0; i<8; i++) {
				arr[i] = br.readLine().toCharArray();
			}
			
			//시작점 기준으로 check 돌려서 확인
			for (int i=0; i<=8-n; i++) {
				for (int j=0; j<8; j++) {
					checkRow(j, i); //가로 확인
					checkCol(i, j); //세로 확인
				}
			}
			
			System.out.printf("#%d %d\n", tc, ans);
		}
	}
	
	//절반 나눠서 밖에서 안으로 오며 확인 후 다르면 return, 모두 같으면 ans++
	static void checkCol(int x, int y) {
		for (int i=0; i<n/2; i++) {
			if (arr[x+i][y] != arr[x+n-1-i][y]) return;
		}
		ans++;
	}
	
	static void checkRow(int x, int y) {
		for (int i=0; i<n/2; i++) {
			if (arr[x][y+i] != arr[x][y+n-1-i]) return;
		}
		ans++;
	}

}
