n = int(input())
a = 3
b = 5
num = []
for i in range(round(n/a)+1):
    for j in range(round(n/b)+1):
        if a*i + b*j == n:
            num.append(i+j)

if len(num) == 0 :
    print(-1)
else:
    print(min(num))