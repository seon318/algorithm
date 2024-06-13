from collections import deque
import sys
input = sys.stdin.readline

n, k = map(int, input().split())
visited = [False] * 100001
q = deque([(n, 0)])
visited[n] = True

while q:
    x, y = q.popleft()
    if x == k:
        print(y)
        break
    if x + 1 < 100001 and not visited[x + 1]:
        q.append((x + 1, y + 1))
        visited[x + 1] = True
    if x - 1 >= 0 and not visited[x - 1]:
        q.append((x - 1, y + 1))
        visited[x - 1] = True
    if 2 * x < 100001 and not visited[2 * x]:
        q.append((2 * x, y + 1))
        visited[2 * x] = True
