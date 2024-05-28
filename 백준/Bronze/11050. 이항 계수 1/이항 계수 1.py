n, k = map(int, input().split())
result = 1
for i in range(n):
    result *= (i+1)
for i in range(n-k):
    result /= (i+1)
for i in range(k):
    result /= (i+1)
print(int(result))