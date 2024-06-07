from collections import Counter
import sys
input = sys.stdin.readline

n = int(input())
arr = sorted([int(input()) for _ in range(n)])
print(round(sum(arr) / n))

print(arr[n // 2])

result = []
counter = Counter(arr)
x = max(counter.values())
for num, cnt in counter.items():
    if cnt == x:
        result.append(num)
if len(result) > 1:
    print(result[1])
else:
    print(result[0])

print(max(arr) - min(arr))