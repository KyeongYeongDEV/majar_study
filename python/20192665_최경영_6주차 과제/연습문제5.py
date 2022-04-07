import random

ran_num1 = random.randrange(1,101)
ran_num2 = random.randrange(1,101)
mul = int(ran_num1 - ran_num2)

print(ran_num1, "-", ran_num2, "= ")
user= int(input())

if user == mul:
    print("맞았습니다.")
else:
    print("틀렸습니다.")
