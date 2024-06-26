a, b = map(int, input().split())
win = [(1, 3), (2, 1), (3, 2)]
if (a, b) in win:
    print('A')
else:
    print('B')