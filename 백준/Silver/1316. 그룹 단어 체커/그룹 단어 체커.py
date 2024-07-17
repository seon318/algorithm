n = int(input())
answer = 0

for i in range(n):
    a = input()
    check = 0
    for j in range(len(a)):
        b = a.count(a[j])
        c = a.find(a[j]*b)
        if c == -1:
            check+=0
        else:
            check+=1
    if check == len(a):
        answer+=1
print(answer)