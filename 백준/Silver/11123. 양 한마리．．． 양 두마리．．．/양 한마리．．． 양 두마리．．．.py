import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**7)

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

def check(x, y):
    global visited
    for i in range(4):
        nx, ny = x + dx[i], y + dy[i]
        if 0 <= nx < h and 0 <= ny < w and arr[nx][ny] == '#' and not visited[nx][ny]:
            visited[nx][ny] = True
            check(nx, ny)
            
t = int(input())
for _ in range(t):
    h, w = map(int, input().split())
    arr = [input() for _ in range(h)]
    visited = [[False] * w for _ in range(h)]
    count = 0
    for i in range(h):
        for j in range(w):
            if not visited[i][j] and arr[i][j] == '#':
                count += 1
                visited[i][j] = True
                check(i, j)
    print(count)