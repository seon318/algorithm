def dfs(v):
    visited[v] = True
    for i in range(1, n+1):
        if not visited[i] and graph[v][i]:
            dfs(i)

n = int(input())
m = int(input())
graph = [[False] * (n+1) for _ in range(n+1)]
visited = [False] * (n+1)

for i in range(m):
    a, b = map(int, input().split())
    graph[a][b] = True
    graph[b][a] = True
dfs(1)
print(visited.count(True)-1)