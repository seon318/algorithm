from collections import deque
import sys
input = sys.stdin.readline

def command(x):
    if x[0] == 'push_front':
        arr.appendleft(x[1])
    elif x[0] == 'push_back':
        arr.append(x[1])
    elif x[0] == 'size':
        print(len(arr))
    elif x[0] == 'empty':
        if len(arr) == 0:
            print(1)
        else:
            print(0)
    elif len(arr) == 0:
        print(-1)
    else:
        if x[0] == 'pop_front':
            print(arr.popleft())
        elif x[0] == 'pop_back':
            print(arr.pop())
        elif x[0] == 'front':
            print(arr[0])
        elif x[0] == 'back':
            print(arr[-1])

n = int(input())
arr = deque([])
for _ in range(n):
    command(list(input().split()))