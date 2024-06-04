import sys
input = sys.stdin.readline
t = int(input())
for _ in range(t):
    str = ''.join(input().rstrip().split('()'))
    while True:
        new_str = ''.join(str.split('()'))
        if new_str == str:
            break
        else:
            str = new_str
    if str == '':
        print('YES')
    else:
        print('NO')