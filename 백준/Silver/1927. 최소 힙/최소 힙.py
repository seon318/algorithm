import heapq
import sys
input = sys.stdin.readline

n = int(input())
arr = []
for i in range(n):
    x = int(input())
    if x == 0:
        if len(arr):
            print(heapq.heappop(arr))
        else:
            print(0)
    else:
        heapq.heappush(arr, x)