from collections import deque
import sys
input = sys.stdin.readline

def bfs():
    global n, m, maze
    visited = [[False] * m for _ in range(n)]
    dx, dy = [1, -1, 0, 0], [0, 0, 1, -1]
    q = deque([(0, 0, 1)])
    visited[0][0] = True
    while q:
        x, y, z = q.popleft()
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0 <= nx < n and 0 <= ny < m and not visited[nx][ny] and maze[nx][ny] == '1' :
                if nx == n-1 and ny == m-1:
                    print(z+1)
                q.append((nx, ny, z + 1))
                visited[nx][ny] = True
                

n, m = map(int, input().split())
maze = [input() for _ in range(n)]
bfs()