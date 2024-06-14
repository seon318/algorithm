from collections import deque
import sys
input = sys.stdin.readline

n, m = map(int, input().split())
land = []
for i in range(n):
    row = list(map(int, input().split()))
    land.append(row)
    for j in range(m):
        if row[j] == 2:
            goal = (i, j, 0)

ans = [[-1] * m for _ in range(n)]
ans[goal[0]][goal[1]] = 0
q = deque([goal])
dx, dy = [1, -1, 0, 0], [0, 0, 1, -1]
while q:
    x, y, z = q.popleft()
    for i in range(4):
        nx, ny = x + dx[i], y + dy[i]
        if 0 <= nx < n and 0 <= ny < m and land[nx][ny] == 1:
            land[nx][ny] = -1
            ans[nx][ny] = z+1
            q.append((nx, ny, z+1))

for i in range(n):
    for j in range(m):
        if land[i][j] == 0:
            ans[i][j] = 0

for row in ans:
    print(' '.join(map(str, row)))