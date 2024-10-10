public class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }

    // dfs 메서드: 현재 인덱스의 숫자를 더하거나 뺀 후 다음 숫자로 진행
    private int dfs(int[] numbers, int target, int index, int sum) {
        // 모든 숫자를 다 사용한 경우
        if (index == numbers.length) {
            // 합이 target과 같다면 1을 반환
            if (sum == target) {
                return 1;
            }
            // 같지 않다면 0을 반환
            return 0;
        }
        
        // 현재 숫자를 더하는 경우와 빼는 경우 모두 재귀 호출
        return dfs(numbers, target, index + 1, sum + numbers[index])
                + dfs(numbers, target, index + 1, sum - numbers[index]);
    }

}
