from collections import deque

def bfs():
    while queue:
        a, b = queue.popleft()
        for i in range(4):
            nx, ny = a+dx[i], b+dy[i]
            if 0 <= nx <n and 0 <= ny < m and box[nx][ny] == 0:
                box[nx][ny] = box[a][b] + 1
                queue.append([nx, ny])

m, n = map(int, input().split())
box = [list(map(int, input().split())) for _ in range(n)]
queue = deque([])
dx, dy = [1, -1, 0, 0], [0, 0, 1, -1]
day = 1

for i in range(n):
    for j in range(m):
        if box[i][j] == 1:
            queue.append([i, j])

bfs()
for row in box:
    for i in row:
        if i == 0:
            print(-1)
            exit(0)
    day = max(day, max(row))
print(day-1)