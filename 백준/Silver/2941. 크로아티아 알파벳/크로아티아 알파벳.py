n = input()
d = ['c=','c-','dz=','d-','lj','nj','s=','z=']
 
cnt = 0
for i in d:
    while i in n:
        cnt += n.count(i)
        n = n.replace(i,'0'*len(i))
print(cnt + len(n) - n.count('0'))
 
