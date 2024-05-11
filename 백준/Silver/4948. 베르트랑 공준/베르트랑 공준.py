import math
import sys
input = sys.stdin.readline

def prime(a):
    arr = [True] * (2*a+1)
    m = int((2*a+1) ** 0.5)
    for i in range(2, m+1):
        if arr[i] == True:
            for j in range(i+i, 2*a+1, i):
                arr[j] = False
    return [i for i in range(a+1, 2*a+1) if arr[i] == True]
            
while True:
    n = int(input())
    if n == 0:
        break
    print(len(prime(n)))