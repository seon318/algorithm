t = int(input())
for x in range(1, t+1):
    n = int(input())
    matrix = [list(map(str, input().split())) for _ in range(n)]
    result = [[], [], []]
    
    rotate = [[] for _ in range(n)]
    for i in range(n-1, -1, -1):
        for j in range(n):
            rotate[j].append(matrix[i][j])
    
    print(f"#{x}")
    for i in range(n):
        ans = ''
        ans += ''.join(rotate[i])
        ans += ' '+''.join(reversed(matrix[n-1-i]))
        ans += ' '+''.join(reversed(rotate[n-1-i]))
        print(ans)