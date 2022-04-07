import random
rand_num = int(random.randrange(0,100))

user = int(input("복권번호를 입력하세요"))
print("당첨번호는 " , rand_num, "입니다.")

if rand_num //10 == user //10 and rand_num%10 == user%10:
    print("상금은 50만원 입니다.")
else:
    print("당첨되지 않았습니다.")