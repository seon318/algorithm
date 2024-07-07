def dfs(x, arr, visited):
    global b, result
    for i in range(x+1, n):
        if not visited[i]:
            visited[i] = True
            arr.append(height[i])
            if sum(arr) >= b:
                result = min(result, sum(arr))
            else:
                dfs(i, arr, visited)
            arr.pop(-1)
            visited[i] = False
 
 
t = int(input())
for a in range(1, t+1):
    n, b = map(int, input().split())
    height = tuple(map(int, input().split()))
    visited = [False] * n
    result = float("inf")
    for i in range(n):
        if height[i] >= b:
            result = min(result, height[i])
        else:
            visited[i] = True
            arr = [height[i]]
            dfs(i, arr, visited)
            visited[i] = False
 
    print(f"#{a} {result - b}")