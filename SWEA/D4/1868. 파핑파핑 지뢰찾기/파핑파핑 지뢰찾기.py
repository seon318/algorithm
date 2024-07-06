dx, dy = [-1, 0, 1, -1, 1, -1, 0, 1], [1, 1, 1, 0, 0, -1, -1, -1]
 
def dfs(x, y):
    global dx, dy
    for k in range(8):
        nx, ny = x + dx[k], y + dy[k]
        if 0 <= nx < n and 0 <= ny < n and not visited[nx][ny]:
            visited[nx][ny] = True
            if new_arr[nx][ny] == 0:
                dfs(nx, ny)
 
 
t = int(input())
for a in range(1, t+1):
    n = int(input())
    arr = []
    bomb = []
    for i in range(n):
        x = input()
        for j in range(n):
            if x[j] == '*':
                bomb.append((i,j))
    new_arr = [[0] * n for _ in range(n)]
    visited = [[False] * n for _ in range(n)]
    result = 0
 
    for x, y in bomb:
        new_arr[x][y] = '*'
        visited[x][y] = True
        for k in range(8):
            nx, ny = x + dx[k], y + dy[k]
            if 0 <= nx < n and 0 <= ny < n and new_arr[nx][ny] != '*':
                new_arr[nx][ny] += 1
 
    for i in range(n):
        for j in range(n):
            if new_arr[i][j] == 0 and not visited[i][j]:
                visited[i][j] = True
                result += 1
                dfs(i, j)
 
    for i in range(n):
        for j in range(n):
            if not visited[i][j]:
                result += 1
 
    print(f"#{a} {result}")