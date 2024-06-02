import sys
input = sys.stdin.readline

n = int(input())
m = int(input())
loc = list(map(int, input().split()))
h = max(loc[0], n - loc[-1])

for i in range(1, m):
    dist = loc[i] - loc[i-1]
    h = max(h, (dist + 1) // 2)

print(h)