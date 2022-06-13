items = { "커피음료":7, "종이컵":2, "우유":1, "콜라":4, "책":5}

while True:
    num = int(input("1:추가 2:뺴기 3:수량 확인 4:종료"))
    if num ==1:
        tmp = input("어떤 상품을 수를 추가하시겠습니까>>")
        cnt = int(input("몇 개를 추가하시겠습니까"))
        items[tmp] += cnt
    elif num ==2:
        tmp =input("어떤 상품을 수를 빼시겠습니까>>")
        cnt = int(input("몇 개를 빼시겠습니까"))
        items[tmp] -= cnt
    elif num == 3:
        for key in items:
            print(key , ": ", items[key],"개 ")
    
    elif num ==4:
        print("프로그램을 종료합니다.")
        break
    else :
        print("1~3의 숫자를 입력하시오")