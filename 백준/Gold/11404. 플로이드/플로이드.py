INF = int(1e9)

n = int(input()) #도시의 개수
m = int(input()) #버스의 개수

#버스 정보 입력
graph = [[INF] * (n+1) for _ in range(n+1)]
for i in range(m):
    a,b,c = map(int, input().split())
    graph[a][b] = min(graph[a][b], c) #a->b도시 비용 중복 노선 중 최저로 설정

#플로이드 워셜 점화식 실행
for k in range(1, n+1):
    for a in range(1, n+1):
        for b in range(1, n+1):
            graph[a][b] = min(graph[a][b], graph[a][k]+graph[k][b])

for a in range(1, n+1):
    for b in range(1, n+1):
        if a == b:
            graph[a][b] = 0 #같은 도시 이동 0
            
for a in range(1, n+1):
    for b in range(1, n+1):
        if graph[a][b] == INF:
            print(0, end=" ")
        else:
            print(graph[a][b], end=" ")
            
    print()