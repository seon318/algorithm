import sys
input = sys.stdin.readline

n, m = map(int, input().split())
basket = [list(map(int, input().split())) for _ in range(n)]
cloud = {(n-1, 0), (n-1, 1), (n-2, 0), (n-2, 1)}
mx, my = [0, -1, -1, -1, 0, 1, 1, 1], [-1, -1, 0, 1, 1, 1, 0, -1]
dx, dy = [1, 1, -1, -1], [1, -1, 1, -1]

for _ in range(m):
    d, s = map(int, input().split())
    moved_cloud = set()
    for c in cloud:
        x = (c[0] + mx[d-1] * s) % n
        y = (c[1] + my[d-1] * s) % n
        basket[x][y] += 1
        moved_cloud.add((x, y))
        
    for c in moved_cloud:
        cnt = 0
        for i in range(4):
            nx, ny = c[0] + dx[i], c[1] + dy[i]
            if 0 <= nx < n and 0 <= ny < n and basket[nx][ny] > 0:
                cnt += 1
        basket[c[0]][c[1]] += cnt

    cloud = set([])
    for i in range(n):
        for j in range(n):
            if basket[i][j] >= 2 and (i, j) not in moved_cloud:
                cloud.add((i, j))
                basket[i][j] -= 2
print(sum([sum(row) for row in basket]))