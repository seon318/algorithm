import sys
input = sys.stdin.readline

n = int(input())
arr = []
time = 0
for _ in range(n):
    a, b = map(int, input().split())
    arr.append((a, b))
    time += a

arr.sort(key = lambda x : x[1])
now = 0
ans = arr[0][1]

for a, b in arr:
    now += a
    ans = min(ans, b - now)
    
if ans < 0:
    print(-1)
else:
    print(ans)