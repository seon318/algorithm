import sys
import heapq

input = sys.stdin.readline

dx, dy = [-2, -2, 0, 0, 2, 2], [-1, 1, -2, 2, -1, 1]

def move(n, r1, c1, r2, c2):
    visited = [[False] * n for _ in range(n)]
    q = [(0, r1, c1)]
    visited[r1][c1] = True
    
    while q:
        cnt, r, c = heapq.heappop(q)
        if r == r2 and c == c2:
            return cnt
        
        for i in range(6):
            nx, ny = r + dx[i], c + dy[i]
            if 0 <= nx < n and 0 <= ny < n and not visited[nx][ny]:
                visited[nx][ny] = True
                heapq.heappush(q, (cnt+1, nx, ny))
    return -1
        
n = int(input())
r1, c1, r2, c2 = map(int, input().split())
result = move(n, r1, c1, r2, c2)
print(result)