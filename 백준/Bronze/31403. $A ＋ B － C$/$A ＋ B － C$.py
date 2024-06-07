import sys
input = sys.stdin.readline

arr = [int(input()) for _ in range(3)]
print(arr[0] + arr[1] - arr[2])
print(int(str(arr[0]) + str(arr[1])) - arr[2])