import heapq

n, t, p = map(int, input().split())
times = [tuple(map(lambda x: int(x[:2]) * 60 + int(x[2:]), input().split())) for _ in range(t)]

seats = [[0] * 721 for _ in range(n + 1)]

def get_best_seat():
    max_dist = 0
    best_seat = 1
    for i in range(1, n + 1):
        if visited[i]:
            continue
        left_dist = right_dist = float('inf')

        for j in range(i - 1, 0, -1):
            if visited[j]:
                left_dist = i - j
                break
        
        for j in range(i + 1, n + 1):
            if visited[j]:
                right_dist = j - i
                break
        
        dist = min(left_dist, right_dist)
        if dist > max_dist:
            max_dist = dist
            best_seat = i
        elif dist == max_dist and i < best_seat:
            best_seat = i
    
    return best_seat

times.sort()

visited = [False] * (n + 1)

ans = 720
pq = []

for start, end in times:
    while pq and pq[0][0] <= start:
        _, seat = heapq.heappop(pq)
        visited[seat] = False

    best_seat = get_best_seat()
    if best_seat == p:
        ans -= end - start

    visited[best_seat] = True
    heapq.heappush(pq, (end, best_seat))

print(ans)
