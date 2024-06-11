import sys
input = sys.stdin.readline

def find(start, size, r, c):
    global ans
    if size == 1:
        ans = start
        return
    
    half = size // 2
    
    if r < half and c < half:
        find(start, half, r, c)
    elif r < half and c >= half:
        find(start + half * half, half, r, c - half)
    elif r >= half and c < half:
        find(start + 2 * half * half, half, r - half, c)
    else:
        find(start + 3 * half * half, half, r - half, c - half)

n, r, c = map(int, input().split())
ans = 0
find(0, 2 ** n, r, c)
print(ans)
