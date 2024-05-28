import sys
input = sys.stdin.readline

n, m = map(int, input().split())
switches = sorted([list(map(int, input().split())) for _ in range(n)])
lamp = [0] * m

for switch in switches:
    for i in range(1, len(switch)):
        lamp[switch[i]-1] += 1

for switch in switches:
    for i in range(1, len(switch)):
        lamp[switch[i]-1] -= 1
    if 0 not in lamp:
        print(1)
        exit(0)
    for i in range(1, len(switch)):
        lamp[switch[i]-1] += 1
print(0)