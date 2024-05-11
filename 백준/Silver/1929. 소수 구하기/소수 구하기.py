import math
import sys
input = sys.stdin.readline

def prime(a):
    if a == 0 or a == 1:
        return False
    for i in range(2, int(math.sqrt(a)) + 1):
        if a % i == 0:
            return False
    return True
            
x, y = map(int, input().split())
for i in range(x, y+1):
    if prime(i):
        print(i)