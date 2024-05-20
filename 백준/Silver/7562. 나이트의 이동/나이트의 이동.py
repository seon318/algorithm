from collections import deque

def bfs(i, x, y, goal):
    queue = deque([(x, y, 0)])
    visited = [[False] * i for _ in range(i)]
    visited[x][y] = True
    while queue:
        x, y, num = queue.popleft()
        for a in range(8):
            nx, ny = x + dx[a], y + dy[a]
            if nx == goal[0] and ny == goal[1]:
                num += 1
                return num
            elif 0 <= nx < i and 0 <= ny < i and not visited[nx][ny]:
                visited[nx][ny] = True
                queue.append((nx, ny, num + 1))

dx = [-2, -1, 1, 2, -2, -1, 1, 2]
dy = [1, 2, 2, 1, -1, -2, -2, -1]

t = int(input())
for _ in range(t):
    i = int(input())
    x, y = list(map(int, input().split()))
    goal = list(map(int, input().split()))
    if x == goal[0] and y == goal[1]:
        print(0)
    else:
        print(bfs(i, x, y, goal))