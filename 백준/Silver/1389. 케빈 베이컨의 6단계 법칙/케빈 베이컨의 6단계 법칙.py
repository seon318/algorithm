INF = int(1e9)
n, m = map(int, input().split())
rel = [[INF] * (n+1) for _ in range(n+1)]
for a in range(1, n+1):
    for b in range(1, n+1):
        if a == b:
            rel[a][b] = 0
for _ in range(m):
    a, b = map(int, input().split())
    rel[a][b] = 1
    rel[b][a] = 1
for k in range(1, n+1):
    for a in range(1, n+1):
        for b in range(1, n+1):
            rel[a][b] = min(rel[a][b], rel[a][k] + rel[k][b])

rel = [sum(row[1:]) for row in rel]
print(rel.index(min(rel)))