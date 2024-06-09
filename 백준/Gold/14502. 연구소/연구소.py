import itertools

# 입력 받기
n, m = map(int, input().split())
g = []
for _ in range(n):
    g.append(list(map(int, input().split())))

# 상하좌우 이동
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

# 모든 바이러스 퍼뜨리고 남은 안전영역 수 세기
result = []

def virus(graph):
    for i in range(n):
        for j in range(m):
            if graph[i][j] == 2:
                dfs(graph, i, j)
    result.append(sum(row.count(0) for row in graph))

# 상하좌우로 이동해서 0인 경우 2로 만들고 다시 퍼뜨리기
def dfs(graph, x, y):
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < n and 0 <= ny < m:
            if graph[nx][ny] == 0:
                graph[nx][ny] = 2
                dfs(graph, nx, ny)

# 빈칸 좌표 리스트에 넣기
wall = []
for i in range(n):
    for j in range(m):
        if g[i][j] == 0:
            wall.append([i, j])

# 모든 조합에 대해 벽을 세우고 바이러스를 퍼뜨린 뒤 안전 영역 수 계산
arr = list(itertools.combinations(wall, 3))
for w in arr:
    graph = [row[:] for row in g]  # 원래의 그래프 복사
    for x, y in w:
        graph[x][y] = 1  # 벽을 세우기
    virus(graph)  # 바이러스 퍼뜨리기

# 안전 영역의 최댓값 출력
print(max(result))
