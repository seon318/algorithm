import sys
input = sys.stdin.readline
while True:
    num = str(input().rstrip())
    if num == '0':
        break
    same = 'yes'
    for i in range(len(num)//2 + 1):
        if num[i] != num[-i-1]:
            same = 'no'
            break
    print(same)