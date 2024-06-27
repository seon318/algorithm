t = int(input())
for x in range(1, t+1):
    n, m = map(int, input().split())
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))
    result = 0
    if n > m:
        for i in range(n-m):
            ans = 0
            for j in range(m):
                ans += a[i+j]*b[j]
            result = max(ans, result)
    elif n == m:
        for i in range(n):
            result += a[i]*b[i]
    else:
        for i in range(m-n+1):
            ans = 0
            for j in range(n):
                ans += b[i+j]*a[j]
            result = max(ans, result)
    print(f"#{x} {result}")