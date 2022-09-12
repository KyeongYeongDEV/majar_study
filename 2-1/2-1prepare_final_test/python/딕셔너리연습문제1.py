dic = {}

while True:
    name = input("(입력모드) 이름을 입력하시오 ")

    if not name:
        break
    else:
        phone_num = int(input("전화번호를 입력하세요"))
        dic[name] = phone_num
        

while True:
    name = input("(검색모드) 이름을 입력하시오 ")
    if not name:
        break
    
    print(name," 의 전화번호는 ", dic[name], "입니다.")
