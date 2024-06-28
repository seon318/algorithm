t = int(input())
for x in range(1, t+1):
    num = tuple(map(int, input().split()))
    print(f"#{x} {round(sum(num)/10)}")