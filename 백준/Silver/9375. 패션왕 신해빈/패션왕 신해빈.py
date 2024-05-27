import sys
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    n = int(input())
    clothes = [input().split()[1] for _ in range(n)]
    arr = []
    num = [0] * n
    
    for cloth in clothes:
        if cloth not in arr:
            arr.append(cloth)
            num[len(arr)-1] += 1

        else:
            idx = arr.index(cloth)
            num[idx] += 1

    ans = 1
    if len(arr) > 1:
        for i in num:
            ans *= (i+1)
        print(ans - 1)
    else:
        print(n)