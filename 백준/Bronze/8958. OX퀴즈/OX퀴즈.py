t = int(input())
for i in range(t):
    sum = 0
    string = list(map(str, input().split('X')))
    string = [i for i in string if i != '']
    arr = [len(i) for i in string]
    for x in arr:
        for k in range(x):
            sum += k+1
    print(sum)