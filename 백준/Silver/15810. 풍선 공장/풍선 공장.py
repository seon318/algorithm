import sys
input = sys.stdin.readline

n, m = map(int, input().split())
time = list(map(int, input().split()))

l, r = 0, max(time) * m
res = 0

while l <= r:
    mid = (l + r) // 2
    if sum([mid // i for i in time]) >= m:
        res = mid
        r = mid - 1
    else:
        l = mid + 1

print(res)