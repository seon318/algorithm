import sys
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    n, m = map(int, input().split())
    arr = list(map(int, input().split()))
    
    result = 1
    while arr:
        if arr[0] < max(arr):
            arr.append(arr.pop(0))
        else:
            if m == 0:
                break
            arr.pop(0)
            result += 1
        
        m = m - 1 if m > 0 else len(arr) - 1
    print(result)