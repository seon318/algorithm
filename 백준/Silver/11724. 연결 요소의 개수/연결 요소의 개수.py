from collections import deque
import sys
input = sys.stdin.readline

def bfs(graph, start, visited):
    q = deque([start])
    visited[start] = True
    while q:
        x = q.popleft()
        for i in graph[x]:
            if not visited[i]:
                q.append(i)
                visited[i] = True

n, m = map(int, input().split())
graph = [[] for _ in range(n+1)]
visited = [False] * (n+1)
for i in range(m):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)
count = 0
for i in range(1, n+1):
    if not visited[i]:
        bfs(graph, i, visited)
        count += 1

print(count)