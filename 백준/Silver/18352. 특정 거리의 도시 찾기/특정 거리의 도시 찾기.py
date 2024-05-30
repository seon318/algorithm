from collections import deque
import sys
input = sys.stdin.readline

n, m, k, x = map(int, input().split())
graph = [[] for _ in range(n+1)]
distance = [0] * (n+1)
visited = [False] * (n+1)

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)

ans = []
q = deque([x])
visited[x] = True
distance[x] = 0
while q:
    now = q.popleft()
    for i in graph[now]:
        if not visited[i]:
            visited[i] = True
            q.append(i)
            distance[i] = distance[now] + 1
            if distance[i] == k:
                ans.append(i)
if len(ans):
    ans.sort()
    for i in ans:
        print(i)
else:
    print(-1)