import sys
input = sys.stdin.readline

n = int(input())
arr = [tuple(map(int, input().split())) for _ in range(n)]

arr.sort(key = lambda x : x[1])
now = 0
ans = arr[0][1]

for a, b in arr:
    now += a
    if ans + now > b:
        ans = b - now
    
if ans < 0:
    print(-1)
else:
    print(ans)