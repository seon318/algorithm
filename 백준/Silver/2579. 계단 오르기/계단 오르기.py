import sys

h = int(sys.stdin.readline())
stair = [0] + [int(sys.stdin.readline()) for i in range(1, h + 1)]
if h < 2: # 주어진 계단의 수가 2보다 작을 경우 위와 같이 stair 배열을 할당할 경우 예외처리를 해주지 않으면 index error가 발생한다
	print(stair[h])
else:
	dp = [0] * (h + 1)
	dp[1] = stair[1]
	dp[2] = dp[1] + stair[2]
	for i in range(3, h + 1):
		dp[i] = max(dp[i - 2], dp[i - 3] + stair[i - 1]) + stair[i]
	print(dp[h])