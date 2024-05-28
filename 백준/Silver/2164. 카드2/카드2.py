from collections import deque

n = int(input())
arr = deque([i+1 for i in range(n)])
while len(arr) > 1:
    arr.popleft()
    arr.append(arr.popleft())

print(arr[0])