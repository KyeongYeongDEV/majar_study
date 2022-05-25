import random

conter = [0,0,0,0,0,0]

for i in range(0,1000):
    a = random.randint(1,6)
    conter[a-1]+=1
    
k = 1
for i in conter:    
    print("주사위가 ",k,"인 경우는  ",i)
    k+=1
