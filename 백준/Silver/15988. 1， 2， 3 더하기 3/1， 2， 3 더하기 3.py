import sys
input = sys.stdin.readline

t = int(input())
case = [int(input()) for _ in range(t)]
dp = [0] * (max(case)+1)
dp[1], dp[2], dp[3] = 1, 2, 4
for i in range(4, len(dp)):
    dp[i] = (dp[i-1] + dp[i-2] + dp[i-3])% 1000000009

for c in case:
    print(dp[c] )
