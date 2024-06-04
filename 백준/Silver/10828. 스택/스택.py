import sys
input = sys.stdin.readline

def command(x):
    if x[0] == 'push':
        arr.append(x[1])
    elif x[0] == 'pop':
        if len(arr) == 0:
            print(-1)
        else:
            print(arr.pop())
    elif x[0] == 'size':
        print(len(arr))
    elif x[0] == 'empty':
        if len(arr) == 0:
            print(1)
        else:
            print(0)
    elif x[0] == 'top':
        if len(arr) == 0:
            print(-1)
        else:
            print(arr[-1])
            
n = int(input())
arr = []
for _ in range(n):
    command(list(input().split()))