def dfs(arr, x, result):
        for i in range(1, x-1):
            e = arr[i-1] * arr[i+1]
            new_arr = arr[:i] + arr[i+1:]
            if len(new_arr) > 2:
                e += dfs(new_arr, x-1, 0)
            result = max(result, e)
        return result
            
n = int(input())
w = list(map(int, input().split()))
print(dfs(w, n, 0))