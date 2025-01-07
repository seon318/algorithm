class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        while (true) {
            if (Math.abs(b - a) == 1 && Math.max(a, b) % 2 == 0) break;
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            answer++;
            // System.out.println(a + " " + b + " " + answer);
        }
            
        return answer;
    }
}