import sys
input = sys.stdin.readline

def dfs(x, visited, num):
    global rel, result
    result = max(result, num)
    for i in range(x, m):
        u, v = rel[i][0], rel[i][1]
        if not visited[u] and not visited[v]:
            visited[u] = True
            visited[v] = True
            dfs(i + 1, visited, num + 2)
            visited[u] = False
            visited[v] = False

n, m = map(int, input().split())
rel = [tuple(map(int, input().split())) for _ in range(m)]
visited = [False for _ in range(n + 1)]
result = 0
dfs(0, visited, 0)

if result != n:
    result += 1

print(result)