import sys
input = sys.stdin.read

def check(n):
    x = n**0.5
    if x % 1 == 0 :
        return 1
    for i in range(1, int(x)+1) :
        if (int(n-i*i)**0.5) % 1 == 0:
            return 2
    for i in range(1, int(x)+1) :
        for j in range(1, int((n-i*i)**0.5)+1) :
            if ((n-i*i-j*j)**0.5) % 1 == 0 :
                return 3
    return 4

n = int(input())
print(check(n))