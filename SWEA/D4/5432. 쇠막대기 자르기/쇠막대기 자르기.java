import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) throws IOException {
        //1. 초기세팅, 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack;
        int ans, idx;
        String input;
        
        int t = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= t; tc++) {
            stack = new Stack<>();
            ans = 0;
            idx = 0;
            input = br.readLine();

            //2. input의 각 indx에 대해 반복문 실행
            while (idx < input.length()) {
                if (input.charAt(idx++) == '(') { // '(' 일 경우
                    //2-1. 레이저
                    if (input.charAt(idx) == ')') {
                        idx++;
                        ans += stack.size(); //레이저를 쏠 경우 현재까지 스택에 들어 있는 개수를 추가해줌
                   //2-2. 쇠막대기 시작
                    } else {
                        stack.push(1); //스택에 쇠막대기 하나 추가
                        ans += 1; //부분 막대의 개수 추가
                    }
                //2-3. 쇠막대기 끝
                } else {
                    stack.pop(); //스택에서 쇠막대기 제거
                }
            }
            //3. 출력
            System.out.printf("#%d %d\n", tc, ans);
        }
	}
}