def killer(x, y):
    global result
    fly = [arr[x][y], arr[x][y]]
    dx1, dy1 = [1, -1, 0, 0], [0, 0, 1, -1]
    dx2, dy2 = [1, 1, -1, -1], [1, -1, 1, -1]
    for a in range(1, m):
        for b in range(4):
            nx, ny = x + dx1[b] * a, y + dy1[b] * a
            if 0 <= nx < n and 0 <= ny < n:
                fly[0] += arr[nx][ny]
            nx, ny = x + dx2[b] * a, y + dy2[b] * a
            if 0 <= nx < n and 0 <= ny < n:
                fly[1] += arr[nx][ny]
    result = max(result, max(fly))
 
t = int(input())
for k in range(1, t+1):
    n, m = map(int, input().split())
    arr = [tuple(map(int, input().split())) for _ in range(n)]
    result = 0
    for i in range(n):
        for j in range(n):
            killer(i, j)
    print(f"#{k} {result}")