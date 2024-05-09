import sys
input = sys.stdin.readline

n = int(input())
arr = sorted(list(map(int, input().split())))
x = int(input())

sum = 0
l, r = 0, n-1 #왼쪽, 오른쪽 투 포인터
while l < r:
    temp = arr[l] + arr[r]
    if temp == x: #x 값일 경우 sum 증가, 왼쪽 포인터 옮기기
        sum += 1
        l += 1
    elif temp < x: #왼쪽 포인터 옮기기
        l += 1
    else: #오른쪽 포인터 옮기기
        r -= 1

print(sum)