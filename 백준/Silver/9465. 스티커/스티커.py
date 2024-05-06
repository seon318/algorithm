import sys
input = sys.stdin.readline

t = int(input()) #테스트케이스
for i in range(t):
    n = int(input()) #스티커 길이
    arr = [list(map(int, input().split())) for _ in range(2)] #스티커 배열
    dp = [[0]*n for _ in range(2)] #스티커 배열과 동일한 형태로 dp 초기화
    dp[0][0] = arr[0][0]
    dp[1][0] = arr[1][0]
    #자신 + 왼쪽 대각선 vs 바로 왼쪽 칸 중 더 큰 값으로 갱신
    for i in range(1, n):
        dp[0][i] = max(dp[1][i-1]+arr[0][i], dp[0][i-1])
        dp[1][i] = max(dp[0][i-1]+arr[1][i], dp[1][i-1])
    #최댓값 출력
    print(max(max(dp[0]), max(dp[1])))