import heapq
import sys
input = sys.stdin.readline

n = int(input())
heap = []
for _ in range(n):
    x = int(input())
    if x == 0:
        print(0 if len(heap) == 0 else -heapq.heappop(heap))
    else:
        heapq.heappush(heap, -x)