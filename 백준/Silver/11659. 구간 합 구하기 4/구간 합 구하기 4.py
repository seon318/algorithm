import sys
input = sys.stdin.readline

n, m = map(int, input().split())
arr = list(map(int, input().split()))
sum = []
x = 0
for i in range(n):
    x += arr[i]
    sum.append(x)
for _ in range(m):
    i, j = map(int, input().split())
    if i == 1:
        print(sum[j-1])
    else:
        print(sum[j-1] - sum[i-2])