import sys
import heapq
from math import inf

input = sys.stdin.readline

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

def move(n, cave):
    distance = [[inf] * n for _ in range(n)]
    queue = [(cave[0][0], 0, 0)]
    distance[0][0] = cave[0][0]
    
    while queue:
        cost, x, y = heapq.heappop(queue)
        
        if distance[x][y] < cost:
            continue
        
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            
            if 0 <= nx < n and 0 <= ny < n:
                new_cost = cost + cave[nx][ny]
                
                if new_cost < distance[nx][ny]:
                    distance[nx][ny] = new_cost
                    heapq.heappush(queue, (new_cost, nx, ny))
    
    return distance[n-1][n-1]

num = 1
while True:
    n = int(input().strip())
    if n == 0:
        break
    cave = [list(map(int, input().split())) for _ in range(n)]
    
    ans = move(n, cave)
    
    print(f'Problem {num}: {ans}')
    num += 1
