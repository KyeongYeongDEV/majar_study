items = { "커피음료":7, "종이컵":2, "우유":1, "콜라":4, "책":5}

while True:
    print("1. 재고확인  2. 재고 증가  3. 재고 감소  4. 종료")
    num = int(input("실행할 기능을 눌러주세요"))

    if num == 1 :
        thing = input("어떤 물품을 확인하시겠습니까?>>")
        print(items[thing])
    elif num == 2:
        thing = input("어떤 물품의 수량을 증가하시겠습니까?>>")
        thing_num = int(input("몇 개를 증가시키겠습니까>>"))
        items[thing] = items[thing] + thing_num
        print("증가 완료!!")
    elif num == 3:
        thing = input("어떤 물품의 수량을 감소하시겠습니까?>>")
        thing_num = int(input("몇 개를 감소시키겠습니까>>"))
        items[thing] = items[thing] + thing_num
        print("감소 완료!!")
    else:
        print("종료합니다.")
        break
