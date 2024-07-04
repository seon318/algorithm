import sys
input = sys.stdin.readline

n = int(input().strip())
fruit = list(map(int, input().strip().split()))
max_length = 0
start = 0
fruit_count = {}

for end in range(n):
    if fruit[end] in fruit_count:
        fruit_count[fruit[end]] += 1
    else:
        fruit_count[fruit[end]] = 1

    while len(fruit_count) > 2:
        fruit_count[fruit[start]] -= 1
        if fruit_count[fruit[start]] == 0:
            del fruit_count[fruit[start]]
        start += 1

    max_length = max(max_length, end - start + 1)

print(max_length)
