import java.util.ArrayList;

public class Solution {
    public int solution(int N, int number) {
        // N을 1번, 2번 ... 8번 사용해서 만들 수 있는 숫자를 저장할 리스트 배열
        ArrayList<ArrayList<Integer>> dp = new ArrayList<>();
        
        // dp 리스트 초기화 (인덱스 0은 사용하지 않음)
        for (int i = 0; i <= 8; i++) {
            dp.add(new ArrayList<>());
        }

        // N을 i번 사용했을 때의 값은 N을 i번 이어붙인 수
        for (int i = 1; i <= 8; i++) {
            // ex) N = 5라면, i가 1일 때는 5, i가 2일 때는 55, 555, 5555...
            int num = Integer.parseInt(String.valueOf(N).repeat(i));
            dp.get(i).add(num);
        }

        // 동적 계획법으로 N을 1번부터 8번까지 사용해서 목표 숫자를 찾기
        for (int i = 1; i <= 8; i++) {
            // N을 i번 사용한 경우의 리스트에 대해 연산을 수행
            for (int j = 1; j < i; j++) {
                ArrayList<Integer> set1 = dp.get(j);
                ArrayList<Integer> set2 = dp.get(i - j);

                // set1의 숫자들과 set2의 숫자들을 이용해 사칙연산 수행
                for (int num1 : set1) {
                    for (int num2 : set2) {
                        dp.get(i).add(num1 + num2);  // 덧셈
                        dp.get(i).add(num1 - num2);  // 뺄셈
                        dp.get(i).add(num1 * num2);  // 곱셈
                        if (num2 != 0) {
                            dp.get(i).add(num1 / num2);  // 나눗셈
                        }
                    }
                }
            }
            
            // i번 사용해서 number를 만들 수 있으면 i 반환
            if (dp.get(i).contains(number)) {
                return i;
            }

            // 중복 제거 (ArrayList 안의 중복 값 제거)
            ArrayList<Integer> temp = new ArrayList<>();
            for (int num : dp.get(i)) {
                if (!temp.contains(num)) {
                    temp.add(num);
                }
            }
            dp.set(i, temp);
        }

        // 8번을 넘어가면 -1 반환
        return -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(5, 12));  // 예시 출력: 4
    }
}
