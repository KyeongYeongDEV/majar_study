import random

list =[0,0,0,0,0,0]

for i in range(1000):
    rand_num = random.randint(0,5)
    list[rand_num] += 1

for i in range(6):
    print("주사위가  " , i+1, "인 경우는 " , list[i])