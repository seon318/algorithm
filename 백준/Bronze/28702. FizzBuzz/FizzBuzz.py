import sys
input = sys.stdin.readline

arr = [input().rstrip() for _ in range(3)]
for i in range(3):
    if arr[i].isdigit():
        x = int(arr[i]) + (3-i)
        break

if x % 3 == 0 and x % 5 == 0:
    print("FizzBuzz")
elif x % 3 == 0:
    print("Fizz")
elif x % 5 == 0:
    print("Buzz")
else:
    print(x)