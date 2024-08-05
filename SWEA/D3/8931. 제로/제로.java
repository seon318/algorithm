import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) throws IOException {
        //1. 초기세팅, 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack;
        int k, x, sum;
        
        int t = Integer.parseInt(br.readLine());
       
        for (int tc = 1; tc <= t; tc++) {
            stack = new Stack<>();
            k = Integer.parseInt(br.readLine());
            
            //2. k개의 정수 처리
            for (int i = 0; i < k; i++) {
            	x = Integer.parseInt(br.readLine());
            	if (x != 0) stack.push(x); //0이 아니면 삽입
            	else stack.pop(); //0이면 삭제
            }
            
            //3. 합 구하기
            sum = 0;
            while (stack.size() > 0) {
            	sum += stack.pop();
            }
            
            //4. 출력
            System.out.printf("#%d %d\n", tc, sum);
        }
	}

}