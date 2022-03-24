num = int(input("정수를 입력하세요"))
sum =0

sum += num %10
num //= 10
sum += num %10
num //= 10
sum += num %10
num //= 10
sum += num 

print("자리수의 합 " , sum)
