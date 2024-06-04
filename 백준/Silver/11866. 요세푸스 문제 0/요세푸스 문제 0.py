import sys
input = sys.stdin.readline

n, k = map(int, input().split())
arr = [True for _ in range(n+1)]
idx = 0
result = []
for _ in range(n):
    sum = 0
    while sum < k:
        idx = idx+1
        if idx > n:
            idx %= n
        if arr[idx]:
            sum += 1   
    result.append(idx)
    arr[idx] = False
print('<'+', '.join(map(str, result))+'>')