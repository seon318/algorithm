import sys
input = sys.stdin.readline

c, n = map(int, input().split())
arr = [tuple(map(int, input().split())) for _ in range(n)]
dp = [1e7 for _ in range(c+100)] #dp 테이블 초기화
dp[0] = 0

#비용, 고객 정보에 대하여 해당 고객수까지의 최소 비용 갱신
for a, b in arr:
    for i in range(b, c+100):
        dp[i] = min(dp[i-b]+a, dp[i])

print(min(dp[c:]))