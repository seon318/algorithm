from collections import deque

def bfs(a, b, n, m):
    q = deque([n])
    bridge = [0] * 100001
    bridge[n] = 1
    while q:
        x = q.popleft()
        dx = [1, -1, a, -a, b, -b, (a-1) * x, (b-1) * x]
        for i in dx:
            nx = x + i
            if 0 <= nx < 100001 and not bridge[nx] :
                q.append(nx)
                bridge[nx] = bridge[x] + 1
                if nx == m:
                    return bridge[m] - 1
            
a, b, n, m = map(int, input().split())
print(bfs(a, b, n, m))