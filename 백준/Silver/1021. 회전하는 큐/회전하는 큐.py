import sys
input = sys.stdin.readline

n, m = map(int, input().split())
num = list(map(int, input().split()))

arr = [i for i in range(1, n+1)]
ans = 0
for i in range(m):
    idx = arr.index(num[i])
    ans += min(idx, len(arr) - idx)
    arr = arr[idx+1:] + arr[:idx]
print(ans)