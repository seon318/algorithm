import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) throws IOException {
        //1. 초기세팅, 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack;
        int n;
        String input;
       
        for (int tc = 1; tc <= 10; tc++) {
            stack = new Stack<>();
            n = Integer.parseInt(br.readLine());
            input = br.readLine();

            //2. input의 각 index에 대해 반복문 실행
            for (int i = 0; i < input.length(); i++) {
            	//stack size가 0일 경우 스택에 추가하기
            	if (stack.size() == 0) stack.push(input.charAt(i));
            	else {
            		//짝이 맞는다면 스택에서 제거하기
            		if (isValid(stack.peek(), input.charAt(i))) stack.pop();
            		//아니라면 스택에 추가하기
            		else stack.push(input.charAt(i));
            	}
            }
            //3. 출력
            System.out.printf("#%d %d\n", tc, (stack.size() == 0) ? 1 : 0);
        }
	}
	
	//짝이 맞는지 확인하는 메서드 (짝이 맞으면 true, 아니면 false)
	static boolean isValid(char a, char b) {
		switch (a) {
		case '(' : return b == ')';
		case '[' : return b == ']';
		case '{' : return b == '}';
		case '<' : return b == '>';
		}
		return false;
	}
}