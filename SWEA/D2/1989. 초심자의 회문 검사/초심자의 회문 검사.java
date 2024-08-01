import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		String input;
		char[] arr;
		boolean isPalindrome; //회문 여부
		for (int tc=1; tc<=t; tc++) {
			isPalindrome = true;
			input = br.readLine();
			arr = input.toCharArray();
			//가운데 글자 제외하고 양끝부터 안쪽으로 오면서 비교
			for (int i=0; i<arr.length/2; i++) {
				//만약 회문이 아닌 경우 false
				if (arr[i] != arr[arr.length-1-i]) {
					isPalindrome = false;
					break;
				}
			}
			System.out.printf("#%d %d\n", tc, isPalindrome ? 1 : 0);
		}
	}

}
